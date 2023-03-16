package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(
    override val identificador: String,
    val motor: Motor
) : Veiculo(identificador), Ligavel {

    override var posicao: Posicao = Posicao(0, 0)

    override fun requerCarta(): Boolean {
        return true
    }

    var ligado = false

    override fun ligar() {
        if (ligado){
            throw VeiculoLigadoException()
        }

        motor.ligar()
        ligado = true
    }

    override fun desligar() {
        if (!ligado){
            throw VeiculoDesligadoException()
        }

        motor.desligar()
        ligado = false
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun moverPara(x: Int, y: Int) {
        if (!ligado){
            throw VeiculoDesligadoException()
        }
        super.moverPara(x, y)
    }
    override fun toString(): String {
        return "Carro | $identificador | ${DateFormatter.formatter(dataDeAquisicao)} | $posicao"
    }
}
