package br.com.up.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.jogodavelha.Adapter.JodadorAdapter
import br.com.up.jogodavelha.databinding.ActivityJogoBinding

class JogoActivity : AppCompatActivity()
{
    enum class Turn
    {
        BOLINHA,
        X
    }

    private var primeraRodada = Turn.X
    private var proxima = Turn.X

    private var pontosX = 0
    private var pontosO = 0

    private var boardList = mutableListOf<Button>()

    private lateinit var binding : ActivityJogoBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()


        val recyclerJogadores : RecyclerView =
            findViewById(R.id.jogadoresRecycle)

        recyclerJogadores.layoutManager =
            GridLayoutManager(this, 2)


        recyclerJogadores.adapter = JodadorAdapter(listOf())
    }

    private fun initBoard()
    {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun boardTapped(view: View)
    {
        if(view !is Button)
            return
        addToBoard(view)

        if(checkForVictory(BOLINHA))
        {
            pontosO++
            result("Noughts Win!")
        }
        else if(checkForVictory(X))
        {
            pontosX++
            result("Crosses Win!")
        }

        if(fullBoard())
        {
            result("Draw")
        }

    }

    private fun checkForVictory(s: String): Boolean
    {
        //Horizontal Victory
        if(match(binding.a1,s) && match(binding.a2,s) && match(binding.a3,s))
            return true
        if(match(binding.b1,s) && match(binding.b2,s) && match(binding.b3,s))
            return true
        if(match(binding.c1,s) && match(binding.c2,s) && match(binding.c3,s))
            return true

        //Vertical Victory
        if(match(binding.a1,s) && match(binding.b1,s) && match(binding.c1,s))
            return true
        if(match(binding.a2,s) && match(binding.b2,s) && match(binding.c2,s))
            return true
        if(match(binding.a3,s) && match(binding.b3,s) && match(binding.c3,s))
            return true

        //Diagonal Victory
        if(match(binding.a1,s) && match(binding.b2,s) && match(binding.c3,s))
            return true
        if(match(binding.a3,s) && match(binding.b2,s) && match(binding.c1,s))
            return true

        return false
    }

    private fun match(button: Button, symbol : String): Boolean = button.text == symbol

    private fun result(title: String)
    {
        val message = "\nNoughts $pontosO\n\nCrosses $pontosX"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset")
            { _,_ ->
                resetBoard()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetBoard()
    {
        for(button in boardList)
        {
            button.text = ""
        }

        if(primeraRodada == Turn.BOLINHA)
            primeraRodada = Turn.X
        else if(primeraRodada == Turn.X)
            primeraRodada = Turn.BOLINHA

        proxima = primeraRodada
        setTurnLabel()
    }

    private fun fullBoard(): Boolean
    {
        for(button in boardList)
        {
            if(button.text == "")
                return false
        }
        return true
    }

    private fun addToBoard(button: Button)
    {
        if(button.text != "")
            return

        if(proxima == Turn.BOLINHA)
        {
            button.text = BOLINHA
            proxima = Turn.X
        }
        else if(proxima == Turn.X)
        {
            button.text = X
            proxima = Turn.BOLINHA
        }
        setTurnLabel()
    }

    private fun setTurnLabel()
    {
        var turnText = ""
        if(proxima == Turn.X)
            turnText = "Turn $X"
        else if(proxima == Turn.BOLINHA)
            turnText = "Turn $BOLINHA"

        binding.rodada.text = turnText
    }

    companion object
    {
        const val BOLINHA = "O"
        const val X = "X"
    }

}










