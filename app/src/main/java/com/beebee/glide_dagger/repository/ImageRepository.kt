package com.beebee.glide_dagger.repository

import com.beebee.glide_dagger.domain.Image
import com.beebee.glide_dagger.network.IImageService
import com.beebee.glide_dagger.network.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepository(private val retrofit: IImageService) : IImageRepository{
    override suspend fun getAllImage(): List<Image> {
        var listImage = listOf<Image>()
        withContext(Dispatchers.IO) {
            val data = retrofit.getAllPhotos().asDomainModel()
            listImage = data
            return@withContext
        }
        return listImage
    }
}