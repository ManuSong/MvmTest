package com.risingcamp.manu.mvmtest.src.main.mainsearch.kakaomap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.R
import com.risingcamp.manu.mvmtest.config.BaseActivity
import com.risingcamp.manu.mvmtest.databinding.ActivityKakaoMapBinding
import com.risingcamp.manu.mvmtest.src.MainActivity
import com.risingcamp.manu.mvmtest.src.main.mainsearch.MainSearchFragment
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import net.daum.mf.map.n.api.NativeMapCoord

class KakaoMapActivity : BaseActivity<ActivityKakaoMapBinding>(ActivityKakaoMapBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragment_mainSearch = MainSearchFragment()
        val mapView = MapView(this)
        val marker = MapPOIItem()

        binding.kakaoMapTest.addView(mapView)

        binding.mapBackSpace.apply {
            setOnClickListener {
                val intent = Intent(this@KakaoMapActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

        mapView.apply {
            setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.5488847, 126.9727028), true)
            setZoomLevel(2, true)
            zoomIn(true)
            zoomOut(true)
        }

        marker.apply {
            itemName = "Defalut Makter"
            tag = 0
            mapPoint = MapPoint.mapPointWithGeoCoord(37.5488847, 126.9727028)
            markerType = MapPOIItem.MarkerType.BluePin
            selectedMarkerType = MapPOIItem.MarkerType.RedPin
            mapView.addPOIItem(marker)
        }

    }
}