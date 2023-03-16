package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException(nome: String) : Exception() {
    override val message = "$nome não tem carta para conduzir o veículo indicado"
}
