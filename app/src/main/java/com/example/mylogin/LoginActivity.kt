package com.example.mylogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mylogin.databinding.ActitvityLoginBinding


open class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActitvityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActitvityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Validacao().validate()
    }
}
