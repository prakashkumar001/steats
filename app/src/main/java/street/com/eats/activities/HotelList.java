package street.com.eats.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.adapter.HotelListAdapter;
import street.com.eats.adapter.SideMenuAdapter;
import street.com.eats.common.Hotel;
import street.com.eats.model.Menu;

public class HotelList extends AppCompatActivity {
    RecyclerView hotelList;
    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list);
        init();
        Intent bundle = getIntent();
        if (bundle != null) {
            String titleText = bundle.getStringExtra("name");
            title.setText(titleText);
        }


        HotelListAdapter adapter=new HotelListAdapter(HotelList.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HotelList.this);
        hotelList.setLayoutManager(mLayoutManager);
        hotelList.setItemAnimator(new DefaultItemAnimator());
        hotelList.setAdapter(adapter);

    }

    void init()
    {
        hotelList=(RecyclerView)findViewById(R.id.hotelList);
        title=(TextView)findViewById(R.id.title);

    }
}
