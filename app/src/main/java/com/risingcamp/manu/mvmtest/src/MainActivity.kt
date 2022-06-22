package com.risingcamp.manu.mvmtest.src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.risingcamp.manu.mvmtest.R
import com.risingcamp.manu.mvmtest.config.BaseActivity
import com.risingcamp.manu.mvmtest.databinding.ActivityMainBinding
import com.risingcamp.manu.mvmtest.src.main.discountres.DiscountResFragment
import com.risingcamp.manu.mvmtest.src.main.mainsearch.MainSearchFragment
import com.risingcamp.manu.mvmtest.src.main.mypage.MyPageFragment
import com.risingcamp.manu.mvmtest.src.main.notice.NoticeFragment
import com.risingcamp.manu.mvmtest.src.main.reviewplus.ReviewPlusFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val fragmentOne by lazy { MainSearchFragment() }
    private val fragmentTwo by lazy { DiscountResFragment() }
    private val fragmentThree by lazy { ReviewPlusFragment() }
    private val fragmentFour by lazy { NoticeFragment() }
    private val fragmentFive by lazy { MyPageFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initNavigationBar()


    }
    fun initNavigationBar() {

        binding.btmNavi.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.find_res_btn -> {
                        changeFragment(fragmentOne)

                    }
                    R.id.discount_res_btn -> {
                        changeFragment(fragmentTwo)

                    }

                    R.id.notice_res_btn -> {
                        changeFragment(fragmentFour)

                    }

                    R.id.mypage_res_btn -> {
                        changeFragment(fragmentFive)

                    }

                    R.id.btm_plus_btn -> {
                        changeFragment(fragmentThree)

                    }

                }
                true
            }
            selectedItemId = R.id.find_res_btn
        }
    }

    private fun changeFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}