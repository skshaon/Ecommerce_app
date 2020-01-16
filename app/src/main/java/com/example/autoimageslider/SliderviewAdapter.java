package com.example.autoimageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SliderviewAdapter extends PagerAdapter {



    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] image={R.drawable.slider1,R.drawable.slider2,R.drawable.slider3,
            R.drawable.slider4,R.drawable.slider5,R.drawable.img1,R.drawable.img2};


    public SliderviewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.image_slider_custom_layout,null);

        ImageView imageView = view.findViewById(R.id.imageviewslider_id);
        imageView.setImageResource(image[position]);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {



        ViewPager viewPager = (ViewPager) container;
        View view= (View) object;
        viewPager.removeView(view);
    }
}
