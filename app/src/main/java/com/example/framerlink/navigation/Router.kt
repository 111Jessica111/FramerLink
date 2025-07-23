package com.example.framerlink.navigation

import android.content.Intent
import com.example.framerlink.MainActivity
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.module.detail.SearchActivity
import com.example.framerlink.module.detail.LoginActivity

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
            PageName.LOGIN -> {
                val intent = Intent(this, LoginActivity::class.java)
                intentAction(intent)
                startActivity(intent)
            }
            PageName.SEARCH -> {
                val intent = Intent(this, SearchActivity::class.java)
                intentAction(intent)
                startActivity(intent)
            }
        }
    }
}