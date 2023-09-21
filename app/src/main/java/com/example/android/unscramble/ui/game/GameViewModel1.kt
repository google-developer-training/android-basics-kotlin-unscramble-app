package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel1 :  ViewModel(){
    init {
        Log.d("GameFragment", "GameViewModel created!")
    }

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    private lateinit var _currentScrambledWord: String
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment","GameViewModel destroyed!")
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }
    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }




}