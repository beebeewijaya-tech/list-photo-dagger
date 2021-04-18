package com.beebee.glide_dagger.di.list_image

import androidx.lifecycle.ViewModel
import com.beebee.glide_dagger.di.ViewModelKey
import com.beebee.glide_dagger.ui.list_image.ListImageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListImageViewModelModule {
	@Binds
	@IntoMap
	@ViewModelKey(ListImageViewModel::class)
	abstract fun bindImageViewModel(viewModel: ListImageViewModel): ViewModel
}