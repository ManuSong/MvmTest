package com.risingcamp.manu.mvmtest.src.main.mainsearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.risingcamp.manu.mvmtest.R
import com.risingcamp.manu.mvmtest.src.main.mainsearch.model.ImageData

class MainBannerAdapter(var adImageList : ArrayList<ImageData>) : RecyclerView.Adapter<MainBannerAdapter.AdPagerAdapter>() {

    inner class AdPagerAdapter(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.mainsearch_banner_view_item, parent, false)
    ){
        val adImages = itemView.findViewById<ImageView>(R.id.ad_images)

        fun onBindWith(mainImageList : ImageData){
            adImages.setImageResource(mainImageList.imageSrc)
        }

    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdPagerAdapter {
        return AdPagerAdapter((parent))
    }

    override fun onBindViewHolder(holder: AdPagerAdapter, position: Int) {
        holder.onBindWith(adImageList[position])
    }

    override fun getItemCount(): Int {
        return adImageList.size
    }


}