package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

open class Veiculo(
    open val identificador: String
) : Movimentavel {
    open var posicao: Posicao = Posicao()
    var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    var dataDeAquisicao: String = LocalDate.parse("01-01-1990", formatter).toString()

    open fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        return "Veiculo | $identificador | Posicao $posicao | Data de Aquisição $dataDeAquisicao"
    }


}
