package street.com.eats.common;

import java.io.Serializable;

/**
 * Created by Creative IT Works on 09-Jul-18.
 */

public class Hotel implements Serializable {
    public String name;
    public int logo;

    public Hotel(String name, int logo) {
        this.name = name;
        this.logo = logo;
    }
}
