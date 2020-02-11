package kamran.textslider;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ahmed shaban on 5/11/2018.
 */

public class SliderItem implements Parcelable {
    public static final Creator<SliderItem> CREATOR = new Creator<SliderItem>() {
        @Override
        public SliderItem createFromParcel(Parcel in) {
            return new SliderItem(in);
        }

        @Override
        public SliderItem[] newArray(int size) {
            return new SliderItem[size];
        }
    };
    private String title;
    private String url = null;
    private int textSize = -1;
    private int resID = 0;
    private boolean isHTML = false;

    public SliderItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public SliderItem(String title, int textSize) {
        this.title = title;
        if (textSize != 0) {
            this.textSize = textSize;
        }
    }

    public SliderItem(String title, int textSize, int resID) {
        this.title = title;
        if (textSize != 0) {
            this.textSize = textSize;
        }
        this.resID = resID;
    }

    public SliderItem(String title, int textSize, String url) {
        this.title = title;
        if (textSize != 0) {
            this.textSize = textSize;
        }
        this.url = url;
    }
    public SliderItem(String title, int textSize, String url, boolean isHTML) {
        this.title = title;
        if (textSize != 0) {
            this.textSize = textSize;
        }
        this.url = url;
        this.isHTML = isHTML;
    }

    public SliderItem(String title, int textSize, boolean isHTML) {
        this.title = title;
        if (textSize != 0) {
            this.textSize = textSize;
        }
        this.isHTML = isHTML;
    }

    public SliderItem(String title, int textSize, int resID, boolean isHTML) {
        this.title = title;
        this.resID = resID;
        if (textSize != 0) {
            this.textSize = textSize;
        }
        this.isHTML = isHTML;
    }


    protected SliderItem(Parcel in) {
        title = in.readString();
        url = in.readString();
        resID = in.readInt();
        textSize = in.readInt();
        isHTML = in.readInt() == 1;
    }

    public boolean isHTML() {
        return isHTML;
    }

    public void setHTML(boolean HTML) {
        isHTML = HTML;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(url);
        parcel.writeInt(resID);
        parcel.writeInt(textSize);
        parcel.writeInt(isHTML ? 1 : 0);
    }
}
