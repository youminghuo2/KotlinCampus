package com.example.kotlincampus.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincampus.databinding.ItemPageListBinding
import com.example.kotlincampus.entity.PageDate


/**
 * @Description:
 * @CreateDate: 2021/12/13 9:10
 */
class PageListAdapter(private val dataList: List<PageDate>) :
    ListAdapter<PageDate, PageListAdapter.MyViewHolder>(PageListDiffCallback()) {

    inner class MyViewHolder(val binding: ItemPageListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemPageListBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.titleTv.text = item.title
        holder.binding.msgTv.text = item.briefDescription
    }

}

class PageListDiffCallback : DiffUtil.ItemCallback<PageDate>() {
    override fun areItemsTheSame(oldItem: PageDate, newItem: PageDate): Boolean {
        return oldItem.encryptedId == newItem.encryptedId
    }

    override fun areContentsTheSame(oldItem: PageDate, newItem: PageDate): Boolean {
        return oldItem == newItem
    }

}




