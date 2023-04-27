package com.example.mylogin

import androidx.core.view.isVisible
import com.example.mylogin.LoginConstants.NUMBER.PASSWORD_NUMBER
import com.google.android.material.snackbar.Snackbar

class Validacao : LoginActivity() {
   fun validate() = with(binding) {
        btnLogin.setOnClickListener() {
            val user = etUser.text.toString()
            val pass = etPassword.text.toString()
            val userFixo = User("@carlos.caetano", "picpay123", "Carlos Eduardo",
                "21", "carlos.eduardo@picpay.com")

            when {
                user.isEmpty() -> {
                    etUser.error = getString(R.string.recomendacao_user)
                }
                pass.isEmpty() -> {
                    etPassword.error = getString(R.string.recomendacao_pass)
                }
                !user.contains("@") -> {
                    val snackbar = Snackbar.make(
                        it, getString(R.string.invalid_user),
                        Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }
                pass.length < PASSWORD_NUMBER -> {
                    val snackbar = Snackbar.make(
                        it, getString(R.string.nine_caracters),
                        Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }
                pass.length > PASSWORD_NUMBER -> {
                    val snackbar = Snackbar.make(
                        it, getString(R.string.ten_caracter),
                        Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }
            }
            if (user == userFixo.usuario && pass == userFixo.senha) {
                response.isVisible = true
                message.isVisible = false

                rpName.text = userFixo.nome
                rpAge.text = userFixo.idade
                rpEmail.text = userFixo.email
            } else if (user != userFixo.usuario && pass != userFixo.senha) {
                message.isVisible = true
                response.isVisible = false

                tvMessage.text = getString(R.string.user_not_found)
            }
        }
    }
}