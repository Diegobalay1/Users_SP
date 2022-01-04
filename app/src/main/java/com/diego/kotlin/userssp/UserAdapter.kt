package com.diego.kotlin.userssp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diego.kotlin.userssp.databinding.ItemUserBinding

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var context: Context //con lateinit le estamos diciendo que se inicializará después

    /**
     * Inflamos nuestra lista en el listado
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    /**
     * Rellenar información de nuestro listado
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)

        // alimentamos cada propiedad respecto al valor de cada usuario
        with(holder){
            binding.tvOrder.text = user.id.toString()
            binding.tvName.text = user.name
        }
    }

    /**
     * Nos indica cuantos elementos hay en este adapter
     */
    override fun getItemCount(): Int = users.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind(view)
    }
}