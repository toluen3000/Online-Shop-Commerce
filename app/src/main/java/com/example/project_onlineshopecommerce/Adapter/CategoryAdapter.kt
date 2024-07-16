package com.example.project_onlineshopecommerce.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.project_onlineshopecommerce.Data.CategoryDomain
import com.example.project_onlineshopecommerce.databinding.ViewholderCategoryBinding

class CategoryAdapter:RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private lateinit var items: ArrayList<CategoryDomain>
    private lateinit var context: Context
    private lateinit var binding: ViewholderCategoryBinding

    inner class CategoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        context = parent.context
        binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        val itemView = binding.root
        //1.03.00
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.apply {
            binding.txtTitle.setText(items.get(position).title)
        }
        Glide.with(context)
            .load(items.get(position).picUrl)
            .into(binding.imgPicture)

    }
}