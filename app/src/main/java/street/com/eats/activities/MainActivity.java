package street.com.eats.activities;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.adapter.HotelDetailAdapter;
import street.com.eats.adapter.MyPagerAdapter;
import street.com.eats.adapter.SideMenuAdapter;
import street.com.eats.common.GlobalClass;
import street.com.eats.fragment.FirstMenuFragment;
import street.com.eats.fragment.HotelDashboard;
import street.com.eats.model.Menu;
import street.com.eats.transformation.HorizontalReside;


public class MainActivity extends AppCompatActivity  {

   public static ViewPager viewPager;
    public static MyPagerAdapter myPagerAdapter;
    public static float scale;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    viewPager = (ViewPager)findViewById(R.id.viewpager);

    //setting fragment pager adapter
    myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
    myPagerAdapter.addFragments(new FirstMenuFragment());
    myPagerAdapter.addFragments(new HotelDashboard());

    //viewPager.setPageTransformer(true, new HorizontalReside());
    viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
        @Override
        public void transformPage(View page, float position) {
            if (page.getId() == R.id.menuFirst){
                //putting fragment to the start of the screen
                page.setTranslationX(-position*page.getWidth());
            }
            else if (page.getId() == R.id.contentPage){
                //when we swipe to left this code applied
                if (position <= 0){

                    //first we do scaling to 50%
                     scale = Math.max(0.6f,1-Math.abs(position));
                    page.setScaleX(scale);
                    page.setScaleY(scale);

                    float deltaWidth = page.getWidth() - scale*page.getWidth();


                    page.setTranslationX(-position*page.getWidth() - deltaWidth/2);


                }
                //when we swipe to right this code applied
                else if (position > 0){

                    //first we do scaling to 50%
                     scale = Math.max(0.8f,1-Math.abs(position));
                    page.setScaleX(scale);
                    page.setScaleY(scale);

                    float deltaWidth = page.getWidth()/2 - scale*page.getWidth()/2;


                    page.setTranslationX(-position*page.getWidth()/2 + deltaWidth/2);

                }
            }
        }
    });
    //set adapter to vewpager instance
    viewPager.setAdapter(myPagerAdapter);

    viewPager.setCurrentItem(1);    //page shown to user when he opened the app
   // home();


        }
    //method called when user clicked on menu fragment layouts
    public void showPage(View view){
        viewPager.setCurrentItem(1);
    }



}