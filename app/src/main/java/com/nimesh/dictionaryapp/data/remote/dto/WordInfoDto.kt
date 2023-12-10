package com.nimesh.dictionaryapp.data.remote.dto

import com.nimesh.dictionaryapp.data.local.entity.WordInfoEntity
import com.nimesh.dictionaryapp.domain.model.WordInfo

data class WordInfoDto(
    val meaning: List<MeaningDto>?,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meaning = meaning?.map { it.toMeaning() } ?: emptyList(),
            phonetic = phonetic,
            word = word
        )
    }
}