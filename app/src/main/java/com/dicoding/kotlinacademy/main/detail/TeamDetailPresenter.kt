package com.dicoding.kotlinacademy.main.detail

import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.api.TheSportDBApi
import com.dicoding.kotlinacademy.main.teams.CoroutineContextProvider
import com.dicoding.kotlinacademy.model.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view:TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson : Gson,private val contextPool : CoroutineContextProvider= CoroutineContextProvider()){

    fun getTeamDetail(teamId: String) {
        view.showLoading()
        async(contextPool.main) {
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                        TeamResponse::class.java)
            }
                view.showTeamDetail(data.await().teams)
                view.hideLoading()
            }
        }
}
