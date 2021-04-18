package com.beebee.glide_dagger.di

import android.app.Application
import com.beebee.glide_dagger.R
import com.beebee.glide_dagger.network.Network
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun retrofitService(): Retrofit {
        return Network.retrofit
    }

    @Singleton
    @Provides
    fun requestOptions() : RequestOptions {
        return RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
    }

    @Singleton
    @Provides
    fun provideGlidesInstance(application: Application, requestOptions: RequestOptions) : RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun provideImageUrl() : String {
        return "https://marvelwanda.files.wordpress.com/2015/07/scarlet-witch-loves-getting-naked-says-elizabeth-olsen-379901.jpg?w=768"
    }
}