package com.risingcamp.manu.mvmtest.src.main.mainsearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.risingcamp.manu.mvmtest.R
import com.risingcamp.manu.networkapp.retrofitdata.DataX
import java.util.*

class ReviewCheckAdapter(var ReviewList : List<DataX>) : RecyclerView.Adapter<ReviewCheckAdapter.ReviewFrgAdapter>() {

    inner class ReviewFrgAdapter(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.mainsearch_review_check_adapter, parent, false)
    ){
        val foodImg = itemView.findViewById<ImageView>(R.id.food_img)
        val addressRes = itemView.findViewById<TextView>(R.id.address_res)
        val recordeMyStar = itemView.findViewById<ImageView>(R.id.record_my_star)
        val resNamePosition = itemView.findViewById<TextView>(R.id.res_name_position)
        val resNameAddress = itemView.findViewById<TextView>(R.id.res_name_address)
        val kindItem = itemView.findViewById<TextView>(R.id.kind_item)
        val reviewScore = itemView.findViewById<TextView>(R.id.review_score)
        val reviewCount = itemView.findViewById<TextView>(R.id.review_count)
        val random = Random()

        fun onBindWith(ReviewtextList: DataX){
            foodImg.clipToOutline = true
            Glide.with(itemView).load(ReviewtextList.foodImgUrl).into(foodImg)
            addressRes.text = ReviewtextList.localPlace
            resNameAddress.text = ReviewtextList.resName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewFrgAdapter {
        return ReviewFrgAdapter((parent))
    }

    override fun onBindViewHolder(holder: ReviewFrgAdapter, position: Int) {
        holder.onBindWith(ReviewList[position])
        holder.resNamePosition.text = (position + 1).toString() + "."
    }

    override fun getItemCount(): Int {
        return ReviewList.size
    }


}