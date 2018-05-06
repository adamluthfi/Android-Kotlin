package com.dicoding.kotlinacademy.Teams

import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.api.TheSportDBApi
import com.dicoding.kotlinacademy.main.teams.TeamsPresenter
import com.dicoding.kotlinacademy.main.teams.TeamsView
import com.dicoding.kotlinacademy.model.Team
import com.dicoding.kotlinacademy.model.TeamResponse
import com.dicoding.kotlinacademy.util.TestContextProvider
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TeamsPresenterTest{

    @Mock
    private
    lateinit var view : TeamsView

    @Mock
    private
    lateinit var gson : Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter:TeamsPresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view,apiRepository,gson, TestContextProvider())
    }
    @Test
    fun testGetTeamList(){
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val league = "English Premiere League"

        `when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java)).thenReturn(response)

        presenter.getTeamList(league)

        verify(view).showLoading()
        verify(view).showTeamList(teams)
        verify(view).hideLoading()
    }
}