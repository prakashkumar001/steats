package street.com.eats.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChipsAdapter extends RecyclerView.Adapter {

    private List<String> chipsArray;

    public ChipsAdapter(List<String> chipsArray) {
        this.chipsArray = chipsArray;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChipViewHolder(new ChipView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChipView)holder.itemView).displayItem(chipsArray.get(position));
    }

    @Override
    public int getItemCount() {
        return chipsArray.size();
    }

    private class ChipViewHolder extends RecyclerView.ViewHolder {

        public ChipViewHolder(View itemView) {
            super(itemView);
        }
    }
}