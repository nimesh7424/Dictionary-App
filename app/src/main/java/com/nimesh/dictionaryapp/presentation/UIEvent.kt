package com.nimesh.dictionaryapp.presentation

sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }