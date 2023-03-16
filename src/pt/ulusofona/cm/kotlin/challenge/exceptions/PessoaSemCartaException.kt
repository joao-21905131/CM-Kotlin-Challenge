package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException(nome: String) : Exception() {
    override val message = "Quanto uma pessoa sem carta tenta conduzir um veículo que necessita de carta."
}
