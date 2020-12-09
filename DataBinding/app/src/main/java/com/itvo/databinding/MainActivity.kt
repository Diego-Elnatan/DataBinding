package com.itvo.databinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.itvo.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var Binding: ActivityMainBinding

    private var miNombre: MyNombre = MyNombre("Diego Elnatan Mariano Parra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Binding.miNombre = miNombre

        Binding.btnTerminar.setOnClickListener {
            agregarUsuario(it)
        }

        findViewById<Button>(R.id.btn_terminar).setOnClickListener {
               agregarUsuario(it)
        }

    }


    private fun agregarUsuario(Pushale: View){

        Binding.apply {

            miNombre?.usuario = UsuarioEditText.text.toString()

            invalidateAll()

            UsuarioEditText.visibility = View.GONE

            Pushale.visibility = View.GONE

            usuarioText.visibility = View.VISIBLE
        }

        val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        im.hideSoftInputFromWindow(Pushale.windowToken, 0)

    }
}