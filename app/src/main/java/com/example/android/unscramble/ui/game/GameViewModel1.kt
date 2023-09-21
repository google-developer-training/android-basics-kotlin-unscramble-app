package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel1 :  ViewModel(){
    init {
        Log.d("GameFragment", "GameViewModel created!")
    }

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment","GameViewModel destroyed!")
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
    }






}