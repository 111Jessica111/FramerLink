package com.example.framerlink.module.detail

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.framerlink.R
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.ActivityShopDetailBinding

class ShopDetailActivity : BaseActivity<ActivityShopDetailBinding>() {
    override val inflater: (LayoutInflater) -> ActivityShopDetailBinding
        get() = ActivityShopDetailBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

    }

    override fun getPageName(): PageName {
        return PageName.SHOPDETAIL
    }
}