package com.example.hwhan.finalproject;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;

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

    Button search ;
    FloatingActionButton mylocate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<CropData> testList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_map);

        search = (Button) findViewById(R.id.search);
        mylocate = (FloatingActionButton) findViewById(R.id.mylocate);

      /*  RecyclerView cropview = (RecyclerView)findViewById(R.id.RV1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        cropview.setLayoutManager(layoutManager);
        testList.add(new CropData("감자", "30000", "5"));
        CropListAdapter adapter = new CropListAdapter(testList);
        cropview.setAdapter(adapter);
*/

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent);//액티비티 띄우기
            }
        });

        mylocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MyLocate.class);
                startActivity(intent);//액티비티 띄우기
            }
        });


    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
      /*  markerOptions.title("감자");
        markerOptions.snippet("수확시기 : 심은 후 80일 ~ 100일");
        map.addMarker(markerOptions);
*/
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

}

