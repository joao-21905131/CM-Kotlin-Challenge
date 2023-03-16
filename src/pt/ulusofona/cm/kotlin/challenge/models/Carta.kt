package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Carta(val identificador:String){

    var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    var dataTirada: String = LocalDate.parse("01-01-1990", formatter).toString()


    override fun toString(): String {
        return "Carta | $identificador | $dataTirada"
    }
}