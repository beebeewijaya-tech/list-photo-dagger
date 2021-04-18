package com.beebee.glide_dagger.ui.list_image

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.beebee.glide_dagger.R
import com.beebee.glide_dagger.databinding.ActivityListImageBinding
import com.beebee.glide_dagger.network.IImageService
import com.beebee.glide_dagger.ui.image.ImageActivity
import com.beebee.glide_dagger.viewmodels.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ListImageActivity : DaggerAppCompatActivity() {
	private lateinit var binding: ActivityListImageBinding

	private lateinit var viewModel: ListImageViewModel

	@Inject
	lateinit var viewModelFactory: ViewModelFactory

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_list_image)

		viewModel = ViewModelProvider(this, viewModelFactory).get(ListImageViewModel::class.java)

		val adapter = ListImageAdapter(ImageClickListener {
			val intent = Intent(this, ImageActivity::class.java)
			startActivity(intent)
		})
		binding.listImage.adapter = adapter


		viewModel.listImage.observe(this, Observer {
			it?.let {
				adapter.submitList(it)
			}
		})
	}
}