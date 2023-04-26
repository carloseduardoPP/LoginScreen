package com.example.mylogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.mylogin.databinding.ActitvityLoginBinding
import com.google.android.material.snackbar.Snackbar.*


const val PASSWORD_NUMBER = 9
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

        val user1 = User("@carlos.eduardo", "picpay123", "Carlos Eduardo", "21",
            "carlos.eduardo@picpay.com")
        //VALIDACAO
        btnLogin.setOnClickListener() {
            val user = etUser.text.toString()
            val pass = etPassword.text.toString()

            when {
                user.isEmpty() -> {
                    etUser.error = getString(R.string.recomendacao_user)
                }
                pass.isEmpty() -> {
                    etPassword.error = getString(R.string.recomendacao_pass)
                }
                !user.contains("@") -> {
                    val snackbar = make(
                        it, getString(R.string.invalid_user),
                        LENGTH_SHORT
                    )
                    snackbar.show()
                }
                pass.length < PASSWORD_NUMBER -> {
                    val snackbar = make(
                        it, getString(R.string.nine_caracters),
                        LENGTH_SHORT
                    )
                    snackbar.show()
                }
                pass.length > PASSWORD_NUMBER -> {
                    val snackbar = make(
                        it, getString(R.string.ten_caracter),
                        LENGTH_SHORT
                    )
                    snackbar.show()
                }

            }

            //PRINTAR NA TELA
            if (user == usuario && pass == senha) {
                response.isVisible = true
                message.isVisible = false

                rpName.text = user1.nome
                rpName.text = nome
                rpAge.text = idade
                rpEmail.text = email
            } else if (user != usuario && pass != senha) {
                message.isVisible = true
                response.isVisible = false

                tvMessage.text = getString(R.string.user_not_found)
            }
        }
    }
}
