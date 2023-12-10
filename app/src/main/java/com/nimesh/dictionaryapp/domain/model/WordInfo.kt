package com.nimesh.dictionaryapp.domain.model

data class WordInfo(
    val meaning: List<Meaning>,
    val phonetic: String,
    val word: String
)
