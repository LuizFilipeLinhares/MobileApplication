package com.example.myapplication.Class

class Loja(
    val produtosDisponiveis: MutableList<Product> = mutableListOf()
) {
    fun atualizarEstoque(produto: Product, novoValor: Int) {
        val itemExistente = produtosDisponiveis.find { it.id == produto.id }
        if (itemExistente != null) {
            itemExistente.storage = novoValor
        } else {
            println("Produto não encontrado!")
        }
    }

    fun realizarCompra(cliente: Client, carrinho: CarrinhoDeCompras) {
        val total = carrinho.calcularTotal()

        if (cliente.balance < total) {
            println("Saldo insuficiente!")
            return
        }

        for ((produto, quantidade) in carrinho.listaDeProdutos) {
            if (produto.storage < quantidade) {
                println("Estoque insuficiente para o produto ${produto.name}. Não foi possível completar a compra.")
                return
            }
        }

        for ((produto, quantidade) in carrinho.listaDeProdutos) {
            produto.storage -= quantidade
        }

        cliente.balance -= total
        carrinho.listaDeProdutos.clear()
        println("Compra realizada com sucesso!")
    }
}