package com.nimesh.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.nimesh.dictionaryapp.data.local.Converters
import com.nimesh.dictionaryapp.data.local.WordInfoDatabase
import com.nimesh.dictionaryapp.data.remote.DictionaryApi
import com.nimesh.dictionaryapp.data.remote.DictionaryApi.Companion.BASE_URL
import com.nimesh.dictionaryapp.data.repository.WordInfoRepositoryImpl
import com.nimesh.dictionaryapp.data.util.GsonParser
import com.nimesh.dictionaryapp.domain.repository.WordInfoRepository
import com.nimesh.dictionaryapp.domain.usecase.GetWordInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfoUseCase {
        return GetWordInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        api: DictionaryApi, db: WordInfoDatabase
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.wordInfoDao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(DictionaryApi::class.java)
    }

}