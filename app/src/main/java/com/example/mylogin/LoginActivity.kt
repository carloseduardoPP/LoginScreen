package com.example.mylogin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.mylogin.databinding.ActitvityLoginBinding

open class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActitvityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActitvityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLogin()
    }

    private fun setLogin() = with(binding) {
        btnLogin.setOnClickListener() {
            val campoUsuario = etUser.text.toString()
            val campoSenha = etPassword.text.toString()

            val errorEmail = viewModel.validateUser(campoUsuario)
            val errorPass = viewModel.validatePassword(campoSenha)

            val visibility: User? = viewModel.visibility(campoUsuario, campoSenha)

            errorEmail?.let {
                etUser.error = errorEmail
            }
            errorPass?.let {
                etPassword.error = errorPass
            }

            controlVisibility(visibility)
        }
    }

    private fun ActitvityLoginBinding.controlVisibility(visibility: User?) {
        if (visibility == null) {
            response.isVisible = false
        } else {
            response.isVisible = true
            rpName.text = visibility.nome
            rpEmail.text = visibility.email
            rpAge.text = visibility.idade
        }
    }
}
