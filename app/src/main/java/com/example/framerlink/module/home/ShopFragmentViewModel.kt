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

    init {
        _shopList.value = listOf(
            Product(
                id = "1",
                name = "优质强劲冬小麦种子高产山东小麦济麦22小麦种子",
                description = "优质小麦种子，适合多种气候。",
                tags = "粮食,高产",
                rating = 4.5,
                price = 199.0,
                coverUrl = "plant_1",
                imageUrls = listOf("plant_1"),
                active = true,
                likes = 120,
                normal = 100,
                dislikes = 5,
                capacity = "10kg"
            ),
            Product(
                id = "2",
                name = "玉米",
                description = "高产玉米种子，抗病性强。",
                tags = "粮食,高产,抗病",
                rating = 4.8,
                price = 299.0,
                coverUrl = "plant_1",
                imageUrls = listOf("plant_1"),
                active = true,
                likes = 200,
                normal = 180,
                dislikes = 3,
                capacity = "8kg"
            ),
            Product(
                id = "1",
                name = "小麦",
                description = "优质小麦种子，适合多种气候。",
                tags = "粮食,高产",
                rating = 4.5,
                price = 199.0,
                coverUrl = "plant_1",
                imageUrls = listOf("plant_1"),
                active = true,
                likes = 120,
                normal = 100,
                dislikes = 5,
                capacity = "10kg"
            ),
            Product(
                id = "2",
                name = "玉米",
                description = "高产玉米种子，抗病性强。",
                tags = "粮食,高产,抗病",
                rating = 4.8,
                price = 299.0,
                coverUrl = "plant_1",
                imageUrls = listOf("plant_1"),
                active = true,
                likes = 200,
                normal = 180,
                dislikes = 3,
                capacity = "8kg"
            ),
            Product(
                id = "1",
                name = "小麦",
                description = "优质小麦种子，适合多种气候。",
                tags = "粮食,高产",
                rating = 4.5,
                price = 199.0,
                coverUrl = "plant_1",
                imageUrls = listOf("plant_1"),
                active = true,
                likes = 120,
                normal = 100,
                dislikes = 5,
                capacity = "10kg"
            ),
            Product(
                id = "2",
                name = "玉米",
                description = "高产玉米种子，抗病性强。",
                tags = "粮食,高产,抗病",
                rating = 4.8,
                price = 299.0,
                coverUrl = "plant_1",
                imageUrls = listOf("plant_1"),
                active = true,
                likes = 200,
                normal = 180,
                dislikes = 3,
                capacity = "8kg"
            )
        )
    }

    override fun getPageName(): PageName {
        return PageName.MAIN
    }
}