package street.com.eats.carosal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import street.com.eats.R;
import street.com.eats.activities.MainActivity;
import street.com.eats.fragment.AboutFragment;
import street.com.eats.fragment.AboutUs;

public class CarosaulAdapter extends FragmentPagerAdapter implements ViewPager.PageTransformer {
        public final static float BIG_SCALE = 1.0f;
        public final static float SMALL_SCALE = 0.7f;
        public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

        private MyLinearLayout cur = null;
        private MyLinearLayout next = null;
        private MainActivity context;
        private FragmentManager fm;
        private float scale;

        public CarosaulAdapter(MainActivity context, FragmentManager fm) {
            super(fm);
            this.fm = fm;
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            // make the first pager bigger than others
            if (position == AboutUs.FIRST_PAGE)
                scale = BIG_SCALE;
            else
                scale = SMALL_SCALE;

            position = position % AboutUs.PAGES;
            return AboutFragment.newInstance(context, position, scale);
        }

        @Override
        public int getCount() {
            return AboutUs.PAGES * AboutUs.LOOPS;
        }

        @Override
        public void transformPage(View page, float position) {
            MyLinearLayout myLinearLayout = (MyLinearLayout) page.findViewById(R.id.root);
            float scale = BIG_SCALE;
            if (position > 0) {
                scale = scale - position * DIFF_SCALE;
            } else {
                scale = scale + position * DIFF_SCALE;
            }
            if (scale < 0) scale = 0;
            myLinearLayout.setScaleBoth(scale);
        }
    }

