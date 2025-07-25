package com.example.framerlink.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.framerlink.R
import com.example.framerlink.base.BaseFragment
import com.example.framerlink.base.list.BaseAdapter
import com.example.framerlink.bean.Product
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.FragmentShopBinding
import com.example.framerlink.module.adapter.ShopHeaderViewHolder
import com.example.framerlink.module.adapter.ShopItemViewHolder

class ShopFragment : BaseFragment<FragmentShopBinding>() {

    private val viewModel: ShopFragmentViewModel by activityViewModels()

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentShopBinding
        get() = FragmentShopBinding::inflate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        //设置adapter
        val shopAdapter = BaseAdapter().build {

            //头部
            setItem<ShopHeaderViewHolder>(
                R.layout.fragment_shop_head
            ) { holder ->
                val layoutParams = holder.itemView.layoutParams
                if (layoutParams is StaggeredGridLayoutManager.LayoutParams){
                    layoutParams.isFullSpan = true
                }
                holder.firmMore.setOnClickListener {

                }

            }

            //商品
            setItems<ShopItemViewHolder, Product>(
                this@ShopFragment,
                R.layout.shop_list,
                viewModel.shopList
            ) { holder, product ->
                // 名称
                holder.seedName.text = product.name
                // 描述
                holder.seedDes.text = product.description
                // 价格
                holder.seedPrice.text = product.price?.toInt()?.toString() ?: "--"
                // 评分
                val rating = product.rating ?: 0.0
                val ratingBar = holder.itemView.findViewById<android.widget.RatingBar>(com.example.framerlink.R.id.ratingBars)
                ratingBar.rating = rating.toFloat()
                holder.seedStar.text = rating.toString()
                // 图片（本地资源 plant_1）
                holder.seedPhoto.setImageResource(com.example.framerlink.R.mipmap.plant_1)
                // 加入按钮点击事件（可自定义）
                holder.seedAdd.setOnClickListener {
                    // TODO: 加入购物车逻辑
                }
            }
        }

        //设置布局管理器
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        viewBinding.shopRecycleView.layoutManager = layoutManager
        viewBinding.shopRecycleView.adapter = shopAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun getPageName(): PageName {
        return PageName.MAIN
    }
}