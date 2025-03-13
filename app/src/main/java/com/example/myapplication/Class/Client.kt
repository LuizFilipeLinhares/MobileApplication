package com.example.myapplication.Class

class Client(
    val id: Int,
    val name: String,
    var balance: Double
) {
    fun addBalance(value: Double) {
        balance += value
    }
}