package com.charfouni.karim.vacancemaroc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ResidencesFragment.OnFragmentInteractionListener,
        HotelsFragment.OnFragmentInteractionListener,
        RiadsFragment.OnFragmentInteractionListener,
        AubergeFragment.OnFragmentInteractionListener,
        RestaurantFragment.OnFragmentInteractionListener,
        CafeFragment.OnFragmentInteractionListener,
        PiscineFragment.OnFragmentInteractionListener,
        CinemaFragment.OnFragmentInteractionListener,
        InternationalBrandFragment.OnFragmentInteractionListener,
        LocalProductsFragment.OnFragmentInteractionListener,
        ArtisanatMarocaineFragment.OnFragmentInteractionListener,
        LocationVoitureFragment.OnFragmentInteractionListener,
        AgenceVoyageFragment.OnFragmentInteractionListener,
        MarrakechFragment.OnFragmentInteractionListener,
        CasablancaFragment.OnFragmentInteractionListener,
        GuideTouristiqueFragment.OnFragmentInteractionListener,
        AvisiterFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        GridView mainGridView=(GridView)findViewById(R.id.gridViewMain);
         DatabaseHelper databaseHelper=new DatabaseHelper(this);
        try {

            databaseHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }



        databaseHelper.openDataBase();


        //databaseHelper.deleteAllrecords();



        final ArrayList<Place> places=databaseHelper.getAllRecord();
        final ArrayList<Integer> images=new ArrayList<>();
        images.add(R.drawable.artisanat_marocain);
        images.add(R.drawable.aqua_park);
        images.add(R.drawable.bedroom);

        mainGridView.setAdapter(new MyPlaceAdapter(places));
        mainGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("hotelName",places.get(position).getName());
                intent.putExtra("hotelDescription",places.get(position).getDescription());
                intent.putExtra("hoteladdress",places.get(position).getAddress());
                intent.putExtra("images",images);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.marrakech) {
            // Handle the camera action
            MarrakechFragment marrakechFragment=new MarrakechFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,marrakechFragment).commit();

        } else if (id == R.id.casablanca) {
            CasablancaFragment casablancaFragment=new CasablancaFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,casablancaFragment).commit();
        } else if (id == R.id.hotels) {
            HotelsFragment hotelsFragment=new HotelsFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,hotelsFragment).commit();

        } else if (id == R.id.residences) {
            ResidencesFragment residencesFragment=new ResidencesFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,residencesFragment).commit();

        } else if (id == R.id.riads) {
            RiadsFragment riadsFragment=new RiadsFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,riadsFragment).commit();

        } else if (id == R.id.auberges) {
            AubergeFragment aubergeFragment=new AubergeFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,aubergeFragment).commit();

        } else if (id == R.id.restaurnats) {
            RestaurantFragment restaurantFragment=new RestaurantFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,restaurantFragment).commit();

        } else if (id == R.id.cafes) {
            CafeFragment cafeFragment=new CafeFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,cafeFragment).commit();

        } else if (id == R.id.piscines) {
            PiscineFragment piscineFragment=new PiscineFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,piscineFragment).commit();

        } else if (id == R.id.cinemas) {
            CinemaFragment cinemaFragment=new CinemaFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,cinemaFragment).commit();

        } else if (id == R.id.international_brand) {
            InternationalBrandFragment internationalBrandFragment=new InternationalBrandFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,internationalBrandFragment).commit();

        } else if (id == R.id.local_products) {
            LocalProductsFragment localProductsFragment=new LocalProductsFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,localProductsFragment).commit();

        } else if (id == R.id.artisanat_marocaine) {
            ArtisanatMarocaineFragment artisanatMarocaineFragment=new ArtisanatMarocaineFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,artisanatMarocaineFragment).commit();

        } else if (id == R.id.location_voitures) {
            LocationVoitureFragment locationVoitureFragment=new LocationVoitureFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,locationVoitureFragment).commit();

        } else if (id == R.id.agence_voyage) {
            AgenceVoyageFragment agenceVoyageFragment=new AgenceVoyageFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,agenceVoyageFragment).commit();

        } else if (id == R.id.guides_touristiques) {
            GuideTouristiqueFragment guideTouristiqueFragment=new GuideTouristiqueFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,guideTouristiqueFragment).commit();

        } else if (id == R.id.visiter) {
            AvisiterFragment avisiterFragment=new AvisiterFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.ConstraintLayout,avisiterFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
