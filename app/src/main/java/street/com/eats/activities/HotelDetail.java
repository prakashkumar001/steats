package street.com.eats.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import street.com.eats.R;

public class HotelDetail extends AppCompatActivity {
    Toolbar androidToolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    CoordinatorLayout mRootLayout;
    ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_detail);
        initToolbar();
        initInstances();

        mListView = (ListView) findViewById(R.id.listView);
        String[] listStringValue = new String[]{"Android ListView Example", "ListView Adapter Parallax Header", "Simple Example Parallax Header", "Android Parallax Header Example",
                "Parallax Header with ListView", "Parallax Header with GridView", "GridView Array Adapter", "Parallax Header Android Tutorial", "Android Example Parallax Header", "Android Project Source Code",
                "Download Parallax Header ListView", "Free Android Tutorial", "ScrollingViewBehavior for ListView", "ListView Inside NestedScrollView", "Scroll Layout Containing ListView", "Array Adapter Source Code",
                "Open Source Android Project", "Custom List View Inside NestedScrollView",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listStringValue);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                String itemValue = (String) mListView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "ListView Item Position :" + itemPosition + "  ListView Item Text : " + itemValue, Toast.LENGTH_LONG).show();
            }

        });
    }

    private void initToolbar() {
        androidToolbar = (Toolbar) findViewById(R.id.toolbar_android);
        setSupportActionBar(androidToolbar);
    }

    private void initInstances() {

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRootLayout = (CoordinatorLayout) findViewById(R.id.coordinatorRootLayout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayoutAndroidExample);
        mCollapsingToolbarLayout.setTitle("Viral Android");
    }


}