package com.dicoding.kotlinacademy.main.home_activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dicoding.kotlinacademy.R
import com.dicoding.kotlinacademy.R.id.favorites
import com.dicoding.kotlinacademy.R.id.teams
import com.dicoding.kotlinacademy.main.favorites_teams.FavoritesTeamsFragment
import com.dicoding.kotlinacademy.main.teams.TeamsFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener({item ->
            when(item.itemId){
                teams ->{
                    loadTeamsFragment(savedInstanceState)
                }
                favorites ->{
                    loadFavoriteTeamsFragment(savedInstanceState)
                }
            }
            true
        })

        bottom_navigation.selectedItemId = teams
    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.simpleName)
                    .commit()
        }
    }

    private fun loadFavoriteTeamsFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoritesTeamsFragment(), FavoritesTeamsFragment::class.simpleName)
                    .commit()
        }
    }
}