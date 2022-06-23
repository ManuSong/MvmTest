package com.risingcamp.manu.mvmtest.src.main.mainsearch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.common.util.Utility
import com.risingcamp.manu.mvmtest.R
import com.risingcamp.manu.mvmtest.config.BaseFragment
import com.risingcamp.manu.mvmtest.databinding.FragmentMainsearchBinding
import com.risingcamp.manu.mvmtest.src.main.mainsearch.adapter.MainBannerAdapter
import com.risingcamp.manu.mvmtest.src.main.mainsearch.adapter.MainSearchResAdapter
import com.risingcamp.manu.mvmtest.src.main.mainsearch.adapter.ReviewCheckAdapter
import com.risingcamp.manu.mvmtest.src.main.mainsearch.adapter.infinitescroll.EndlessRecyclerViewScrollListener
import com.risingcamp.manu.mvmtest.src.main.mainsearch.kakaomap.KakaoMapActivity
import com.risingcamp.manu.mvmtest.src.main.mainsearch.model.ImageData
import com.risingcamp.manu.networkapp.retrofitdata.ResReviewData
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant

class MainSearchFragment : BaseFragment<FragmentMainsearchBinding>(FragmentMainsearchBinding::bind, R.layout.fragment_mainsearch), MainSearchFragmentInterface {

    private var AdImageList = ArrayList<ImageData>()
    private lateinit var mainBannerAdapter: MainBannerAdapter
    private lateinit var mainSearchResAdapter: MainSearchResAdapter
    private lateinit var reviewCheckAdapter: ReviewCheckAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val keyHash = Utility.getKeyHash(view.context)
        Log.d("hash", keyHash)


        AdImageList.add(ImageData(R.drawable.mango_ad1))
        AdImageList.add(ImageData(R.drawable.manggo_ad2))
        AdImageList.add(ImageData(R.drawable.manggo_ad3))
        AdImageList.add(ImageData(R.drawable.manggo_ad4))
        AdImageList.add(ImageData(R.drawable.manggo_ad5))

        mainBannerAdapter = MainBannerAdapter(AdImageList)

        binding.mainFrgViewpager2.apply {
            adapter = mainBannerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        TabLayoutMediator(
            binding.tabMainBanner,
            binding.mainFrgViewpager2
        ){
                tab, position ->
            binding.mainFrgViewpager2.setCurrentItem(tab.position)
        }.attach()

        MainSearchService(this).getRestaurant()

        MainSearchService(this).getReview()


        binding.mainMapBtn.apply {
            setOnClickListener {
                val intent = Intent(context, KakaoMapActivity::class.java)
                startActivity(intent)
            }
        }




    }



    override fun onGetRestaurantSuccess(response: delicous_restrant) {


        mainSearchResAdapter = MainSearchResAdapter(response.data)
        binding.noticeRecycler.apply {
            adapter = mainSearchResAdapter
            val linearLayoutManager = LinearLayoutManager(context)
           // 무한 스크롤 연결하기 전~!
        }

    }

    override fun onGetRestaurantFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

    override fun onGetReviewSuccess(response: ResReviewData) {


        if (response != null){
            reviewCheckAdapter = ReviewCheckAdapter(response.data)
            binding.reviewRecycler.adapter = reviewCheckAdapter
            binding.reviewRecycler.layoutManager = GridLayoutManager(context, 2)

        }
    }

    override fun onGetReviewFail(message: String) {
        showCustomToast("오류 : ${message}")
    }
}