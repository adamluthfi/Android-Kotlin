package com.dicoding.kotlinacademy.main.teams

import com.dicoding.kotlinacademy.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}
