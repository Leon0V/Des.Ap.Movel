package br.com.up.jogodavelha.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.up.jogodavelha.Models.Jogador
import br.com.up.jogodavelha.R

class JodadorAdapter(val jogadorList:List<Jogador>) : RecyclerView.Adapter<JodadorAdapter.JogViewHolder> (){
    inner class JogViewHolder(item:View): RecyclerView.ViewHolder(item)

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

        val nome1: View =
            holder.itemView.findViewById(R.id.textLayoutNome1)
        val nome2: View =
            holder.itemView.findViewById(R.id.textLayoutNome2)
    }

    override fun getItemCount(): Int {
        return 2
    }
}
