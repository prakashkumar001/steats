package street.com.eats.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import street.com.eats.R;
import street.com.eats.model.Menu;

public class SideMenuAdapter extends RecyclerView.Adapter<SideMenuAdapter.MyViewHolder> {

    List<Menu> details;
    Activity ctx;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productname;
        public ImageView image;



        public MyViewHolder(View view) {
            super(view);
            productname = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);


        }
    }


    public SideMenuAdapter(Activity context, List<Menu> details) {

        this.details = details;
        ctx = context;

    }

    @Override
    public SideMenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nav_list_item, parent, false);


        return new SideMenuAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SideMenuAdapter.MyViewHolder holder, final int position) {
        holder.productname.setText(details.get(position).name);
        holder.image.setImageResource(details.get(position).logo);


    }

    @Override
    public int getItemCount() {
        return details.size();
    }


}
