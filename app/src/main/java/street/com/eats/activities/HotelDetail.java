package street.com.eats.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.adapter.HotelDetailAdapter;
import street.com.eats.common.Hotel;

public class HotelDetail extends AppCompatActivity {
    Toolbar androidToolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    CoordinatorLayout mRootLayout;
    RecyclerView mListView;
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_detail);
        Intent intent=getIntent();
        Hotel data= (Hotel) intent.getSerializableExtra("name");

        initToolbar();
        initInstances();

        mListView = (RecyclerView) findViewById(R.id.listView);
        mCollapsingToolbarLayout.setTitle(data.name);

        imageView=(ImageView)findViewById(R.id.parallax_header_imageview);
        imageView.setImageResource(data.logo);

        List<String> detailList = new ArrayList<String>();
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");
        detailList.add("1 Cup mayonise sauce or 1 Cup salad dressing");



        HotelDetailAdapter adapter=new HotelDetailAdapter(HotelDetail.this,detailList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HotelDetail.this);
        mListView.setLayoutManager(mLayoutManager);
        mListView.setItemAnimator(new DefaultItemAnimator());
        mListView.setAdapter(adapter);


    }

    private void initToolbar() {
        androidToolbar = (Toolbar) findViewById(R.id.toolbar_android);
        setSupportActionBar(androidToolbar);
    }

    private void initInstances() {

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRootLayout = (CoordinatorLayout) findViewById(R.id.coordinatorRootLayout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayoutAndroidExample);
    }


}