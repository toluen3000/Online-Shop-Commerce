package com.example.project_onlineshopecommerce.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.project_onlineshopecommerce.Data.SliderItems
import com.example.project_onlineshopecommerce.R
import com.google.firebase.Firebase


class SliderAdapter(): RecyclerView.Adapter<SliderAdapter.SlideViewHolder>() {
    private lateinit var slideItems: ArrayList<SliderItems>
    private lateinit var viewPager2: ViewPager2
    private lateinit var context: Context

    private var runnable = object :Runnable{
        override fun run() {
            slideItems.addAll(slideItems)
            notifyDataSetChanged()
        }
    }


    constructor(slideItems: ArrayList<SliderItems>, viewPager2: ViewPager2) : this() {
        this.slideItems = slideItems
        this.viewPager2 = viewPager2
    }


    inner class SlideViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        //47:54 check
        private var imageView: ImageView = itemView.findViewById(R.id.imageSlide)

        fun setImage(sliderItems: SliderItems){
            val requestOptions = RequestOptions().transform(CenterCrop())
            Glide.with(context)
                .load(sliderItems.url)
                .apply(requestOptions)
                .into(imageView)
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        context = parent.context
        return SlideViewHolder(LayoutInflater.from(context).inflate(R.layout.slide_item_container,parent,false))
    }

    override fun getItemCount(): Int {
        return slideItems.size
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.setImage(slideItems.get(position))
        if (position == slideItems.size - 2 ){
            viewPager2.post(runnable)
        }
    }
}