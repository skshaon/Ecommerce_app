package com.example.autoimageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    ////for the tablayout with fragment
    private TabLayout tabLayout;
    private ViewPager viewPager;

    ///slider
    private SliderView sliderView;

    //horizontallistview
    private RecyclerView recyclerView;

    ////bottomnevigation
    private BottomNavigationView bottomNavigationView;

    HorizontalListAdapter myAdapter;
    int [] image = {

            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,
            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,
            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,
            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,
            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,
            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,
            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,
            R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,R.drawable.slider2,


    };

    String [] title,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sliderView=findViewById(R.id.imageSlider_id);

        ///tablayout task with bottom one method
        tabLayout=findViewById(R.id.tablayout_id);
        viewPager=findViewById(R.id.viewpagerz_id);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        bottomNavigationView=findViewById(R.id.bottom_nevigation_id);

        SliderviewAdapter sliderviewAdapter=new SliderviewAdapter(this);

        sliderView.setSliderAdapter(sliderviewAdapter);


        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(4);


        title= getResources().getStringArray(R.array.title);


        initRecyclerView();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())

                {
                    case R.id.dashboard_nav_id:
                        Toast.makeText(getApplicationContext(),"selected Dashboard",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.favourate_nav_id:
                        Toast.makeText(getApplicationContext(),"selected Favourite",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.recent_nav_id:
                        Toast.makeText(getApplicationContext(),"selected Recent",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.home_nav_id:
                        Toast.makeText(getApplicationContext(),"selected Home",Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });




    }


    private void initRecyclerView() {

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView=findViewById(R.id.recyclerviewid);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter=new HorizontalListAdapter(this,title,image);
        recyclerView.setAdapter(myAdapter);
    }





    //////tablayout method for viewpager use
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addfragment(new CatagoryFragment(),"Catagory");
        viewPagerAdapter.addfragment(new BrandFragment(),"Brand");
        viewPagerAdapter.addfragment(new ShopFragment(),"Shop");
        viewPager.setAdapter(viewPagerAdapter);

    }

}
