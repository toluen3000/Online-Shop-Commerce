package com.example.project_onlineshopecommerce.Activity

import android.os.Bundle
import android.view.Window
import android.view.WindowId
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.project_onlineshopecommerce.R
import com.google.firebase.database.FirebaseDatabase

open class BaseActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        database = FirebaseDatabase.getInstance()

//        val windows = window
//        windows.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

    }
}