package com.example.framerlink.module.home

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framerlink.base.BaseFragment
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.FragmentHomeBinding
import com.example.framerlink.databinding.LeadDialogBinding
import com.tencent.mmkv.MMKV

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //首次进入显示LeadDailog
        val mmkv = MMKV.defaultMMKV()
        val isFirst = mmkv.decodeBool("is_first_enter", true)
        if (isFirst){
            setLeadDialog()
            mmkv.encode("is_first_enter", false)
        }

        setFunctionClick(viewBinding)

    }

    private fun setLeadDialog() {
        val dialog = Dialog(requireContext())
        val binding = LeadDialogBinding.inflate(LayoutInflater.from(context))
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(binding.root)
        dialog.setCancelable(false)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        binding.btnCancel.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private fun setFunctionClick(binding: FragmentHomeBinding) {

    }


    override fun getPageName(): PageName {
        return PageName.MAIN
    }

}