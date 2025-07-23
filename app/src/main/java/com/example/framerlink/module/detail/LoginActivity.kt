package com.example.framerlink.module.detail

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override val inflater: (LayoutInflater) -> ActivityLoginBinding
        get() = ActivityLoginBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

    }

    override fun getPageName(): PageName {
        return PageName.LOGIN
    }
}