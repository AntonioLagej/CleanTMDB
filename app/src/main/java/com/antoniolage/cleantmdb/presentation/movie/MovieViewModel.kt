package com.antoniolage.cleantmdb.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.antoniolage.cleantmdb.domain.usecase.GetMovieUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
 private val getMovieUsecase: GetMovieUsecase,
 private val updateMoviesUsecase: UpdateMoviesUsecase
):ViewModel() {
fun getMovies() = liveData {
    val movieList = getMovieUsecase.execute()
    emit(movieList)
}
fun updateMovies() = liveData {
    val movieList = updateMoviesUsecase.execute()
    emit(movieList)
}
}