package com.nimesh.dictionaryapp.domain.model

import com.nimesh.dictionaryapp.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Defination>,
    val partOfSpeech: String,
)
