package com.example.mylogin

import androidx.lifecycle.ViewModel
import com.example.mylogin.LoginConstants.NUMBER.PASSWORD_NUMBER

@Suppress("UNREACHABLE_CODE")
class LoginViewModel : ViewModel() {

    val userFixo = User(
        "@carlos.caetano", "picpay123", "Carlos Eduardo",
        "21", "carlos.eduardo@picpay.com"
    )

    fun validateUser(user: String): String? {
        return when {
            user.isEmpty() -> {
                "Por Favor, preencha este campo com seu nome de usuario."
            }
            user.startsWith("@").not() -> {
                "Todo nome de usuario comeca com `@` se possivel, inserir o carecetere no inicio do nome."
            }

            else -> {
                null
            }
        }
    }

    fun visibility(user: String, pass: String): User? {
        return when {
            user == userFixo.usuario && pass == userFixo.senha -> {
                userFixo
            }
            else -> {
                null
            }
        }

    }

    fun test(): User {
        return userFixo
    }

    fun validatePassword(pass: String): String? {
        return when {
            pass.isEmpty() -> {
                "Por favor, preencha este campo com sua senha."
            }
            pass.length < PASSWORD_NUMBER -> {
                "Sua senha nao tem caracteres o suficiente!"
            }
            pass.length > PASSWORD_NUMBER -> {
                "Sua senha tem caracteres demais."
            }
            else -> {
                null
            }
        }
    }
}