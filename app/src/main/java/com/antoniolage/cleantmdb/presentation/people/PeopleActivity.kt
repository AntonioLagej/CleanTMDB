package com.antoniolage.cleantmdb.presentation.people

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoniolage.cleantmdb.R
import com.antoniolage.cleantmdb.databinding.ActivityPeopleBinding
import com.antoniolage.cleantmdb.presentation.di.Injector
import javax.inject.Inject

class PeopleActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: PeopleViewModelFactory
    private lateinit var peopleViewModel: PeopleViewModel
    private lateinit var adapter:PeopleAdapter
    private lateinit var binding: ActivityPeopleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people)
        (application as Injector).createPersonSubComponent()
            .inject(this)

        peopleViewModel= ViewModelProvider(this,factory)
            .get(PeopleViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PeopleAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = peopleViewModel.getPeople()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShows(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = peopleViewModel.updatePeople()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}