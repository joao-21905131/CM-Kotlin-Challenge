package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoDesligadoException : Exception() {
    override val message = "Quanto uma pessoa tenta desligar um veículo e o mesmo já se encontra desligado."
}
