package street.com.eats.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.common.ChipsAdapter;

public class AddReview extends Fragment {
    RecyclerView reviews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.add_review, container, false);
        reviews= (RecyclerView)view.findViewById(R.id.recyclerView);
        reviews.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }
}
