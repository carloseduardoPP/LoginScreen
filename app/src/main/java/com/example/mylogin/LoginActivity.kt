package com.example.mylogin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.mylogin.databinding.ActitvityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.*

open class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActitvityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActitvityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLogin()
        ScreenResult()
    }

    private fun setLogin() = with(binding) {
        btnLogin.setOnClickListener() {
            val user = etUser.text.toString()
            val pass = etPassword.text.toString()

            when {
                user.isEmpty() -> {
                    etUser.error = "Preencha este campo com o seu nome de usuario!"
                }
                pass.isEmpty() -> {
                    etPassword.error = "Preencha este campo com a sua senha!"
                }
                !user.contains("@") -> {
                    val snackbar = make(
                        it, "Usuario inválido!",
                        LENGTH_SHORT
                    )
                    snackbar.show()
                }
                pass.length <= 5 -> {
                    val snackbar = make(
                        it, "A senha precisa ter pelo menos 6 caracteres!",
                        LENGTH_SHORT
                    )
                    snackbar.show()
                }
            }
        }
    }

    private fun ScreenResult() = with(binding) {
        val button = btnLogin
    }
}
