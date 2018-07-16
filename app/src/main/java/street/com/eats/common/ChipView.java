package street.com.eats.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import street.com.eats.R;

public class ChipView extends FrameLayout {

    public ChipView(Context context) {
        super(context);
        initializeView(context);
    }

    private void initializeView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chipview, this);
    }

    public void displayItem(String text) {
        ((TextView)findViewById(R.id.chipTextView)).setText(text);
    }
}