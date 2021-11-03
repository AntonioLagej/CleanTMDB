package com.antoniolage.cleantmdb.domain.usecase

import com.antoniolage.cleantmdb.data.model.tvshows.TVShow
import com.antoniolage.cleantmdb.domain.repository.TVshowRepository

class GetTVshowUsecase(private val tVshowRepository: TVshowRepository) {
    suspend fun execute():List<TVShow>? = tVshowRepository.getTVshows()

}