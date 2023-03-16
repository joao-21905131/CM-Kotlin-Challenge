package pt.ulusofona.cm.kotlin.challenge.exceptions

open class AlterarPosicaoException : Exception() {
    override var message = "Quanto tentas um movimento para a posição onde já te encontras."
}
