package street.com.eats.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.activities.SelectionHotel;
import street.com.eats.adapter.HotelDetailAdapter;
import street.com.eats.common.Hotel;

public class HotelInfo  extends Fragment {
    Toolbar androidToolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    CoordinatorLayout mRootLayout;
    RecyclerView mListView;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotel_info, container, false);

        Intent intent = getActivity().getIntent();
        Hotel data = (Hotel) intent.getSerializableExtra("name");

        init(view);
        initInstances(view);


        mCollapsingToolbarLayout.setTitle(data.name);

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


        HotelDetailAdapter adapter = new HotelDetailAdapter(getActivity(), detailList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mListView.setLayoutManager(mLayoutManager);
        mListView.setItemAnimator(new DefaultItemAnimator());
        mListView.setAdapter(adapter);


        return view;
    }

    private void init(View view) {
      /*  info = (LinearLayout) findViewById(R.id.info);
        location = (LinearLayout) findViewById(R.id.map);
        call = (LinearLayout) findViewById(R.id.call);
        reviews = (LinearLayout) findViewById(R.id.reviews);
        favourites = (LinearLayout) findViewById(R.id.favourites);

*/
        mListView = (RecyclerView) view.findViewById(R.id.listView);
        androidToolbar = (Toolbar) view.findViewById(R.id.toolbar_android);
        imageView = (ImageView) view.findViewById(R.id.parallax_header_imageview);

        ((SelectionHotel) getActivity()).setSupportActionBar(androidToolbar);
    }

    private void initInstances(View view) {

        ((SelectionHotel) getActivity()).getSupportActionBar().setTitle("");
        ((SelectionHotel) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((SelectionHotel) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRootLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorRootLayout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingToolbarLayoutAndroidExample);
    }
}