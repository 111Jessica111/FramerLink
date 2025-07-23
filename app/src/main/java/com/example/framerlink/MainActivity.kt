package com.example.framerlink

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.viewpager2.widget.ViewPager2
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.ActivityMainBinding
import com.example.framerlink.module.adapter.PagerAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var pagerAdapter: PagerAdapter

    override val inflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setUpViewPagers()
        setUpBottomNavigation()
        setUpJump()
    }

    private fun setUpViewPagers() {
        pagerAdapter = PagerAdapter(this)
        viewBinding.viewPager.apply {
            adapter = pagerAdapter
            isUserInputEnabled = false
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    updateBottomNavigation(position)
                }
            })
        }
    }

    private fun setUpBottomNavigation() {
        viewBinding.btnFirst.setOnClickListener { viewBinding.viewPager.setCurrentItem(0, false) }
        viewBinding.btnSecond.setOnClickListener { viewBinding.viewPager.setCurrentItem(1, false) }
        viewBinding.btnThird.setOnClickListener { viewBinding.viewPager.setCurrentItem(2, false) }
        viewBinding.btnForth.setOnClickListener { viewBinding.viewPager.setCurrentItem(3, false) }
    }

    private fun updateBottomNavigation(position: Int) {
        resetAllIcons()
        when (position) {
            0 -> viewBinding.btnFirst.setImageResource(R.drawable.click_icon_1)
            1 -> viewBinding.btnSecond.setImageResource(R.drawable.click_icon_2)
            2 -> viewBinding.btnThird.setImageResource(R.drawable.click_icon_3)
            3 -> viewBinding.btnForth.setImageResource(R.drawable.click_icon_4)
        }
    }

    private fun resetAllIcons() {
        viewBinding.btnFirst.setImageResource(R.drawable.icon_1)
        viewBinding.btnSecond.setImageResource(R.drawable.icon_2)
        viewBinding.btnThird.setImageResource(R.drawable.icon_3)
        viewBinding.btnForth.setImageResource(R.drawable.icon_4_)
    }

    private fun setUpJump() {
        viewBinding.btnSearch.setOnClickListener {
            // 跳转逻辑
        }
    }

    override fun getPageName(): PageName = PageName.MAIN
}