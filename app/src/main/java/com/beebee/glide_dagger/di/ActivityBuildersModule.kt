package com.beebee.glide_dagger.di

import com.beebee.glide_dagger.di.image.ImageViewModelModule
import com.beebee.glide_dagger.di.list_image.ListImageModule
import com.beebee.glide_dagger.di.list_image.ListImageViewModelModule
import com.beebee.glide_dagger.ui.image.ImageActivity
import com.beebee.glide_dagger.ui.list_image.ListImageActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class  ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [ImageViewModelModule::class]
    )
    abstract fun injectImageActivity() : ImageActivity

    @ContributesAndroidInjector(
        modules = [ListImageModule::class, ListImageViewModelModule::class]
    )
    abstract fun injectListImageActivity() : ListImageActivity
}