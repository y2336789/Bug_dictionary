package com.forfarmers.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.forfarmers.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

public class MapActivity extends FragmentActivity
        implements
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Places.initialize(getApplicationContext(), "AIzaSyDsXWbjrrUmgFE8Ozfq77M1VQUK0eZWnHA");
        PlacesClient placesClient = Places.createClient(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        //충청북도
        LatLng bb_farm = new LatLng(36.5200, 127.5064);   //부부농장
        LatLng hn_farm = new LatLng(36.6910, 127.6112);   //하나로 대신 주말 농장
        LatLng nh_farm = new LatLng(36.5929, 127.5004);   //청주농협주말농장
        LatLng oc_farm = new LatLng(36.7246, 127.3596);   //오창다래농장
        LatLng ss_farm = new LatLng(36.6420, 127.4779);   //산성동텃밭
        LatLng bs_farm = new LatLng(36.5885, 127.5785);   //백송블루베리
        LatLng ic_farm = new LatLng(36.8730, 127.5027);   //이찌방 딸기 농장


        MarkerOptions markerOptions01 = new MarkerOptions();
        markerOptions01.position(bb_farm);
        markerOptions01.title("부부 농장");
        mMap.addMarker(markerOptions01);

        MarkerOptions markerOptions02 = new MarkerOptions();
        markerOptions02.position(hn_farm);
        markerOptions02.title("하나로 대신 주말 농장");
        mMap.addMarker(markerOptions02);

        MarkerOptions markerOptions03 = new MarkerOptions();
        markerOptions03.position(nh_farm);
        markerOptions03.title("청주농협주말농장");
        mMap.addMarker(markerOptions03);

        MarkerOptions markerOptions04 = new MarkerOptions();
        markerOptions04.position(oc_farm);
        markerOptions04.title("오창다래농장");
        mMap.addMarker(markerOptions04);

        MarkerOptions markerOptions05 = new MarkerOptions();
        markerOptions05.position(ss_farm);
        markerOptions05.title("산성동텃밭");
        mMap.addMarker(markerOptions05);

        MarkerOptions markerOptions06 = new MarkerOptions();
        markerOptions06.position(bs_farm);
        markerOptions06.title("백송블루베리");
        mMap.addMarker(markerOptions06);

        MarkerOptions markerOptions07 = new MarkerOptions();
        markerOptions07.position(ic_farm);
        markerOptions07.title("이찌방 딸기 농장");
        mMap.addMarker(markerOptions07);



        //충청남도
        LatLng hp_farm = new LatLng(36.4490, 127.1303);   //행복이있는정원농장
        LatLng hl_farm = new LatLng(36.6129, 127.0237);   //더 건강한 농원
        LatLng ta_farm = new LatLng(36.7535, 126.7004);   //오늘사과 예산농장
        LatLng fb_farm = new LatLng(36.3982, 127.0775);   //파인블루베리 농장
        LatLng sm_farm = new LatLng(36.3463, 127.1487);   //딸기마루
        LatLng bl_farm = new LatLng(36.2214, 126.7648);   //부여 딸기사랑 농원


        MarkerOptions markerOptions11 = new MarkerOptions();
        markerOptions11.position(hp_farm);
        markerOptions11.title("행복이있는정원농장");
        mMap.addMarker(markerOptions11);

        MarkerOptions markerOptions12 = new MarkerOptions();
        markerOptions12.position(hl_farm);
        markerOptions12.title("더 건강한 농원");
        mMap.addMarker(markerOptions12);

        MarkerOptions markerOptions13 = new MarkerOptions();
        markerOptions13.position(ta_farm);
        markerOptions13.title("오늘사과 예산농장");
        mMap.addMarker(markerOptions13);

        MarkerOptions markerOptions14 = new MarkerOptions();
        markerOptions14.position(fb_farm);
        markerOptions14.title("파인블루베리 농장");
        mMap.addMarker(markerOptions14);

        MarkerOptions markerOptions15 = new MarkerOptions();
        markerOptions15.position(sm_farm);
        markerOptions15.title("딸기마루");
        mMap.addMarker(markerOptions15);

        MarkerOptions markerOptions16 = new MarkerOptions();
        markerOptions16.position(bl_farm);
        markerOptions16.title("부여 딸기사랑 농원");
        mMap.addMarker(markerOptions16);


        //대전
        LatLng nj_farm = new LatLng(36.37447, 127.3146);   //노은주말농장
        LatLng gj_farm = new LatLng(36.2762, 127.3433);   //가수원주말농장
        LatLng ha_farm = new LatLng(36.3213, 127.4555);   //해피팜
        LatLng bj_farm = new LatLng(36.3696, 127.4760);   //봉산주말농장
        LatLng jo_farm = new LatLng(36.3891, 127.3491);   //적오산농장
        LatLng se_farm = new LatLng(36.4508, 127.3915);   //씨앗들 주말농장


        MarkerOptions markerOptions21 = new MarkerOptions();
        markerOptions21.position(nj_farm);
        markerOptions21.title("노은주말농장");
        mMap.addMarker(markerOptions21);

        MarkerOptions markerOptions22 = new MarkerOptions();
        markerOptions22.position(gj_farm);
        markerOptions22.title("가수원주말농장");
        mMap.addMarker(markerOptions22);

        MarkerOptions markerOptions23 = new MarkerOptions();
        markerOptions23.position(ha_farm);
        markerOptions23.title("해피팜");
        mMap.addMarker(markerOptions23);

        MarkerOptions markerOptions24 = new MarkerOptions();
        markerOptions24.position(bj_farm);
        markerOptions24.title("봉산주말농장");
        mMap.addMarker(markerOptions24);

        MarkerOptions markerOptions25 = new MarkerOptions();
        markerOptions25.position(jo_farm);
        markerOptions25.title("적오산농장");
        mMap.addMarker(markerOptions25);

        MarkerOptions markerOptions26 = new MarkerOptions();
        markerOptions26.position(se_farm);
        markerOptions26.title("씨앗들 주말농장");
        mMap.addMarker(markerOptions26);


        //세종
        LatLng wn_farm = new LatLng(36.6758, 127.2591);   //웰촌남새밭
        LatLng wc_farm = new LatLng(36.5849, 127.2424);   //와촌농장
        LatLng dr_farm = new LatLng(36.5721, 127.3212);   //두레농업타운
        LatLng sw_farm = new LatLng(36.5481, 127.2294);   //산우 주말농장
        LatLng rb_farm = new LatLng(36.5540, 127.2878);   //무지개농장

        MarkerOptions markerOptions31 = new MarkerOptions();
        markerOptions31.position(wn_farm);
        markerOptions31.title("웰촌남새밭");
        mMap.addMarker(markerOptions31);

        MarkerOptions markerOptions32 = new MarkerOptions();
        markerOptions32.position(wc_farm);
        markerOptions32.title("와촌농장");
        mMap.addMarker(markerOptions32);

        MarkerOptions markerOptions33 = new MarkerOptions();
        markerOptions33.position(dr_farm);
        markerOptions33.title("두레농업타운");
        mMap.addMarker(markerOptions33);

        MarkerOptions markerOptions34 = new MarkerOptions();
        markerOptions34.position(sw_farm);
        markerOptions34.title("산우 주말농장");
        mMap.addMarker(markerOptions34);

        MarkerOptions markerOptions35 = new MarkerOptions();
        markerOptions35.position(rb_farm);
        markerOptions35.title("무지개농장");
        mMap.addMarker(markerOptions35);



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bb_farm, 10));

        mMap.setOnMarkerClickListener(this);
    }


    @Override
    public boolean onMarkerClick(Marker marker){
        Intent intent = new Intent(MapActivity.this, DetailActivity.class);

        //충북
        if(marker.getTitle().equals("부부 농장")){
            intent.putExtra("code","4311135000");
        }
        else if(marker.getTitle().equals("하나로 대신 주말 농장")){
            intent.putExtra("code","4311425300");
        }

        else if(marker.getTitle().equals("청주농협주말농장")){
            intent.putExtra("code","4311134000");
        }

        else if(marker.getTitle().equals("오창다래농장")){
            intent.putExtra("code","4311425300");
        }

        else if(marker.getTitle().equals("산성동텃밭")){
            intent.putExtra("code","4311169000");
        }

        else if(marker.getTitle().equals("백송블루베리")){
            intent.putExtra("code","4311133000");
        }

        else if(marker.getTitle().equals("이찌방 딸기 농장")){
            intent.putExtra("code","4375025300");
        }


        //충남
        else if(marker.getTitle().equals("행복이있는정원농장 ")){
            intent.putExtra("code","4415056000");
        }

        else if(marker.getTitle().equals("더 건강한 농원")){
            intent.putExtra("code","4415025000");
        }

        else if(marker.getTitle().equals("오늘사과 예산농장")){
            intent.putExtra("code","4481038000");
        }

        else if(marker.getTitle().equals("파인블루베리 농장")){
            intent.putExtra("code","4415031000");
        }

        else if(marker.getTitle().equals("딸기마루")){
            intent.putExtra("code","4415033000");
        }

        else if(marker.getTitle().equals("부여 딸기사랑 농원")){
            intent.putExtra("code","4476036000");
        }


        //대전
        else if(marker.getTitle().equals("노은주말농장")){
            intent.putExtra("code","3020054800");
        }

        else if(marker.getTitle().equals("가수원주말농장")){
            intent.putExtra("code","3017059700");
        }

        else if(marker.getTitle().equals("해피팜")){
            intent.putExtra("code","3011055200");
        }

        else if(marker.getTitle().equals("봉산주말농장")){
            intent.putExtra("code","3011072500");
        }

        else if(marker.getTitle().equals("적오산농장")){
            intent.putExtra("code","3020055000");
        }

        else if(marker.getTitle().equals("씨앗들 주말농장")){
            intent.putExtra("code","3020058000");
        }

        //세종

        else if(marker.getTitle().equals("웰촌남새밭")){
            intent.putExtra("code","3611038000");
        }

        else if(marker.getTitle().equals("와촌농장")){
            intent.putExtra("code","3611036000");
        }

        else if(marker.getTitle().equals("두레농업타운")){
            intent.putExtra("code","3611032000");
        }

        else if(marker.getTitle().equals("산우 주말농장")){
            intent.putExtra("code","3611031000");
        }

        else if(marker.getTitle().equals("무지개농장")){
            intent.putExtra("code","3611036000");
        }

        startActivity(intent);
        return false;
    }


}