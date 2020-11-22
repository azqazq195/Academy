package com.example.a5_location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {
    TextView textView1, textView2, textView3;
    // 위치정보 객체
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // 퍼미션 체크
        permissionCheck();

    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 위치 수신을 준비
        // 현재 사용 가능한 하드웨어 이름 얻기
        // LocationManager.GPS_PROVIDER 또는 LocationManger.NETWORK_PROVIDER
        String provider = lm.getBestProvider(new Criteria(), true);
        Toast.makeText(this, "BestProvider : " + provider, Toast.LENGTH_SHORT).show();

        if (provider == null) {
            Toast.makeText(this, "위치 정보를 사용할 수 있는 상태가 아닙니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 해당 장치가 마지막으로 수신한 위치 얻기
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = lm.getLastKnownLocation(provider);
        if(location != null) {
            onLocationChanged(location);
        }
        // 위치 정보 취득 시작
        lm.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        // 현재 위치 얻기
        double lat = location.getLatitude();    // 위도
        double lng = location.getLongitude();   // 경도

        // 출력
        textView1.setText("경도 : " + lng);
        textView2.setText("위도 : " + lat);
        textView3.setText(getAddress(lat, lng));
        
    }

    private String getAddress(double lat, double lng) {
        String str_addr = null;
        // 주소 구하기 객체
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        // 주소 목록 저장 list
        List<Address> list = null;

        try {
            list = geocoder.getFromLocation(lat, lng, 1);
            if(list.size() > 0) {
                Address address = list.get(0);
                str_addr = address.getAddressLine(0);
                // address 객체에 저장된 내용 확인
                for(int i=0; i<= address.getMaxAddressLineIndex(); i++){
                    Log.d("[TEST]", address.getAddressLine(i) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return str_addr;
    }

}