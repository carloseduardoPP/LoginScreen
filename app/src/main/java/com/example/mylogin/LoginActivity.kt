package com.example.mylogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class LoginActivity:AppCompatActivity(){
    //private lateinit var binding: ActitvityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        //binding = ActitvityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.actitvity_login)

//        val responseName = binding.responseName
//        val responseAge = binding.responseAge
//        val responseEmail = binding.responseEmail
    }
//
//    fun setLogin() = with(binding){
//        val email = tvLogin.text.toString()
//    }

    fun responseScreen(response: String){
        val users = Users("carlos.eduardo@picpay.com","picpay123", "Carlos Eduardo", 21,"carlos.eduardo")
    }
}
