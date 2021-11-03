package com.antoniolage.cleantmdb.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.antoniolage.cleantmdb.domain.usecase.GetTVshowUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateTvShowUsecase

class TVShowViewModel(
 private val getTVshowUsecase: GetTVshowUsecase,
 private val updateTvShowUsecase: UpdateTvShowUsecase
):ViewModel() {
fun getTVShows() = liveData {
    val tvShowList = getTVshowUsecase.execute()
    emit(tvShowList)
}
fun updateTVShows() = liveData {
    val tvShowList = updateTvShowUsecase.execute()
    emit(tvShowList)
}
}