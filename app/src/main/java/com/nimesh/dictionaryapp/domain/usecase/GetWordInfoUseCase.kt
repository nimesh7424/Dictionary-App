package com.nimesh.dictionaryapp.domain.usecase

import com.nimesh.dictionaryapp.data.util.Resource
import com.nimesh.dictionaryapp.domain.model.WordInfo
import com.nimesh.dictionaryapp.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfoUseCase(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}