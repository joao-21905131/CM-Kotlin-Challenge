package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*


open class Veiculo(
    open val identificador: String
) : Movimentavel {
    open var posicao: Posicao = Posicao()
    var dataDeAquisicao: Date = Date()
//    val requerCarta: Boolean = false

    open fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        return "Veiculo | $identificador | ${DateFormatter.formatter(dataDeAquisicao)} | $posicao"
    }


}
