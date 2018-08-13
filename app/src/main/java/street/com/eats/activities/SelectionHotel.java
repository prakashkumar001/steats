package street.com.eats.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

import street.com.eats.R;
import street.com.eats.fragment.AddReview;
import street.com.eats.fragment.HotelInfo;
import street.com.eats.fragment.Location;
import street.com.eats.login.Login;

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
                showcallDialog();
                break;
            case R.id.reviews:
                callFragmentSelection(new AddReview());
                break;
            case R.id.favourites:
                break;

                default:
                    break;
        }
    }

    public void showcallDialog() {

        // custom dialog
        final Dialog dialog = new Dialog(SelectionHotel.this, R.style.ThemeDialogCustom);

        DisplayMetrics displayMetrics = new DisplayMetrics();
       getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthLcl = (int) (displayMetrics.widthPixels*0.9f);
        int heightLcl = (int) (displayMetrics.heightPixels*0.9f);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.call_popup);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();

        dialog.getWindow().setLayout((9 * widthLcl) / 10, (6 * heightLcl) / 10);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        ImageView iv_close=(ImageView)dialog.findViewById(R.id.iv_close);

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();



    }
}