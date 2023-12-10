package com.nimesh.dictionaryapp.data.remote.dto

import com.nimesh.dictionaryapp.domain.model.Defination

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinition(): Defination {
        return Defination(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}