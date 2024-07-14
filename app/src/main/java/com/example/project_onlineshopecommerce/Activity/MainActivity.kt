package com.example.project_onlineshopecommerce.Activity

import android.os.Bundle
import android.transition.Slide
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.project_onlineshopecommerce.Adapter.SliderAdapter
import com.example.project_onlineshopecommerce.Data.SliderItems
import com.example.project_onlineshopecommerce.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseRef:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //lay banner tu firebase
        initBanner()

    }

    private fun initBanner() {
        databaseRef = FirebaseDatabase.getInstance().getReference("Banner")
        binding.progressBarBanner.visibility = View.VISIBLE

        val slideList:ArrayList<SliderItems> = arrayListOf()
        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (issue in snapshot.children){
                        slideList.add(issue.getValue(SliderItems::class.java)!!)
                    }
                    banners(slideList)
                    binding.progressBarBanner.visibility = View.GONE
                }
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun banners(slideList: ArrayList<SliderItems>) {
        binding.viewpageSlider.adapter = SliderAdapter(slideList,binding.viewpageSlider)
        binding.viewpageSlider.clipToPadding = false
        binding.viewpageSlider.clipChildren = false
        binding.viewpageSlider.offscreenPageLimit = 3
        binding.viewpageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }
        //5154
        binding.viewpageSlider.setPageTransformer(compositePageTransformer)


    }
}