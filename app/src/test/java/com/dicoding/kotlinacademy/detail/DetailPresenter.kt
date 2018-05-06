package com.dicoding.kotlinacademy.detail

import com.dicoding.kotlinacademy.api.ApiRepository
import com.dicoding.kotlinacademy.api.TheSportDBApi
import com.dicoding.kotlinacademy.main.detail.TeamDetailPresenter
import com.dicoding.kotlinacademy.main.detail.TeamDetailView
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

class DetailPresenter{

    @Mock
    private
    lateinit var view : TeamDetailView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter: TeamDetailPresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = TeamDetailPresenter(view,apiRepository,gson,TestContextProvider())
    }

    @Test
    fun testGetTeamDetail(){
        val teams : MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val id = "1234"

        `when`(gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamDetail(id)),TeamResponse::class.java)).thenReturn(response)

        presenter.getTeamDetail(id)

        verify(view).showLoading()
        verify(view).showTeamDetail(teams)
        verify(view).hideLoading()
    }
}