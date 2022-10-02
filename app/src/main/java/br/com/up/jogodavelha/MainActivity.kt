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

        val botaoIniciar : Button = findViewById(R.id.botaoIniciar)

        botaoIniciar.setOnClickListener{

            val intentIniciar  = Intent (this, JogoActivity::class.java)

            startActivity(intentIniciar)/**/
        }
        }
}