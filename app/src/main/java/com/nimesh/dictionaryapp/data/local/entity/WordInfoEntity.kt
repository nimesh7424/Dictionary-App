package com.nimesh.dictionaryapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nimesh.dictionaryapp.domain.model.Meaning
import com.nimesh.dictionaryapp.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val meaning: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meaning = meaning,
            phonetic = phonetic,
            word = word
        )
    }
}
