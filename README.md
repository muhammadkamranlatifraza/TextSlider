# TextSlider
An Extension of EasySlider Made by Ahmed

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.muhammadkamranlatifraza:TextSlider:Tag'
	}
  
  Featues:
  
  use simple/HTML formatted Text or image or both in slider.
  
  can give custom size of title
  
  can set custom bg for dots and/or titles
  
  
  Example use like this
  
      // XML
      <kamran.textslider.EasySlider
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:id="@+id/slider"/>
        
                easySlider = findViewById(R.id.slider);
        easySlider.setOnItemClickListener(new EasySliderListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "this is position" + position, Toast.LENGTH_SHORT).show();
            }
        });

        easySlider.setDotsBackground(R.drawable.rounded);
	//        easySlider.showDots();
	//        easySlider.hideDots();
        
        SliderItem item = new SliderItem("this will have custom bg in title", 30);
        item.setTitleBgResID(R.drawable.rounded);
        item.setTitle("Title");
        item.setTitleColor("#636161");
        item.setUrl("ImageURL");
        item.setResID(R.drawable.ic_launcher_foreground);
        item.setTextSize(40);

        List<SliderItem> sliderItems = new ArrayList<>();
	//        sliderItems.add(new SliderItem("Text/Banner Slider, fully customizable", 40, false));
	//        sliderItems.add(new SliderItem("Text/Imsge, Text only or image only, text size editable", 30, false));
	//        sliderItems.add(new SliderItem("<p>This is<sub> HTML Formatted</sub> and <sup>TEXT</sup></p>", 15, true));
	//        sliderItems.add(new SliderItem("Image from url or resources folder", 20, R.drawable.ic_launcher_foreground));
	//        sliderItems.add(new SliderItem("AndroidX library ready to use", 40));
        sliderItems.add(item);
        easySlider.setPages(sliderItems);

Idea and Help taken from https://github.com/ahmedshaban1/EasySlider
