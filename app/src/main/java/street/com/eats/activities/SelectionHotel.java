package street.com.eats.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import street.com.eats.R;
import street.com.eats.fragment.HotelInfo;
import street.com.eats.fragment.Location;

public class SelectionHotel extends AppCompatActivity implements View.OnClickListener{

    LinearLayout info, location, favourites, reviews, call;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_hotel);

        init();
        callFragmentSelection(new HotelInfo());

        info.setOnClickListener(this);
        location.setOnClickListener(this);
        call.setOnClickListener(this);
        reviews.setOnClickListener(this);
        favourites.setOnClickListener(this);


    }

    void init() {
        info = (LinearLayout) findViewById(R.id.info);
        location = (LinearLayout) findViewById(R.id.map);
        call = (LinearLayout) findViewById(R.id.call);
        reviews = (LinearLayout) findViewById(R.id.reviews);
        favourites = (LinearLayout) findViewById(R.id.favourites);

    }
    void callFragmentSelection(Fragment fragment)
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.info:
                callFragmentSelection(new HotelInfo());
                break;
            case R.id.map:
                callFragmentSelection(new Location());

                break;
            case R.id.call:
                break;
            case R.id.reviews:
                break;
            case R.id.favourites:
                break;

                default:
                    break;
        }
    }
}