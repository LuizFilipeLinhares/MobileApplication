package com.example.myapplication.Class

class CarrinhoDeCompras() {
    val listaDeProdutos: MutableList<Pair<Product, Int>> = mutableListOf()

    fun adicionarProduto(produto: Product, quantidade: Int) {
        val itemExistente = listaDeProdutos.find { it.first == produto }
        if (itemExistente != null) {
            val indice = listaDeProdutos.indexOf(itemExistente)
            listaDeProdutos[indice] = Pair(produto, itemExistente.second + quantidade)
        } else {
            listaDeProdutos.add(Pair(produto, quantidade))
        }
    }

    fun exibirCarrinho() {
        listaDeProdutos.forEach { (produto, quantidade) ->
            println("${produto.name} - R$${produto.price} x $quantidade")
        }
    }

    fun removerProduto(produto: Product, quantidade: Int) {
        val itemExistente = listaDeProdutos.find { it.first == produto }
        if (itemExistente != null) {
            val indice = listaDeProdutos.indexOf(itemExistente)
            val novaQuantidade = itemExistente.second - quantidade
            if (novaQuantidade <= 0) {
                listaDeProdutos.removeAt(indice)
            } else {
                listaDeProdutos[indice] = Pair(produto, novaQuantidade)
            }
        }
    }

    fun calcularTotal(): Double {
        var total = 0.0
        listaDeProdutos.forEach { (produto, quantidade) ->
            total += produto.price * quantidade
        }
        return total
    }
}
