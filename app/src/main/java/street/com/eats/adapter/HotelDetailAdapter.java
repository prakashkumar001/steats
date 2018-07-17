package street.com.eats.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;




    public class HotelDetailAdapter extends RecyclerView.Adapter<HotelDetailAdapter.MyViewHolder> {

        List<String> details;
        Activity ctx;



        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView productname;



            public MyViewHolder(View view) {
                super(view);
                productname = (TextView) view.findViewById(R.id.title);


            }
        }


        public HotelDetailAdapter(Activity context, List<String> details) {

            this.details = details;
            ctx = context;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.hotel_detail_item, parent, false);


            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.productname.setText(details.get(position));

        }

        @Override
        public int getItemCount() {
            return details.size();
        }


}
