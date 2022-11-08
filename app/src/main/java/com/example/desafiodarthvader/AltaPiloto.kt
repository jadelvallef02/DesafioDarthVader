package com.example.desafiodarthvader

import Auxiliar.Conexion
import Modelos.Persona
import Modelos.Piloto
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.desafiodarthvader.databinding.ActivityAltaPilotoBinding

class AltaPiloto : AppCompatActivity() {
    lateinit var binding: ActivityAltaPilotoBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAltaPilotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibtnRegistrar.setOnClickListener {
            if(binding.etNombre.text.toString() != "" || binding.etPass.text.toString() != "" || binding.etEdad.text.toString() != ""){
                val piloto: Piloto = Piloto(binding.etNombre.text.toString(), binding.etPass.text.toString(), binding.etEdad.text.toString().toInt(), binding.etNivel.text.toString().toInt())
                val p2 : Persona = Persona(piloto.nombre, piloto.pass)
                Conexion.addPersona(this, p2)
                Conexion.addPiloto(this, piloto)
                finish()
            }else{
                Toast.makeText(this,"RELLENE LOS CAMPOS MI LORD", Toast.LENGTH_SHORT).show()
            }
        }

        binding.sbNivel.setOnSeekBarChangeListener()

        binding.ibtnCancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }

        binding.rbNovato.setOnClickListener(){
            binding.sbNivel.min = 0
            binding.sbNivel.max = 50
        }

        binding.rbIntermedio.setOnClickListener(){
            binding.sbNivel.min = 50
            binding.sbNivel.max = 100
        }

        binding.rbExperto.setOnClickListener(){
            binding.sbNivel.min = 100
            binding.sbNivel.max = 200
        }

    }

    private fun SeekBar.setOnSeekBarChangeListener() {

    }

}




