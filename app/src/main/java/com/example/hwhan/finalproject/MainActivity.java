package com.example.hwhan.finalproject;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<CropData> testList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_map);

        RecyclerView CropView = findViewById(R.id.RV1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        CropView.setLayoutManager(layoutManager);
        testList.add(new CropData("감자", "30000", "5"));
        CropListAdapter adapter = new CropListAdapter(testList);
        CropView.setAdapter(adapter);



        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("감자");
        markerOptions.snippet("는 맛있다.");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

}

