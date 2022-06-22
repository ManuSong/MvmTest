package com.risingcamp.manu.mvmtest.src.main.mypage

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kakao.sdk.user.UserApiClient
import com.risingcamp.manu.mvmtest.R
import com.risingcamp.manu.mvmtest.config.BaseFragment
import com.risingcamp.manu.mvmtest.databinding.FragmentMyPageBinding
import com.risingcamp.manu.mvmtest.src.MainLoginActivity


class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                binding.notLoginScreen.visibility = View.VISIBLE
                binding.loginScreen.visibility = View.INVISIBLE
                binding.mypageLoginBtn.setOnClickListener {
                    val intent = Intent(context, MainLoginActivity::class.java)
                    startActivity(intent)
                }
            }
            else if (tokenInfo != null) {
                UserApiClient.instance.me { user, error ->
                    if (error != null){
                        Log.e(ContentValues.TAG, "사용자 정보 요청 실패", error)
                    } else if (user != null){

                        binding.notLoginScreen.visibility = View.INVISIBLE
                        binding.loginScreen.visibility = View.VISIBLE
                        Glide.with(view.context).load(user.kakaoAccount?.profile?.thumbnailImageUrl).circleCrop().into(binding.userProfile)
                        binding.userNickname.text = user.kakaoAccount?.profile?.nickname

                        Log.i(
                            ContentValues.TAG, "사용자 정보 요청 성공" +
                                "\n프로필사진 : ${user.kakaoAccount?.profile?.thumbnailImageUrl}" +
                                "\n닉네임 : ${user.kakaoAccount?.profile?.nickname}")

                    }
                }
            }
        }

    }

}