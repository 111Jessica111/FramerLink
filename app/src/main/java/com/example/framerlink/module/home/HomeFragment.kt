package com.example.framerlink.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framerlink.base.BaseFragment
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFunctionClick(viewBinding)
    }

    private fun setFunctionClick(binding: FragmentHomeBinding) {

    }


    override fun getPageName(): PageName {
        return PageName.MAIN
    }

}