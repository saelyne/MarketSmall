package com.example.small;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/*
 * Created by Saelyne on 2017. 9. 15..
 */

public class  SetLocation extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    MapView mMapView;
    Bundle savedInstanceState;
    static Context mContext;
    static Activity mActivity;
    private GpsInfo gps;
    private Button confirmBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_location);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        confirmBtn = (Button) findViewById(R.id.Setlocationbutton);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetLocation.this, CustomerMain.class);
                startActivity(intent);
            }
        });

    }


    public void onMapReady(GoogleMap googleMap) {
        // ↑매개변수로 GoogleMap 객체가 넘어옵니다.
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }
        gps = new GpsInfo(SetLocation.this);

        if (gps.isGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            LatLng latLng = new LatLng(latitude, longitude);

            Log.d("dd", "" + Double.toString(latitude) + "");
            Log.d("dd", "" + Double.toString(longitude) + "");


            // camera 좌쵸를 서울역 근처로 옮겨 봅니다.
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            // 구글지도(지구) 에서의 zoom 레벨은 1~23 까지 가능합니다.
            // 여러가지 zoom 레벨은 직접 테스트해보세요
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(6);
            googleMap.animateCamera(zoom);   // moveCamera 는 바로 변경하지만,
            // animateCamera() 는 근거리에선 부드럽게 변경합니다

            // marker 표시
            // market 의 위치, 타이틀, 짧은설명 추가 가능.
            MarkerOptions marker = new MarkerOptions();
            marker.position(latLng)
                    .title("Here")
                    .snippet("current location");
            googleMap.addMarker(marker).showInfoWindow(); // 마커추가,화면에출력
        } else {
            gps.showSettingsAlert();
            Log.d("dd", "ff");
        }

        // 마커클릭 이벤트 처리
        // GoogleMap 에 마커클릭 이벤트 설정 가능.


    }

}