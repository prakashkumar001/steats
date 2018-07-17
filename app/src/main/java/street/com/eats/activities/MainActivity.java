package street.com.eats.activities;

import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.adapter.HotelDetailAdapter;
import street.com.eats.adapter.SideMenuAdapter;
import street.com.eats.fragment.HotelDashboard;
import street.com.eats.model.Menu;


public class MainActivity extends AppCompatActivity {
        RecyclerView sidemenu;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intialiseList();
        home();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


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



        private void intialiseList()
        {
                List<Menu> detailList = new ArrayList<Menu>();
                detailList.add(new Menu("My Profile",R.mipmap.profile));
                detailList.add(new Menu("Recently Viewed",R.mipmap.viewed));
                detailList.add(new Menu("Favourites",R.mipmap.favorites));
                detailList.add(new Menu("Location",R.mipmap.location_color));
                detailList.add(new Menu("Rate Us",R.mipmap.rateus));
                detailList.add(new Menu("Settings",R.mipmap.settings));
                detailList.add(new Menu("About Us",R.mipmap.about_us));
                detailList.add(new Menu("Sign Out",R.mipmap.signout));

                sidemenu=(RecyclerView)findViewById(R.id.sidemenu);
                SideMenuAdapter adapter=new SideMenuAdapter(MainActivity.this,detailList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                sidemenu.setLayoutManager(mLayoutManager);
                sidemenu.setItemAnimator(new DefaultItemAnimator());
                sidemenu.setAdapter(adapter);
        }


        private void home()
        {

                HotelDashboard hoteldashbaord=new HotelDashboard();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, hoteldashbaord).commit();
        }
        void closeDrawer()
        {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

        }
        }