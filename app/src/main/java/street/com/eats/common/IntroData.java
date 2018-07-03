package street.com.eats.common;

/**
 * Created by Prakash on 7/3/2018.
 */

public class IntroData {
    public IntroData(int drawable, String content) {
        this.drawable = drawable;
        this.content = content;
    }

    public int drawable;

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String content;
}
