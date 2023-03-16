package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*


class Pessoa(
    val nome: String,
    val newDate: String,
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

    fun formatarData( date: Date): String{
        var data: Calendar = Calendar.getInstance()
        data.time = date
        return "${data.get(Calendar.DATE)}-" +
                "${data.get(Calendar.MONTH) + 1}-" +
                "${data.get(Calendar.YEAR)}"
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento  | Posicao | x:${posicao.x} | y:${posicao.y}"    }


}

