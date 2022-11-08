package com.example.desafiodarthvader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiodarthvader.databinding.ActivityMainBinding
import Auxiliar.Conexion
import Modelos.Persona
import android.content.Intent

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding//Agregar a las declaraciones
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var jefe: Persona = Persona("darth_vader", "oscuro")
        Conexion.addPersona(this, jefe)

        binding.btInicio.setOnClickListener(){
            if(binding.edUsuario.text.toString() == "" || binding.edPassword.text.toString() == "" ){
                Toast.makeText(this, "Rellena todos los campos.", Toast.LENGTH_SHORT).show()
            }else {
                var p: Persona? = null
                p = Conexion.buscarPersona(this, binding.edUsuario.text.toString())
                if (p != null) {
                    if (binding.edUsuario.text.toString() == "darth_vader" && binding.edPassword.text.toString() == p.pass.toString()) {
                        var int: Intent = Intent(this, PaginaVader::class.java)
                        startActivity(int)
                    }
                    //else para los pilotos :3
                } else {
                    Toast.makeText(this, "No existe un usuario con ese nombre", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}