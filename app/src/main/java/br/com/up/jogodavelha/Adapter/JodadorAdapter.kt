package br.com.up.jogodavelha.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.jogodavelha.Models.Jogador
import br.com.up.jogodavelha.R

class JodadorAdapter(val jogadorList:List<Jogador>) : RecyclerView.Adapter<JodadorAdapter.JogViewHolder> (){

    class JogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nome1: TextView
        val nome2: TextView

        init {
            nome1 = view.findViewById(R.id.editTextNome1)
            nome2 = view.findViewById(R.id.editTextNome2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val layout = inflater.inflate(
            R.layout.activity_main,
            parent,
            false
        )

        return JogViewHolder(layout)
    }

    override fun onBindViewHolder(holder: JogViewHolder, position: Int) {
        holder.nome1.text = jogadorList[position].toString()
        holder.nome2.text = jogadorList[position].toString()
    }

    override fun getItemCount(): Int {
        return jogadorList.size
    }
}
