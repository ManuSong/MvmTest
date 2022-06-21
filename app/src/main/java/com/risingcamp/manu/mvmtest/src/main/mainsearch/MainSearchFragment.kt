package com.risingcamp.manu.mvmtest.src.main.mainsearch

import android.os.Bundle
import android.view.View
import com.risingcamp.manu.mvmtest.R
import com.risingcamp.manu.mvmtest.config.BaseFragment
import com.risingcamp.manu.mvmtest.databinding.FragmentMainsearchBinding
import com.risingcamp.manu.networkapp.retrofitdata.ResReviewData
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant

class MainSearchFragment : BaseFragment<FragmentMainsearchBinding>(FragmentMainsearchBinding::bind, R.layout.fragment_mainsearch), MainSearchFragmentInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        

    }


    override fun onGetRestaurantSuccess(response: delicous_restrant) {
        TODO("Not yet implemented")
    }

    override fun onGetRestaurantFail(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGetReviewSuccess(response: ResReviewData) {
        TODO("Not yet implemented")
    }

    override fun onGetReviewFail(message: String) {
        TODO("Not yet implemented")
    }
}