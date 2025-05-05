package com.ismailballi.carappcompose.di

import com.ismailballi.carappcompose.data.api.CarApi
import com.ismailballi.carappcompose.data.repository.CarRepositoryImpl
import com.ismailballi.carappcompose.domain.repository.CarRepository
import com.ismailballi.carappcompose.util.Constanst.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesApi(): CarApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().also {
                    it.level = HttpLoggingInterceptor.Level.BODY
                }).build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CarApi::class.java)


    @Singleton
    @Provides
    fun providesRepository(carApi: CarApi): CarRepositoryImpl = CarRepository(carApi)

}