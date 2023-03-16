package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoLigadoException : Exception() {
    override val message = "Quando uma pessoa tenta ligar um veículo e o mesmo já se encontra ligado."
}
