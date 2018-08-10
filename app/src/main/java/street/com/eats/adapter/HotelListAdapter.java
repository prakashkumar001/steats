package street.com.eats.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import street.com.eats.R;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.MyViewHolder> {

    Activity ctx;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productname;



        public MyViewHolder(View view) {
            super(view);
            productname = (TextView) view.findViewById(R.id.title);


        }
    }


    public HotelListAdapter(Activity context) {

        ctx = context;

    }

    @Override
    public HotelListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);


        return new HotelListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HotelListAdapter.MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


}
