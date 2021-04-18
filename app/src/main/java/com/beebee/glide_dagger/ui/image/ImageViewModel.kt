package com.beebee.glide_dagger.ui.image

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ImageViewModel @Inject constructor(application: Application) : ViewModel() {
	init {
		val tag = "ImageViewModel"

		Log.d(tag, "Hellow orld: hello hello")
	}
}