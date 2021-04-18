package com.beebee.glide_dagger.di

import androidx.lifecycle.ViewModelProvider
import com.beebee.glide_dagger.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}