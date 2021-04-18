package com.beebee.glide_dagger.ui.list_image

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beebee.glide_dagger.domain.Image
import com.beebee.glide_dagger.network.IImageService
import com.beebee.glide_dagger.repository.ImageRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListImageViewModel @Inject constructor(
    retrofitApi: IImageService
) : ViewModel() {
    private val imageRepository = ImageRepository(retrofitApi)

    private val _listImage = MutableLiveData<List<Image>>()
    val listImage : LiveData<List<Image>>
        get() = _listImage

    init {
        viewModelScope.launch {
            val data = imageRepository.getAllImage()
            _listImage.value = data
            Log.i("FUCKKKKKKK", "Fuck: $data")
        }

        if (retrofitApi == null) {
            Log.d("Hello", "retrofitApi is null")
        } else {
            Log.d("Hello", "retrofitApi is not null")
        }
    }
}