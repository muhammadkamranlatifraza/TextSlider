package kamran.textslider;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Ahmed shaban on 5/11/2018.
 * Modified by Muhammad Kamran Latif Raza on 2/11/2020.
 */

public class SliderAdapter extends FragmentPagerAdapter {
    List<SliderItem> sliderItems;
    EasySliderListener easySliderListener;

    public SliderAdapter(FragmentManager fm, List<SliderItem> sliderItems, EasySliderListener easySliderListener) {
        super(fm);
        this.sliderItems = sliderItems;
        this.easySliderListener = easySliderListener;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = SliderFragment.newInstance(sliderItems.get(position), position);
        ((SliderFragment) fragment).setEasySliderListener(new EasySliderListener() {
            @Override
            public void onItemClick(int position) {
                if (easySliderListener != null)
                    easySliderListener.onItemClick(position);
            }
        });
        return fragment;
    }

    @Override
    public int getCount() {
        return sliderItems.size();
    }
}

