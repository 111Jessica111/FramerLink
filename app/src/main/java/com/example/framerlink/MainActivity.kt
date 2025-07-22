package com.example.framerlink

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val inflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
    }

    override fun getPageName(): PageName {
        return PageName.MAIN
    }
}