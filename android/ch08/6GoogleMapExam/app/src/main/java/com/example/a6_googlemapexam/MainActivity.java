package com.example.a6_googlemapexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

// OnMapReadyCallback
// => Google Map ver2는 덩치가 커졌기 때문에,
// 초기화 하는데 시간이 걸린다.
// 그래서, 초기화 작업을 이벤트로 처리한다.
public class MainActivity extends AppCompatActivity
    implements LocationListener, OnMapReadyCallback {
    // 객체 선언
    GoogleMap googleMap;
    MapFragment fragment;
    LocationManager lm;             // 위치 정보 객체
    Marker marker;                  // 지도에 표시할 마커 객체
    boolean permissionCK = false;   // 퍼미션 허락 여부 저장


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        // 구글맵 초기화
        fragment.getMapAsync(this);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        } else {
            permissionCK = true;
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        // 위도와 경도 얻기
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        // 구글 맵에 위치 설정하기
        LatLng position = new LatLng(lat, lng);
        if(marker == null) {
            // 마커가 없으면 생성
            MarkerOptions options = new MarkerOptions();
            options.position(position);
            options.title("내 위치");
            options.snippet("GPS로 확인한 위치");
            Bitmap bitmap = BitmapFactory.decodeFileDescriptor()
            bitmap = Bitmap.createScaledBitmap(bitmap, 50, 50, false);
            options.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
            marker = googleMap.addMarker(options);
        } else {
            // 마커가 있으면 위치만 수정
            marker.setPosition(position);
        }
        // 지도 배율 설정 : zoom 1 ~ 21 (값이 커질수록 확대)
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 17);
        // 현재 위치로 맵의 카메라 위치 이동
        googleMap.animateCamera(cameraUpdate);
    }

    // GoogleMap이 초기화가 완료되면 자동 호출
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if(permissionCK) readyMap();
    }

    private void readyMap() {
        String provider = lm.getBestProvider(new Criteria(), true);
        if(provider == null) {
            Toast.makeText(this, "위치정보를 사용할 수 있는 상태가 아닙니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = lm.getLastKnownLocation(provider);
        if(location != null) {
            onLocationChanged(location);
        }

        // 위치 정보 취득 시작
        lm.requestLocationUpdates(provider, 1000, 1, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // if(permissionCK) readyMap();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 위치 정보 수신종료
        lm.removeUpdates(this);
    }

    // 퍼미션 창이 뜨고 난후, 자동 호출
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        readyMap();
    }
}