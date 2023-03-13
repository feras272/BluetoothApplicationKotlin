package com.ferasdev.bluetoothapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferasdev.bluetoothapplication.R
import com.ferasdev.bluetoothapplication.data.models.User

class UserAdapter(private val users:List<User>): RecyclerView.Adapter<UserAdapter.viewHolder>() {


    private lateinit var mListener:onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    //private val userList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.custom_user_layout,
            parent, false)

        return UserAdapter.viewHolder(itemView)
        // , mListener
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = users[position]

        holder.username.text = currentItem.username
        holder.userAge.text = currentItem.userAge.toString()
        holder.userWeight.text = "Weight: ${currentItem.userWeight}"
        holder.userHeight.text = "Height: ${currentItem.userHeight}"
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun updateUsersList(usersList: List<User>) {
//        this.users.clear()
//        this.users.addAll(usersList)
        // It will always be more efficient to use more specific change events if you can.
        // Rely on 'notifyDataSetChanged' as a last resort.
        notifyDataSetChanged()
    }


    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // , listener: UserAdapter.onItemClickListener
        val username : TextView = itemView.findViewById(R.id.tv_custom_user_layout)
        val userAge : TextView = itemView.findViewById(R.id.tv_age_custom_user_layout)
        val userWeight : TextView = itemView.findViewById(R.id.tv_weight_custom_user_layout)
        val userHeight : TextView = itemView.findViewById(R.id.tv_height_custom_user_layout)

        init {

            itemView.setOnClickListener {

                //listener.onItemClick(adapterPosition)

            }

        }

    }



}