package com.example.login


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login.Usuarios.Users
import com.example.login.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.btnLogin.setOnClickListener() = with(binding) {
            val email = etUser.text.toString()
            val senha = etPassword.text.toString()

            if(email == null){

        }else if(email /=) {

            }
    }

        val u = Users("picpay123", "Carlos Eduardo", 21, "carlos.eduardo@picpay.com")
    }
}