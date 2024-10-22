package com.example.movie_app

import androidx.appcompat.app.AppCompatActivity


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movie_app.databinding.ActivityShowBinding
import com.example.movie_app.utils.MySharedPreference


class ShowActivity : AppCompatActivity() {
    private val binding by lazy { ActivityShowBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val keyPosition = intent.getIntExtra("p", 0)

        binding.name.text = MySharedPreference.list[keyPosition].name
        binding.authors.text = MySharedPreference.list[keyPosition].authors
        binding.about.text = MySharedPreference.list[keyPosition].about
        binding.data.text = MySharedPreference.list[keyPosition].data

    }
}