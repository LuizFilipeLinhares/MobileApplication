package com.example.myapplication.Class

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class Product (
    val id: Int,
    val name: String,
    var price: Double,
    var storage: Int
) {
    @Composable
    fun ShowDetails(){
        Text(text = "$id - $name - $price - $storage")
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPreview(){
    val p = Product(id = 1, name = "teste", price = 580.00, storage = 8)
    p.ShowDetails()
}