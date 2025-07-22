package com.example.framerlink.navigation

import android.content.Intent
import com.example.framerlink.MainActivity
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName

object Router {
    fun BaseActivity<*>.navigation(
        pageName: PageName,
        requestCode: Int? =null,
        intentAction: (Intent) -> Unit = {}
    ){
        when(pageName){
            PageName.MAIN -> {
                val intent = Intent(this, MainActivity::class.java)
                intentAction(intent)
                startActivity(intent)
            }
        }
    }
}