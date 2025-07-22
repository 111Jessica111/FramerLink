package com.example.framerlink

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.viewpager2.widget.ViewPager2
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.ActivityMainBinding
import com.example.framerlink.module.adapter.PagerAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnFirst: ImageButton
    private lateinit var btnSecond: ImageButton
    private lateinit var btnThird: ImageButton
    private lateinit var btnForth: ImageButton
    private lateinit var pagerAdapter: PagerAdapter

    override val inflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        initViews()
        setUpViewPagers()
        setUpBottomNavigation()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        btnFirst = findViewById(R.id.btn_first)
        btnSecond = findViewById(R.id.btn_second)
        btnThird = findViewById(R.id.btn_third)
        btnForth = findViewById(R.id.btn_forth)
    }

    private fun setUpViewPagers() {
        pagerAdapter = PagerAdapter(this)
        viewPager.adapter = pagerAdapter
        //禁止滑动
        viewPager.isUserInputEnabled = false
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateBottomNavigation(position)
            }
        })
    }

    private fun setUpBottomNavigation() {
        btnFirst.setOnClickListener { viewPager.setCurrentItem(0, false) }
        btnSecond.setOnClickListener { viewPager.setCurrentItem(1, false) }
        btnThird.setOnClickListener { viewPager.setCurrentItem(2, false) }
        btnForth.setOnClickListener { viewPager.setCurrentItem(3, false) }
    }

    private fun updateBottomNavigation(position: Int) {
        resetAllIcons()
        when(position){
            0 -> btnFirst.setImageResource(R.drawable.click_icon_1)
            1 -> btnSecond.setImageResource(R.drawable.click_icon_2)
            2 -> btnThird.setImageResource(R.drawable.click_icon_3)
            3 -> btnForth.setImageResource(R.drawable.click_icon_4)
        }

    }

    private fun resetAllIcons() {
        btnFirst.setImageResource(R.drawable.icon_1)
        btnSecond.setImageResource(R.drawable.icon_2)
        btnThird.setImageResource(R.drawable.icon_3)
        btnForth.setImageResource(R.drawable.icon_4_)
    }

    override fun getPageName(): PageName {
        return PageName.MAIN
    }
}