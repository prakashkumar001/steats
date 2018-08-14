package street.com.eats.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseDrawer;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import java.util.ArrayList;
import java.util.List;

import street.com.eats.R;
import street.com.eats.activities.MainActivity;
import street.com.eats.adapter.Adapter;
import street.com.eats.adapter.MyPagerAdapter;
import street.com.eats.adapter.SnapAdapter;
import street.com.eats.common.GlobalClass;
import street.com.eats.common.Hotel;
import street.com.eats.common.Snap;

/**
 * Created by Creative IT Works on 09-Jul-18.
 */

public class HotelDashboard extends Fragment {

    RecyclerView recyclerView;
    List<Hotel> hotelList;
    public  FrameLayout frame;
    public static final String ORIENTATION = "orientation";
    ImageView back;
    private boolean mHorizontal;
    ShowcaseView sv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.hotel_dashboard, container, false);

        intailiseView(view);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                ViewTarget target = new ViewTarget(view.findViewById(R.id.back));


             /*   new ShowcaseView.Builder(getActivity())
                        .setTarget(new ViewTarget(R.id.back, getActivity()))
                        .setContentTitle("Its My Navigation Drawer")
                        .setContentText("Click here and you will get options to navigate to other sections.")
                        .setShowcaseDrawer(new CustomShowcaseView(getResources()))
                        .build();*/

                new ShowcaseView.Builder(getActivity())
                        .withMaterialShowcase()
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .setTarget(new ViewTarget(R.id.back, getActivity()))
                        .hideOnTouchOutside()
                        .setContentTitle("Its My Navigation Drawer")
                        .setContentText("Click here and you will get options to navigate to other sections.")
                        .build();
            }
        },1000);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!MainActivity.isOpen)
                {
                    MainActivity.showPage();
                }else
                {
                    MainActivity.isOpen=false;
                    MainActivity.viewPager.setCurrentItem(1);
                }

            }
        });

        return view;
    }

    private void intailiseView(View view)
    {

        frame=(FrameLayout) view.findViewById(R.id.contentPage);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        back=(ImageView) view.findViewById(R.id.back);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        List<Hotel> apps = getHotelList();

        SnapAdapter snapAdapter = new SnapAdapter();
        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "All", apps));
        snapAdapter.addSnap(new Snap(Gravity.START, "Nearby", apps));
        snapAdapter.addSnap(new Snap(Gravity.END, "Popular", apps));
        recyclerView.setAdapter(snapAdapter);






    }

    private List<Hotel> getHotelList() {
        List<Hotel> apps = new ArrayList<>();
        apps.add(new Hotel("Phoenix Mexican", R.drawable.phoenix));
        apps.add(new Hotel("Grand Chola", R.drawable.grand));
        apps.add(new Hotel("Plaza", R.drawable.plaza));
        apps.add(new Hotel("Le-Meridian", R.drawable.lemeridain));
        apps.add(new Hotel("Thalapakatti", R.drawable.thalapakatti));


        return apps;
    }

    private static class CustomShowcaseView implements ShowcaseDrawer {

        private final float width;
        private final float height;
        private final Paint eraserPaint;
        private final Paint basicPaint;
        private final int eraseColour;
        private final RectF renderRect;

        public CustomShowcaseView(Resources resources) {
            width = resources.getDimension(R.dimen.custom_showcase_width);
            height = resources.getDimension(R.dimen.custom_showcase_height);
            PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
            eraserPaint = new Paint();
            eraserPaint.setColor(0xFFFFFF);
            eraserPaint.setAlpha(0);
            eraserPaint.setXfermode(xfermode);
            eraserPaint.setAntiAlias(true);
            eraseColour = Color.parseColor("#50FF562F");
            basicPaint = new Paint();
            renderRect = new RectF();
        }

        @Override
        public void setShowcaseColour(int color) {
            eraserPaint.setColor(color);
        }

        @Override
        public void drawShowcase(Bitmap buffer, float x, float y, float scaleMultiplier) {
            Canvas bufferCanvas = new Canvas(buffer);
            renderRect.left = x - width / 2f;
            renderRect.right = x + width / 2f;
            renderRect.top = y - height / 2f;
            renderRect.bottom = y + height / 2f;
            bufferCanvas.drawRect(renderRect, eraserPaint);
        }

        @Override
        public int getShowcaseWidth() {
            return (int) width;
        }

        @Override
        public int getShowcaseHeight() {
            return (int) height;
        }

        @Override
        public float getBlockedRadius() {
            return width;
        }

        @Override
        public void setBackgroundColour(int backgroundColor) {
            // No-op, remove this from the API?
        }

        @Override
        public void erase(Bitmap bitmapBuffer) {
            bitmapBuffer.eraseColor(eraseColour);
        }

        @Override
        public void drawToCanvas(Canvas canvas, Bitmap bitmapBuffer) {
            canvas.drawBitmap(bitmapBuffer, 0, 0, basicPaint);
        }

    }


}
