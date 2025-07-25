package com.example.framerlink.module.adapter

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.framerlink.R

//Shop头部ViewHolder
class ShopHeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val firmMore: LinearLayout = view.findViewById(R.id.firm_more)
    val seed1: LinearLayout = view.findViewById(R.id.seed_1)
    val seed2: LinearLayout = view.findViewById(R.id.seed_2)
    val seed3: LinearLayout = view.findViewById(R.id.seed_3)
    val seed4: LinearLayout = view.findViewById(R.id.seed_4)
    val seed5: LinearLayout = view.findViewById(R.id.seed_5)
    val seed6: LinearLayout = view.findViewById(R.id.seed_6)
    val seed7: LinearLayout = view.findViewById(R.id.seed_7)
}

class ShopItemViewHolder(view: View): RecyclerView.ViewHolder(view){
    val seedPhoto: ImageView = view.findViewById(R.id.seed_photo)
    val seedName: TextView = view.findViewById(R.id.seed_name)
    val seedPrice: TextView = view.findViewById(R.id.seed_price)
    val seedDes: TextView = view.findViewById(R.id.seed_des)
    val seedAdd: CardView = view.findViewById(R.id.btn_add)
    val seedRating: TextView = view.findViewById(R.id.ratingBars)
    val seedStar: TextView = view.findViewById(R.id.seed_star)

    companion object {
        //设置最大和最小宽高比
        //16:9
        const val MAX_ASPECT_RATIO = 16f / 9f

        //9:16
        const val MIN_ASPECT_RATIO = 9f / 16f
    }
}