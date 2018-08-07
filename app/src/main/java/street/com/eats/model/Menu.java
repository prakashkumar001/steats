package street.com.eats.model;


import android.support.v4.app.Fragment;

import java.io.Serializable;

public class Menu  {
    public String name;
    public int logo;
    public Fragment fragment;

    public Menu(String name, int logo, Fragment fragment) {
        this.name = name;
        this.logo = logo;
        this.fragment=fragment;
    }
}
