package br.com.up.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNome1 = findViewById<EditText>(R.id.editTextNome1)
        val editTextNome2 = findViewById<EditText>(R.id.editTextNome2)
        val botaoIniciar : Button = findViewById(R.id.botaoIniciar)

        botaoIniciar.setOnClickListener{

            val nome1 = editTextNome1.text
            val nome2 = editTextNome2.text

            val intentIniciar  = Intent (this, JogoActivity::class.java)

            startActivity(intentIniciar)/*/
        }
        }
}