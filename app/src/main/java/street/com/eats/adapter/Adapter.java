package street.com.eats.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import street.com.eats.R;
import street.com.eats.common.Hotel;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Hotel> mHotelList;
    private boolean mHorizontal;
    private boolean mPager;

    public Adapter(boolean horizontal, boolean pager, List<Hotel> HotelList) {
        mHorizontal = horizontal;
        mHotelList = HotelList;
        mPager = pager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mPager) {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_pager, parent, false));
        } else {
            return mHorizontal ? new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter, parent, false)) :
                    new ViewHolder(LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.adapter_vertical, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hotel app = mHotelList.get(position);
        holder.imageView.setImageResource(app.logo);
        holder.nameTextView.setText(app.name);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mHotelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView nameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }

        @Override
        public void onClick(View v) {
            Log.d("App", mHotelList.get(getAdapterPosition()).name);
        }
    }

}

