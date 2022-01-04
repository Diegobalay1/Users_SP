package com.diego.kotlin.userssp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
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
            binding.tvOrder.text = (position+1).toString()//user.id.toString()
            binding.tvName.text = user.name
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)
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