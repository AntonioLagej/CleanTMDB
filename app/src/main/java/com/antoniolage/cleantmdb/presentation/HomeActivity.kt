package com.antoniolage.cleantmdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.antoniolage.cleantmdb.R
import com.antoniolage.cleantmdb.databinding.ActivityHomeBinding
import com.antoniolage.cleantmdb.presentation.movie.MovieActivity
import com.antoniolage.cleantmdb.presentation.people.PeopleActivity
import com.antoniolage.cleantmdb.presentation.tvshows.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.movieButton.setOnClickListener {
            val intent=Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }
        binding.tvButton.setOnClickListener {
            val intent=Intent(this,TVShowActivity::class.java)
            startActivity(intent)
        }
        binding.artistsButton.setOnClickListener {
            val intent=Intent(this,PeopleActivity::class.java)
            startActivity(intent)
        }
    }
}