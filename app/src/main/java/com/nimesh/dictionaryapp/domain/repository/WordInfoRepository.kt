package com.nimesh.dictionaryapp.domain.repository

import com.nimesh.dictionaryapp.data.util.Resource
import com.nimesh.dictionaryapp.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}