package com.example.framerlink.module.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.framerlink.R
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.ActivityShopDetailBinding

class ShopDetailActivity : BaseActivity<ActivityShopDetailBinding>() {
    override val inflater: (LayoutInflater) -> ActivityShopDetailBinding
        get() = ActivityShopDetailBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        //接收传递的商品数据
        val productId = intent.getStringExtra("product_id")
        val productName = intent.getStringExtra("product_name")
        val productDescription = intent.getStringExtra("product_description")
        val productPrice = intent.getDoubleExtra("product_price", 0.0)
        val productRating = intent.getDoubleExtra("product_rating", 0.0)
        val productCoverUrl = intent.getStringExtra("product_cover_url")
        
        //绑定数据到界面
        productName?.let { viewBinding.shopName.text = it }
        productDescription?.let { 
            //如果有描述文本控件，可以在这里设置
        }
        viewBinding.shopPrice.text = productPrice.toInt().toString()
        viewBinding.ratingBars.rating = productRating.toFloat()
        viewBinding.shopStar.text = productRating.toString()
        viewBinding.seedPhotoDetail.setImageResource(R.mipmap.plant_1)
        
        //初始化视图绑定
        setupViewBindings()
        
        //默认显示描述页面
        showDescriptionView()


        
        //加入购物车按钮点击事件
        viewBinding.btnAddToCar.setOnClickListener {
            // TODO: 实现加入购物车逻辑
        }
        //返回
        viewBinding.btnBack.setOnClickListener {
            finish()
        }
    }
    
    private fun setupViewBindings() {
        viewBinding.selectFunc1.setOnClickListener {
            showDescriptionView()
            updateSelection(1)
        }
        
        viewBinding.selectFunc2.setOnClickListener {
            showCommentView()
            updateSelection(2)
        }
        
        viewBinding.selectFunc3.setOnClickListener {
            showAttentionView()
            updateSelection(3)
        }
        
        viewBinding.selectFunc4.setOnClickListener {
            showTransportView()
            updateSelection(4)
        }
    }
    
    private fun updateSelection(selectedIndex: Int) {
        viewBinding.select1.isChecked = false
        viewBinding.select2.isChecked = false
        viewBinding.select3.isChecked = false
        viewBinding.select4.isChecked = false

        when (selectedIndex) {
            1 -> viewBinding.select1.isChecked = true
            2 -> viewBinding.select2.isChecked = true
            3 -> viewBinding.select3.isChecked = true
            4 -> viewBinding.select4.isChecked = true
        }
    }
    
    private fun showDescriptionView() {
        removeAllChildViews()
        val descriptionView = LayoutInflater.from(this).inflate(R.layout.product_description, viewBinding.contentContainer, false)
        viewBinding.contentContainer.addView(descriptionView)
    }
    
    private fun showCommentView() {
        removeAllChildViews()
        val commentView = LayoutInflater.from(this).inflate(R.layout.product_comment, viewBinding.contentContainer, false)
        viewBinding.contentContainer.addView(commentView)
    }
    
    private fun showAttentionView() {
        removeAllChildViews()
        val attentionView = LayoutInflater.from(this).inflate(R.layout.product_attention, viewBinding.contentContainer, false)
        viewBinding.contentContainer.addView(attentionView)
    }
    
    private fun showTransportView() {
        removeAllChildViews()
        val transportView = LayoutInflater.from(this).inflate(R.layout.product_transport, viewBinding.contentContainer, false)
        viewBinding.contentContainer.addView(transportView)
    }
    
    private fun removeAllChildViews() {
        viewBinding.contentContainer.removeAllViews()
    }

    override fun getPageName(): PageName {
        return PageName.SHOPDETAIL
    }
}