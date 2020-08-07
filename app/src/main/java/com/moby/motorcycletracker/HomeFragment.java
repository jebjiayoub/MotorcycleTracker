package com.moby.motorcycletracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    //Button menu;
    //DrawerLayout dwl= (DrawerLayout) getView().findViewById(R.id.drawerLayout);

    /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this.getActivity(), dwl, R.string.open,R.string.close);

    NavigationView nv= (NavigationView) getView().findViewById(R.id.navview);*/

    GoogleMap mapApi;
    SupportMapFragment mapFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button b = (Button) view.findViewById(R.id.buttonmn);
        final DrawerLayout dl = (DrawerLayout) view.findViewById(R.id.drawerLayout);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Open Menu",Toast.LENGTH_LONG).show();
                dl.openDrawer(Gravity.LEFT);
            }
        });

        NavigationView nv = (NavigationView) view.findViewById(R.id.navview);
        nv.setNavigationItemSelectedListener(this);



        return view;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.Profile :
                this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                 break;
            case R.id.History :
                this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HistoryFragment()).commit();
                break;
        }


        // Handle navigation view item clicks here.
        /*int id = item.getItemId();

        if (id == R.id.History)
        {
            HistoryFragment historyFragment = new HistoryFragment();
            Toast.makeText(getContext(),"History",Toast.LENGTH_LONG).show();
            this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, historyFragment).commit();

        } else if (id == R.id.Tracker)
        {
            TrackerFragment trackerFragment = new TrackerFragment();
            Toast.makeText(getContext(),"Tracker",Toast.LENGTH_LONG).show();
            this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, trackerFragment).commit();

        } else if (id == R.id.Emergency_call)
        {
            CallFragment callFragment = new CallFragment();
            Toast.makeText(getContext(),"Emergency Call",Toast.LENGTH_LONG).show();
            this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, callFragment).commit();
        }*/

        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawerLayout);;
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {



        mapFragment = (SupportMapFragment) this.getActivity().getSupportFragmentManager().findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);

        mapApi = googleMap;
        LatLng emsi = new LatLng(33.5878561,-7.5966312);
        mapApi.addMarker(new MarkerOptions().position(emsi).title("EMSI"));
        mapApi.moveCamera(CameraUpdateFactory.newLatLng(emsi));

    }
}
