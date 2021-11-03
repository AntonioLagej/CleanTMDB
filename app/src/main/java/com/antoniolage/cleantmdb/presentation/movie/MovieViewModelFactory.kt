package com.antoniolage.cleantmdb.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antoniolage.cleantmdb.domain.usecase.GetMovieUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateMoviesUsecase

class MovieViewModelFactory(
    private val getMovieUsecase: GetMovieUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
    ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return MovieViewModel(getMovieUsecase,updateMoviesUsecase) as T
    }

}