package com.example.desafiodarthvader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiodarthvader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding//Agregar a las declaraciones
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btInicio.setOnClickListener(){
            if(binding.edUsuario.text.toString() == "" || binding.edPassword.text.toString() == "" ){
                Toast.makeText(this, "Rellena todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}