package com.beebee.glide_dagger.di.list_image

import com.beebee.glide_dagger.network.IImageService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ListImageModule {

    @Provides
    fun imageService(retrofitService: Retrofit) : IImageService {
        return retrofitService.create(IImageService::class.java)
    }
}