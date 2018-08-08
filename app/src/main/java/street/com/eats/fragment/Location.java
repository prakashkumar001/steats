package street.com.eats.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import street.com.eats.R;

public class Location  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first_menu, container, false);
        if(view.getScaleX()==1.0f)
        {

        }else
        {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.animate().translationX((float) (view.getWidth() * -1));
            // frame.setTranslationX((float) (frame.getWidth() * -1));

        }


        return view;
    }
}
