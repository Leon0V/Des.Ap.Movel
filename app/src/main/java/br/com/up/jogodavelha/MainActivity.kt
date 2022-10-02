package br.com.up.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutNome1 : TextInputLayout = findViewById(R.id.textLayoutNome1)
        val layoutNome2 : TextInputLayout = findViewById(R.id.textLayoutNome2)
        val editNome1 : EditText = findViewById(R.id.textLayoutNome1)
        val editNome2 : EditText = findViewById(R.id.textLayoutNome2)
        val botaoIniciar : Button = findViewById(R.id.botaoIniciar)

        botaoIniciar.setOnClickListener(View.OnClickListener {
            val intentIniciar  = Intent (MainActivity@this, JogoActivity::class.java)
            startActivity(intentIniciar)
        }
        )}
}