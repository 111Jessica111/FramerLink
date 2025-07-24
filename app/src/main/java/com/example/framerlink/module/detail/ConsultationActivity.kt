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
import com.example.framerlink.databinding.ActivityConsultationBinding

class ConsultationActivity : BaseActivity<ActivityConsultationBinding>() {
    override val inflater: (LayoutInflater) -> ActivityConsultationBinding
        get() = ActivityConsultationBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

    }

    override fun getPageName(): PageName {
        return PageName.CONSULTATION
    }
}