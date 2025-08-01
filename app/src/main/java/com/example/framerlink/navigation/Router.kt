package com.example.framerlink.navigation

import android.content.Intent
import com.example.framerlink.MainActivity
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.module.detail.SearchActivity
import com.example.framerlink.module.detail.LoginActivity
import com.example.framerlink.module.detail.ShopDetailActivity

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
            PageName.CONSULTATION -> {

            }
            PageName.ORDER -> {

            }
            PageName.PHOTO -> {

            }
            PageName.CONTROL -> {

            }
            PageName.REGULATE -> {

            }
            PageName.NEWS -> {

            }
            PageName.MARKET -> {

            }
            PageName.PRICE -> {

            }
            PageName.WHEATHER -> {

            }
            PageName.SHOPDETAIL -> {
                val intent = Intent(this, ShopDetailActivity::class.java)
                intentAction(intent)
                startActivity(intent)
            }
        }
    }
}