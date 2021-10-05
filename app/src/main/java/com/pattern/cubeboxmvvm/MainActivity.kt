package com.pattern.cubeboxmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pattern.cubeboxmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainClassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainClassViewModel::class.java]
        hasil()
        binding.btnResult.setOnClickListener {
            val p = binding.panjang.text.toString()
            val l = binding.lebar.text.toString()
            val t = binding.tinggi.text.toString()
            when {
                p.isEmpty() -> binding.panjang.error = "isi"
                l.isEmpty() -> binding.lebar.error = "isi"
                t.isEmpty() -> binding.tinggi.error = "isi"
                else -> {
                    viewModel.setResult(p.toInt(),l.toInt(),t.toInt())

                }
            }
        }



    }

    fun hasil() {
        viewModel.result.observe(this, {
            binding.result.text = it.toString()
        })
    }
}