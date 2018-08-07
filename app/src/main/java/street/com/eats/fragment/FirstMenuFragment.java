package street.com.eats.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import street.com.eats.R;
import street.com.eats.activities.MainActivity;
import street.com.eats.adapter.SideMenuAdapter;
import street.com.eats.model.Menu;
import street.com.eats.transformation.HorizontalReside;


public class FirstMenuFragment extends Fragment {
    RecyclerView sidemenu;
    ImageView close;
    FrameLayout frame;

    public FirstMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first_menu, container, false);



        return view;
    }

    @Override
    public void onViewCreated(final View views, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(views, savedInstanceState);
       intialiseList(views);
      /* close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               View page=frame;
               HotelDashboard.reset();

           }
       });*/


    }
    private void intialiseList(View view)
    {
        List<Menu> detailList = new ArrayList<Menu>();
        detailList.add(new Menu("Home",R.mipmap.profile,new HotelDashboard()));
        detailList.add(new Menu("My Profile",R.mipmap.profile,new HotelDashboard()));
        detailList.add(new Menu("Recently Viewed",R.mipmap.viewed,new HotelDashboard()));
        detailList.add(new Menu("Favourites",R.mipmap.favorites,new HotelDashboard()));
        detailList.add(new Menu("Location",R.mipmap.location_color,new HotelDashboard()));
        detailList.add(new Menu("Rate Us",R.mipmap.rateus,new HotelDashboard()));
        detailList.add(new Menu("Settings",R.mipmap.settings,new HotelDashboard()));
        detailList.add(new Menu("About Us",R.mipmap.about_us,new HotelDashboard()));
        detailList.add(new Menu("Change Password",R.mipmap.about_us,new ChangePassword()));
        detailList.add(new Menu("Sign Out",R.mipmap.signout,new HotelDashboard()));

        sidemenu=(RecyclerView)view.findViewById(R.id.sidemenu);
        frame=(FrameLayout) view.findViewById(R.id.menuFirst);
        //close=(ImageView) view.findViewById(R.id.close);
        SideMenuAdapter adapter=new SideMenuAdapter(getActivity(),detailList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        sidemenu.setLayoutManager(mLayoutManager);
        sidemenu.setItemAnimator(new DefaultItemAnimator());
        sidemenu.setAdapter(adapter);
    }

}