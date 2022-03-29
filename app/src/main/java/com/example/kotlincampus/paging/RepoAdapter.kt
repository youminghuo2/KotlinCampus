package com.example.kotlincampus.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincampus.R
import com.example.kotlincampus.entity.Repo

/**
 * @Author: zcy
 * @CreateDate: 2022/3/29 15:54
 * @Description:
 */
class RepoAdapter:PagingDataAdapter<Repo,RepoAdapter.ViewHolder>(COMPATATOR) {

    companion object{
        private val COMPATATOR=object :DiffUtil.ItemCallback<Repo>(){
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem==newItem
            }
        }
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name_text)
        val description:TextView=itemView.findViewById(R.id.description_text)
        val startCount:TextView=itemView.findViewById(R.id.star_count_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.repo_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo=getItem(position)
        if (repo!=null){
            holder.name.text=repo.name
            holder.description.text=repo.description
            holder.startCount.text=repo.starCount.toString()
        }
    }
}