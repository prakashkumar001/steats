package street.com.eats.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.common.ChipsAdapter;

public class AddReview extends AppCompatActivity {
    RecyclerView chipRecyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chipRecyclerView= (RecyclerView)findViewById(R.id.recyclerView);
        chipRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> chipsArray = new ArrayList<>();
        chipsArray.add("Fitness");
        chipsArray.add("Gaming");
        chipsArray.add("Education");
        chipsArray.add("Animals");
        chipsArray.add("Cars");


        chipRecyclerView.setAdapter(new ChipsAdapter(chipsArray));

    }
}
