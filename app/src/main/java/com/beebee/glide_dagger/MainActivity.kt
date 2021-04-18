package com.beebee.glide_dagger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.beebee.glide_dagger.databinding.ActivityMainBinding
import com.beebee.glide_dagger.ui.list_image.ListImageActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonList.setOnClickListener {
            val intent = Intent(this, ListImageActivity::class.java)
            startActivity(intent)
        }
    }
}