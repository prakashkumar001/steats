package street.com.eats.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import street.com.eats.R;
import street.com.eats.activities.MainActivity;
import street.com.eats.fragment.FirstMenuFragment;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    Fragment comedy = details.get(position).fragment;

                    FragmentManager fragmentManager = ((MainActivity) ctx).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.contentPage, comedy)
                            .commit();

                View activeView = comedy.getView();
                activeView.setScaleX(1.0f);
                activeView.setScaleY(1.0f);
                activeView.animate().translationX((float) (activeView.getWidth() * -1));


            }
        });

    }

    @Override
    public int getItemCount() {
        return details.size();
    }


}
