package com.example.webservice.view

import androidx.lifecycle.ViewModelProvider
import coil.load
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webservice.databinding.ActivityMainBinding
import com.example.webservice.model.JokeResponse

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
    viewModel.loadJoke()
    viewModel.jokeData.observe(this, ::updateJokeData)

    initComponents()
    }

    private fun initComponents() {
        binding.buttonNewJoke.setOnClickListener { viewModel.loadJoke() }
    }

    private fun updateJokeData(jokeData: JokeResponse) {
        binding.apply {
            textviewSetup.text = jokeData.setup
            textviewPunchline.text = jokeData.punchline
        }
    }
}