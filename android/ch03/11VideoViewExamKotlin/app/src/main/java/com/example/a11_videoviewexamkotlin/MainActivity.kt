package com.example.a11_videoviewexam

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.a11_videoviewexamkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // 퍼미션 체크 확인용
    val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100
    var permissionCK = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 타이틀바 제거
        val actionBar = supportActionBar // ActionBar가 바로 타이틀바이다.
        actionBar?.hide() // 타이틀을 화면에서 사라지게하는 역할
        videoView.setMediaController(MediaController(this))
        // Permission Check를 먼저 해야한다.
        permissionCheck()
        // Permission이 제대로 등록되었는지 확인
        if (permissionCK) startVideo()
    }

    private fun startVideo() {}
    private fun permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
            }
        } else {
            permissionCK = true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}