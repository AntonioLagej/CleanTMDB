package com.antoniolage.cleantmdb.data.model.people


import com.google.gson.annotations.SerializedName

data class PeopleList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val people: List<Person>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)