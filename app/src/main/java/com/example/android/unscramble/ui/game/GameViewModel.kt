package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    init{
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }
    private var score = 0
    private var currentWordCount = 0
    private lateinit var _currentScrambledWord: String
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    val currentScrambledWord: String get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (tempWord.toString().equals(currentWord, false)) {
            tempWord.shuffle()
        }
        Log.d("currentWord", currentWord)
        if(wordsList.isEmpty())
            Log.d("wordsList", "empty")
        else{
            Log.d("wordsList", "not empty")
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }
}