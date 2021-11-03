package com.antoniolage.cleantmdb.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.antoniolage.cleantmdb.R
import com.antoniolage.cleantmdb.data.model.movies.Movie
import com.antoniolage.cleantmdb.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter:RecyclerView.Adapter<MyViewHolder>(){
    private val movieList= ArrayList<Movie>()
    fun setList(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding= DataBindingUtil.inflate(layoutInflater,
            R.layout.list_item,parent,
            false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return  movieList.size
    }

}
class MyViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root)
{
    fun bind(movie:Movie){
        binding.titleTextView.text=movie.title
        binding.descriptionTextView.text=movie.overview
        val posterURL= "https://image.tmdb.org/t/p/w500/"+movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}