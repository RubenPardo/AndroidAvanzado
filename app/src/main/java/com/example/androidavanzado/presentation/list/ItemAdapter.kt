package com.example.androidavanzado.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidavanzado.Model
import com.example.androidavanzado.databinding.ListItemBinding

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>()  {


    private var itemList: MutableList<Model> = mutableListOf()


    inner class ViewHolder(private val binding: ListItemBinding,ItemView: View) : RecyclerView.ViewHolder(ItemView) {


        fun bind(item:Model){
            with(binding){
                tvItem.text = item.name
                Glide.with(root)
                    .load(item.photoUrl)
                    .into(ivItem)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding,binding.root)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = itemList[position]
        holder.bind(item)

    }

    fun setItems(modelList: List<Model>) {
        itemList = modelList.toMutableList()
        notifyDataSetChanged()
    }
}