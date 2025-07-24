package com.example.framerlink.module.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.framerlink.module.home.AiFragment
import com.example.framerlink.module.home.HomeFragment
import com.example.framerlink.module.home.MineFragment
import com.example.framerlink.module.home.ShopFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> AiFragment()
            2 -> ShopFragment()
            3 -> MineFragment()
            else -> HomeFragment()
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}