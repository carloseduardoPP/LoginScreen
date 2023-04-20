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
    }

    private fun setLogin() = with(binding) {
        //DADOS
        val usuario: String = "@carlos.eduardo"
        val senha: String = "picpay123"
        val nome: String = "Carlos Eduardo"
        val idade: String = "21"
        val email: String = "carlos.eduardo@picpay.com"

        //ERROR
        val error = "Usuario nao encontrado"


        //VALIDACAO
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
                pass.length <= 8 -> {
                    val snackbar = make(
                        it, "A senha precisa ter pelo menos 9 caracteres!",
                        LENGTH_SHORT
                    )
                    snackbar.show()
                }
                pass.length > 9 -> {
                    val snackbar = make(
                        it, "A senha deve ter menos que 10 caracteres!",
                        LENGTH_SHORT
                    )
                    snackbar.show()
                }
            }
            //PRINTAR NA TELA
            if (user == usuario && pass == senha) {
                response.isVisible = true
                message.isVisible = false

                rpName.text = nome
                rpAge.text = idade
                rpEmail.text = email
            } else if (user != usuario && pass != senha) {
                message.isVisible = true
                response.isVisible = false

                tvMessage.text = "Usuario nao encontrado!"
            }
        }
    }
}
