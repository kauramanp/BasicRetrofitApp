package com.aman.basicretrofitapp.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aman.basicretrofitapp.databinding.ItemUsersBinding
import com.aman.basicretrofitapp.models.Users

class RAUsers(var usersList : ArrayList<Users>) : RecyclerView.Adapter<RAUsers.ViewHolder>() {
    inner class ViewHolder(var binding: ItemUsersBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.users = usersList[position]
    }

    override fun getItemCount(): Int {
        return  usersList.size
    }
}