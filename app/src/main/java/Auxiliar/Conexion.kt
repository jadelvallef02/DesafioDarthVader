package Auxiliar

import Conexion.AdminSQLIteConexion
import Modelos.Persona
import Modelos.Piloto
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity

object Conexion {
    var nombreBD = "administracion.db3"

    fun cambiarBD(nombreBD: String) {
        this.nombreBD = nombreBD

    }

    fun addPersona(contexto: AppCompatActivity, p: Persona) {
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", p.nombre)
        registro.put("pass", p.pass)
        bd.insert("personas", null, registro)
        bd.close()
    }

    fun addPiloto(contexto: AppCompatActivity, p: Piloto) {
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", p.nombre)
        registro.put("pass", p.pass)
        registro.put("edad", p.edad)
        registro.put("experiencia", p.experiencia)
        bd.insert("pilotos", null, registro)
        bd.close()
    }

    fun delPersona(contexto: AppCompatActivity, nombre: String): Int {
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val cant = bd.delete("personas", "nombre='${nombre}'", null)
        bd.close()
        return cant
    }

    fun modPersona(contexto: AppCompatActivity, nombre: String, p: Persona): Int {
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", p.nombre)
        registro.put("pass", p.pass)
        val cant = bd.update("personas", registro, "nombre='${nombre}'", null)
        bd.close()
        return cant
    }

    fun buscarPersona(contexto: AppCompatActivity, nombre: String): Persona? {
        var p: Persona? = null
        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery(
            "select nombre,pass from personas where nombre='${nombre}'",
            null
        )
        if (fila.moveToFirst()) {
            p = Persona(fila.getString(0), fila.getString(1))
        }
        bd.close()
        return p
    }

    fun obtenerPersonas(contexto: AppCompatActivity): ArrayList<Persona> {
        var personas: ArrayList<Persona> = ArrayList(1)

        val admin = AdminSQLIteConexion(contexto, nombreBD, null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery("select nombre,pass from personas", null)
        while (fila.moveToNext()) {
            var p: Persona = Persona(fila.getString(0), fila.getString(1))
            personas.add(p)
        }
        bd.close()
        return personas
    }
}

