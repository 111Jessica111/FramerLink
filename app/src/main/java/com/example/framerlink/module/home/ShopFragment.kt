package com.example.framerlink.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.framerlink.R
import com.example.framerlink.base.BaseActivity
import com.example.framerlink.base.BaseFragment
import com.example.framerlink.base.list.BaseAdapter
import com.example.framerlink.bean.Product
import com.example.framerlink.constant.PageName
import com.example.framerlink.databinding.FragmentShopBinding
import com.example.framerlink.module.adapter.ShopHeaderViewHolder
import com.example.framerlink.module.adapter.ShopItemViewHolder
import com.example.framerlink.navigation.Router.navigation

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
                holder.seedName.text = product.name
                holder.seedDes.text = product.description
                holder.seedPrice.text = product.price?.toInt()?.toString() ?: "--"
                holder.seedRating.rating = (product.rating ?: 0.0).toFloat()
                holder.seedStar.text = (product.rating ?: 0.0).toString()
                holder.seedPhoto.setImageResource(com.example.framerlink.R.mipmap.plant_1)
                
                //商品点击事件
                holder.itemView.setOnClickListener {
                    (requireActivity() as?  BaseActivity<*>)?.let { activity ->
                        activity.navigation(PageName.SHOPDETAIL) { intent ->
                            intent.putExtra("product_id", product.id)
                            intent.putExtra("product_name", product.name)
                            intent.putExtra("product_description", product.description)
                            intent.putExtra("product_price", product.price)
                            intent.putExtra("product_rating", product.rating)
                            intent.putExtra("product_cover_url", product.coverUrl)
                        }
                    }
                }
                
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