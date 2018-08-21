package street.com.eats.common;

import android.content.Context;
import android.content.SharedPreferences;

public class Shared {
 
    private static Shared INSTANCE = null;

    private  String APP_SETTINGS = "APP_SETTINGS";


    // properties
    private   String SOME_STRING_VALUE = "SOME_STRING_VALUE";
 
    // other instance variables can be here
     
    private Shared() {};
 
    public static Shared getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Shared();
        }
        return(INSTANCE);
    }
     
    // other instance methods can follow

    private  SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
    }

    public  String getSomeStringValue(Context context) {
        return getSharedPreferences(context).getString(SOME_STRING_VALUE , null);
    }

    public void setSomeStringValue(Context context, String newValue) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(SOME_STRING_VALUE , newValue);
        editor.commit();

    }

}