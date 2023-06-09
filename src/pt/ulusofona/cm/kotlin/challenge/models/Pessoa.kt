package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat

import java.util.*


class Pessoa(
    val nome: String,
    var dataDeNascimento: Date
) : Movimentavel {

    var veiculos: ArrayList<Veiculo> = ArrayList()
    lateinit var carta: Carta
    var posicao: Posicao = Posicao()


    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)

        veiculo.dataDeAquisicao = Date().toString()
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {

        veiculos.forEach { veiculo ->
            run {
                if (veiculo.identificador == identificador) {
                    return veiculo
                }
            }
        }

        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {

        val veiculo = pesquisarVeiculo(identificador)

        veiculos.remove(veiculo)

        comprador.comprarVeiculo(veiculo)
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        if (pesquisarVeiculo(identificador).requerCarta() ){
            throw PessoaSemCartaException(nome)
        }

        pesquisarVeiculo(identificador).moverPara(x, y)
    }

    fun temCarta(): Boolean {
        return this::carta.isInitialized
    }



    fun tirarCarta() {

    }



    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        val formatoNovaData = "dd-MM-yyyy"
        val formato = SimpleDateFormat(formatoNovaData)
        val dataNova = formato.format(dataDeNascimento)
        return "Pessoa | $nome | $dataNova | Posicao | x:${posicao.x} | y:${posicao.y}"    }


}

