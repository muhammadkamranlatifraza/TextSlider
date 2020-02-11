package com.kamran.textsliderdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import kamran.textslider.EasySlider;
import kamran.textslider.EasySliderListener;
import kamran.textslider.SliderItem;

public class MainActivity extends AppCompatActivity {

    private EasySlider easySlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easySlider = findViewById(R.id.slider);
        easySlider.setOnItemClickListener(new EasySliderListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "this is position" + position, Toast.LENGTH_SHORT).show();
            }
        });

        SliderItem item = new SliderItem("", 0);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("Text/Banner Slider, fully customizable", 40, false));
        sliderItems.add(new SliderItem("Text/Imsge, Text only or image only, text size editable", 30, false));
        sliderItems.add(new SliderItem("<p>This is<sub> HTML Formatted</sub> and <sup>TEXT</sup> used in title</p>", 15, true));
        sliderItems.add(new SliderItem("Image from url or resources folder", 20, R.drawable.ic_launcher_foreground));
        sliderItems.add(new SliderItem("AndroidX library ready to use", 40));
        sliderItems.add(new SliderItem("Customizable Click on each banner", -1));
        easySlider.setPages(sliderItems);
    }
}