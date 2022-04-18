package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel
import androidx.fragment.app.viewModels

class GameViewModel : ViewModel() {
    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"
    val currentScrambledWord get() = _currentScrambledWord


}