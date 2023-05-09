package com.example.mylogin

data class User(
    val usuario: String,
    val senha: String,
    val nome: String,
    val idade: String,
    val email: String,
    val notFound: String = "Usuario nao encontrado"
)
