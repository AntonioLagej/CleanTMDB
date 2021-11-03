package com.antoniolage.cleantmdb.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antoniolage.cleantmdb.domain.usecase.GetMovieUsecase
import com.antoniolage.cleantmdb.domain.usecase.GetTVshowUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateMoviesUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateTvShowUsecase

class TVShowViewModelFactory(
    private val getTVshowUsecase: GetTVshowUsecase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
    ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return TVShowViewModel(getTVshowUsecase,updateTvShowUsecase) as T
    }

}