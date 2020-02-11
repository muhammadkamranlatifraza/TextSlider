package kamran.textslider;

import android.os.Bundle;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;


/**
 * Created by Ahmed shaban on 5/11/2018.
 * Modified by Muhammad Kamran Latif Raza on 2/11/2020.
 */


/**
 * A placeholder fragment containing a simple view.
 */
public class SliderFragment extends Fragment {

    int textSize = -1;
    SliderItem item;
    LinearLayout title_layout;
    TextView title;
    ImageView imageView;
    //    int textSize;
    EasySliderListener easySliderListener;
    int position = -1;
    boolean isHTML;

    public SliderFragment() {
    }

    public static SliderFragment newInstance(SliderItem item, int position) {
        SliderFragment fragment = new SliderFragment();
        Bundle args = new Bundle();
        args.putParcelable("item", item);
        args.putInt("position", position);
        args.putInt("textSize", item.getTextSize());
        args.putBoolean("isHTML", item.isHTML());
//        textSize = item.getTextSize();
        fragment.setArguments(args);
        return fragment;
    }

    public EasySliderListener getEasySliderListener() {
        return easySliderListener;
    }

    public void setEasySliderListener(EasySliderListener easySliderListener) {
        this.easySliderListener = easySliderListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = getArguments()
                .getParcelable("item");
        textSize = getArguments().getInt("textSize");
        position = getArguments().getInt("position");

        isHTML = getArguments().getBoolean("isHTML");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.slider_item_container, container, false);
        title = rootView.findViewById(R.id.title);
        title_layout = rootView.findViewById(R.id.title_layout);
        imageView = rootView.findViewById(R.id.img);

        if (item.getTitle() != null) {
            if (isHTML) {
                title.setText(Html.fromHtml(item.getTitle()));
            } else {
                title.setText(item.getTitle());
            }
            title_layout.setVisibility(View.VISIBLE);
            if (textSize != 0) {
                title.setTextSize(textSize);
            }
        } else {
            title_layout.setVisibility(View.GONE);
        }

        if (item.getResID() != 0) {
            Picasso.get()
                    .load(item.getResID())
                    .into(imageView);
        } else if (item.getUrl() != null) {
            Picasso.get()
                    .load(item.getUrl())
                    .into(imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (easySliderListener != null) {
                    easySliderListener.onItemClick(position);
                }
            }
        });


        return rootView;
    }

    public void showTitle() {
        // hideTitle();
        Animation bottomUp = AnimationUtils.loadAnimation(getContext(), R.anim.bottom_up);
        title_layout.startAnimation(bottomUp);
        title_layout.setVisibility(View.VISIBLE);
    }


    public void hideTitle() {
        title_layout.setVisibility(View.GONE);
    }
}

