package com.beebee.glide_dagger.repository

import com.beebee.glide_dagger.domain.Image

interface IImageRepository {
    suspend fun getAllImage() : List<Image>
}