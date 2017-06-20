package com.example.hong.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private MyLocationListener mll;
    private LocationManager mgr;

    private Marker mPerth;
    private static final LatLng PERTH = new LatLng(25.033408, 121.564099);
    Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        LocationManager status = (LocationManager) (this.getSystemService(Context.LOCATION_SERVICE));
        if (status.isProviderEnabled(LocationManager.GPS_PROVIDER) || status.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            //如果GPS或網路定位開啟，呼叫locationServiceInitial()更新位置
            locationServiceInitial();
        } else {
            Toast.makeText(this, "請開啟定位服務", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));    //開啟設定頁面
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        mll = new MyLocationListener();




        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        /*
        Location location = mgr.getLastKnownLocation(
                LocationManager.GPS_PROVIDER);
        if (location == null) {
            location = mgr.getLastKnownLocation(
                    LocationManager.NETWORK_PROVIDER);
        }*/

        LatLng place;
        if (location != null) {
            //place = new LatLng(location.getLatitude(), location.getLongitude());
            place = new LatLng(24.179384, 120.649732);

            mPerth = mMap.addMarker(new MarkerOptions().position(place).title("現在位置"));
            mPerth.setTag(1);

            mPerth.showInfoWindow();
        } else {
            place = new LatLng(25.033408, 121.564099);
        }

        LatLng v1;

        /*
        v1 = new LatLng(24.186277,120.644793);

        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("逢甲大學"));
        mPerth.setTag(0);*/

        v1 = new LatLng(24.178992, 120.645209);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("福星路麥當勞"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179125, 120.647207);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("忠勤樓男廁"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179181, 120.646799);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("忠勤樓女廁"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179533, 120.646779);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("建築館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179737, 120.647254);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("語文大樓廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.181142, 120.646887);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("土木水利館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.181741, 120.646606);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("學思樓廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.181767, 120.648833);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("體育館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.181767, 120.648833);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("體育館廁所"));
        mPerth.setTag(0);


        v1 = new LatLng(24.179758, 120.649172);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("人社館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179758, 120.649172);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("人文社會館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179782, 120.650037);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("電子通訊館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179156, 120.649167);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("資訊電機館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179184, 120.650081);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("資訊電訊館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.178248, 120.648040);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("丘逢甲紀念館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.178259, 120.648507);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("丘逢甲紀念館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.178626, 120.647550);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("行政二館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.178625, 120.647284);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("行政一館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.178899, 120.649067);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("逢甲大學圖書館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.178625, 120.647284);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("行政一館廁所"));
        mPerth.setTag(0);


        v1 = new LatLng(24.178240, 120.649280);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("科學與航太館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.178260, 120.650090);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("商學大樓廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179789, 120.648414);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("人言大樓廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.179791, 120.648853);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("人言大樓廁所"));
        mPerth.setTag(0);


        v1 = new LatLng(24.179493, 120.648161);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("工學館廁所"));
        mPerth.setTag(0);

        v1 = new LatLng(24.181159, 120.647624);
        mPerth = mMap.addMarker(new MarkerOptions().position(v1)
                .title("理學館廁所"));
        mPerth.setTag(0);

        // Add a marker in Sydney and move the camera
        // LatLng place = new LatLng(25.033408, 121.564099);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        moveMap(place);
        //setUpMap();

        mPerth = mMap.addMarker(new MarkerOptions().position(PERTH)
                .title("101"));
        mPerth.setTag(0);


    }

    private void setUpMap() {
        // 刪除原來預設的內容
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

        // 建立位置的座標物件
        LatLng place = new LatLng(25.033408, 121.564099);
        // 移動地圖
        moveMap(place);

        // 加入地圖標記
        addMarker(place, "Hello!", " Google Maps v2!");

    }

    private void addMarker(LatLng place, String title, String snippet) {
        BitmapDescriptor icon =
                BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);


        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(place)
                .title(title)
                .snippet(snippet)
                .icon(icon);

        mMap.addMarker(markerOptions);
    }

    // 移動地圖到參數指定的位置
    private void moveMap(LatLng place) {
        // 建立地圖攝影機的位置物件
        CameraPosition cameraPosition =
                new CameraPosition.Builder()
                        .target(place)
                        .zoom(17)
                        .build();

        // 使用動畫的效果移動地圖
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private LocationManager lms;

    private void locationServiceInitial() {
        lms = (LocationManager) getSystemService(LOCATION_SERVICE);    //取得系統定位服務
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
       location = lms.getLastKnownLocation(LocationManager.GPS_PROVIDER);    //使用GPS定位座標

        getLocation(location);
    }
    private void getLocation(Location location) {	//將定位資訊顯示在畫面中
        if(location != null) {


            Double longitude = location.getLongitude();	//取得經度
            Double latitude = location.getLatitude();	//取得緯度


        }
        else {
            Toast.makeText(this, "無法定位座標", Toast.LENGTH_LONG).show();
        }
    }

    class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
        }
        @Override
        public void onProviderDisabled(String provider) {
        }
        @Override
        public void onProviderEnabled(String provider) {
        }
        @Override
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
        }
    }
}
