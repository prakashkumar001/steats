package street.com.eats.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.activities.MainActivity;
import street.com.eats.adapter.Adapter;
import street.com.eats.adapter.MyPagerAdapter;
import street.com.eats.adapter.SnapAdapter;
import street.com.eats.common.GlobalClass;
import street.com.eats.common.Hotel;
import street.com.eats.common.Snap;

/**
 * Created by Creative IT Works on 09-Jul-18.
 */

public class HotelDashboard extends Fragment{
    RecyclerView recyclerView;
    List<Hotel> hotelList;
    public  FrameLayout frame;
    public static final String ORIENTATION = "orientation";
    ImageView back;
    private boolean mHorizontal;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.hotel_dashboard, container, false);

        intailiseView(view);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showPage();
            }
        });

        return view;
    }

    private void intailiseView(View view)
    {

        frame=(FrameLayout) view.findViewById(R.id.contentPage);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        back=(ImageView) view.findViewById(R.id.back);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        List<Hotel> apps = getHotelList();

        SnapAdapter snapAdapter = new SnapAdapter();
        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "All", apps));
        snapAdapter.addSnap(new Snap(Gravity.START, "Nearby", apps));
        snapAdapter.addSnap(new Snap(Gravity.END, "Popular", apps));
        recyclerView.setAdapter(snapAdapter);






    }

    private List<Hotel> getHotelList() {
        List<Hotel> apps = new ArrayList<>();
        apps.add(new Hotel("Phoenix Mexican", R.drawable.phoenix));
        apps.add(new Hotel("Grand Chola", R.drawable.grand));
        apps.add(new Hotel("Plaza", R.drawable.plaza));
        apps.add(new Hotel("Le-Meridian", R.drawable.lemeridain));
        apps.add(new Hotel("Thalapakatti", R.drawable.thalapakatti));


        return apps;
    }



}
