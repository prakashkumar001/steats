package street.com.eats.common;


import java.util.List;

public class Snap {

    private int mGravity;
    private String mText;
    private List<Hotel> mHotelList;

    public Snap(int gravity, String text, List<Hotel> HotelList) {
        mGravity = gravity;
        mText = text;
        mHotelList = HotelList;
    }

    public String getText(){
        return mText;
    }

    public int getGravity(){
        return mGravity;
    }

    public List<Hotel> getApps(){
        return mHotelList;
    }

}
