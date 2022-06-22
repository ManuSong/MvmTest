package com.risingcamp.manu.mvmtest.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.kakao.sdk.user.UserApiClient
import com.risingcamp.manu.mvmtest.config.BaseActivity
import com.risingcamp.manu.mvmtest.databinding.ActivitySplashBinding
import com.risingcamp.manu.mvmtest.src.MainActivity
import com.risingcamp.manu.mvmtest.src.MainLoginActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handler.postDelayed({

            val intent = Intent(this@SplashActivity, MainLoginActivity::class.java)
            startActivity(intent)

        },1500)

    }


}