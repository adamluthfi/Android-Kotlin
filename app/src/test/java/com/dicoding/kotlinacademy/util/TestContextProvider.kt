package com.dicoding.kotlinacademy.util

import com.dicoding.kotlinacademy.main.teams.CoroutineContextProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

class TestContextProvider : CoroutineContextProvider(){
    override val main: CoroutineContext = Unconfined
}