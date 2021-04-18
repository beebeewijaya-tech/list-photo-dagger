package com.beebee.glide_dagger.di.image

import androidx.lifecycle.ViewModel
import com.beebee.glide_dagger.di.ViewModelKey
import com.beebee.glide_dagger.ui.image.ImageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ImageViewModelModule {

	@Binds
	@IntoMap
	@ViewModelKey(ImageViewModel::class)
	abstract fun bindImageViewModel(viewModel: ImageViewModel): ViewModel
}