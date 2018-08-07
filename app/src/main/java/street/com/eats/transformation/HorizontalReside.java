package street.com.eats.transformation;

import android.support.v4.view.ViewPager;
import android.view.View;

import street.com.eats.R;
import street.com.eats.common.GlobalClass;


public abstract class HorizontalReside implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {

        //Hiding those pages which are way off-screen to the left or to the right.
        if (position < -1) {
            page.setAlpha(0);

        } else if (position > 1) {
            page.setAlpha(0);

        } else {
            page.setAlpha(1);

        }


        if (page.getId() == R.id.menuFirst){
            //putting fragment to the start of the screen
            page.setTranslationX(-position*page.getWidth());
        }
        else if (page.getId() == R.id.contentPage){
            //when we swipe to left this code applied
            if (position <= 0){

                //first we do scaling to 50%
                float scale = Math.max(0.6f,1-Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);

                float deltaWidth = page.getWidth() - scale*page.getWidth();


                page.setTranslationX(-position*page.getWidth() - deltaWidth/2);


            }
            //when we swipe to right this code applied
            else if (position > 0){

                //first we do scaling to 50%
                float scale = Math.max(0.8f,1-Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);

                float deltaWidth = page.getWidth()/2 - scale*page.getWidth()/2;


                page.setTranslationX(-position*page.getWidth()/2 + deltaWidth/2);

            }
        }
       /* else if (page.getId() == R.id.menuSecond){
            //putting fragment to the start of the screen
            page.setTranslationX(-position*page.getWidth());
        }
*/
    }
    protected abstract void transformPage(final View page, final int pageIndex, final float position);

}
