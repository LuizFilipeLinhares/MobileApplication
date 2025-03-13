package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.Class.CarrinhoDeCompras
import com.example.myapplication.Class.Client
import com.example.myapplication.Class.Loja
import com.example.myapplication.Class.Product
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val produto1 = Product(1, "Notebook", 4500.0, 5)
                val produto2 = Product(2, "Mouse Gamer", 250.0, 10)

                // Criando cliente
                val cliente = Client(1, "Ana", 5000.0)

                // Criando carrinho e loja
                val carrinho = CarrinhoDeCompras()
                val loja = Loja(mutableListOf(produto1, produto2)) // Corrigido para passar a lista no construtor

                // Adicionando produtos ao carrinho
                carrinho.adicionarProduto(produto1, 1)
                carrinho.adicionarProduto(produto2, 1)

                // Exibindo o carrinho
                carrinho.exibirCarrinho()

                // Tentando finalizar a compra
                loja.realizarCompra(cliente, carrinho)

                Column(
                    modifier = Modifier.padding(top = 18.dp)
                ){
                    Text("Saldo restante: R$${cliente.balance}")
                    Text("Estoque de Notebook após a compra: ${produto1.storage}")
                    Text("Estoque de Mouse Gamer após a compra: ${produto2.storage}")
                }
                }
            }
        }
    }



