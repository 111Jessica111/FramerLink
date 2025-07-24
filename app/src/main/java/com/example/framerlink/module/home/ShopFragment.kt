package com.example.framerlink.module.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framerlink.R
import com.example.framerlink.base.BaseFragment
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.FragmentShopBinding

class ShopFragment : BaseFragment<FragmentShopBinding>() {
    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentShopBinding
        get() = FragmentShopBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun getPageName(): PageName {
        return PageName.MAIN
    }
}