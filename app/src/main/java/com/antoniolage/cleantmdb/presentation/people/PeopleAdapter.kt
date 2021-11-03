package com.antoniolage.cleantmdb.presentation.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.antoniolage.cleantmdb.data.model.people.Person
import com.antoniolage.cleantmdb.databinding.ListItemBinding
import com.antoniolage.cleantmdb.R


import com.bumptech.glide.Glide


class PeopleAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val personList = ArrayList<Person>()

    fun setList(people:List<Person>){
        personList.clear()
        personList.addAll(people)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(personList[position])
    }
}



class MyViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bind(person: Person){
        binding.titleTextView.text = person.name
        binding.descriptionTextView.text = person.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500"+person.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}