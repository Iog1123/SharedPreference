package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMainBinding
import java.util.prefs.AbstractPreferences
// constante para el nombre del archivo
const val mFileNameSharedPreferences="com.example.sharedpreference"
private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
  // vatiable para la referecencia a sharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inicializar la variable sharedPreferences
        sharedPreferences= getSharedPreferences(mFileNameSharedPreferences,Context.MODE_PRIVATE)


        binding.buttonGuardar.setOnClickListener{

            var clave1="1"
            var NumberInt = binding.InsertNumberInt.text.toString().toInt()
            sharedPreferences.edit().putInt(clave1,NumberInt).apply()

            var clave2="2"
            var Texto= binding.InsertText.text.toString()
            sharedPreferences.edit().putString(clave2,Texto).apply()


            var clave3 ="3"
            var NumberDecimal = binding.InsertNamberDecimal.text.toString().toFloat()
            sharedPreferences.edit().putFloat(clave3,NumberDecimal).apply()
        }



       var dato1 : String= sharedPreferences.getInt("1",0).toString()
        var dato2 : String= sharedPreferences.getString("2","vacio").toString()
        var dato3 : String = sharedPreferences.getFloat("3",0.0f).toString()

        binding.textView.setText("el valor anterior era: $dato1")
        binding.textView2.setText("el valor anterior era: $dato2")
        binding.textView3.setText("el valor anterior era: $dato3")


        binding.buttonBorrar.setOnClickListener{
            sharedPreferences.edit().clear().apply()

        }

    }


}




