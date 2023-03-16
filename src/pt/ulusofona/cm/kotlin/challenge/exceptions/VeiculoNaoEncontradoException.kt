package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoNaoEncontradoException : Exception() {
    override val message = "Quando pesquisas por um veículo que uma pessoa não possui."
}
