package Modelos

import java.util.*

data class Piloto(
    var nombre:String,
    var pass:String,
    var edad:Int,
    var experiencia:Int)
    : java.io.Serializable{
}

