package street.com.eats.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import street.com.eats.R;
import street.com.eats.activities.MainActivity;
import street.com.eats.carosal.MyLinearLayout;

public class AboutFragment extends Fragment {
    int drawables[]=new int[]{R.mipmap.abt_first,R.mipmap.abt_second,R.mipmap.abt_third};
    public static Fragment newInstance(MainActivity context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);
        return Fragment.instantiate(context, AboutFragment.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }


        LinearLayout l = (LinearLayout)
                inflater.inflate(R.layout.about_us_item, container, false);

        int pos = this.getArguments().getInt("pos");
        ImageView tv = (ImageView) l.findViewById(R.id.image);
        tv.setImageResource(drawables[pos]);

        MyLinearLayout root = (MyLinearLayout) l.findViewById(R.id.root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return l;
    }
}