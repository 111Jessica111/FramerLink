package com.example.framerlink.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.framerlink.base.BaseFragment
import com.example.framerlink.base.BaseViewModel
import com.example.framerlink.bean.Product
import com.example.framerlink.constant.PageName

class ShopFragmentViewModel: BaseViewModel() {

    private val _shopList = MutableLiveData<List<Product>>()
    val shopList: LiveData<List<Product>> get() = _shopList

    override fun getPageName(): PageName {
        return PageName.MAIN
    }
}