package com.nimesh.dictionaryapp.presentation

import com.nimesh.dictionaryapp.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
