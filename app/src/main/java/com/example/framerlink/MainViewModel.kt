package com.example.framerlink

import com.example.framerlink.base.BaseViewModel
import com.example.framerlink.constant.PageName

class MainViewModel: BaseViewModel() {
    override fun getPageName(): PageName {
        return PageName.MAIN
    }
}