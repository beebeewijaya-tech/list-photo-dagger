package com.beebee.glide_dagger.ui.image

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.beebee.glide_dagger.R
import com.beebee.glide_dagger.databinding.ActivityImageBinding
import com.beebee.glide_dagger.viewmodels.ViewModelFactory
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ImageActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityImageBinding

    private lateinit var viewModel: ImageViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var provideGlidesInstance : RequestManager

    @Inject
    lateinit var provideImageUrl : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ImageViewModel::class.java)

        setImage()
    }

    private fun setImage() {
        provideGlidesInstance
            .load(provideImageUrl)
            .into(binding.mainImage)
    }
}