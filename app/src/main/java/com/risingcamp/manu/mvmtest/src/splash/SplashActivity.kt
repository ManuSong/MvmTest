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
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error != null) {
                    val intent = Intent(this@SplashActivity, MainLoginActivity::class.java)
                    Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
                else if (tokenInfo != null) {
                    Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    finish()
                }
            }
            startActivity(intent)
        },1500)

    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }


}