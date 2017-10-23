package com.charfouni.karim.vacancemaroc;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Integer> images;
    private LinearLayout sliderDotsPanel;
    private int dotsCount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView hotelName=(TextView)findViewById(R.id.tvName);
        TextView hotelDescription=(TextView)findViewById(R.id.tvDescription);
        TextView hotelAddress=(TextView)findViewById(R.id.tvAddress);

        images=new ArrayList<>();
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            hotelName.setText(bundle.getString("hotelName"));
            hotelDescription.setText(bundle.getString("hotelDescription"));
            hotelAddress.setText(bundle.getString("hoteladdress"));

          //  images=bundle.getIntegerArrayList("test");

        }
        images=(ArrayList<Integer>) getIntent().getSerializableExtra("images");
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        sliderDotsPanel=(LinearLayout)findViewById(R.id.sliderDots);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this,images);
        viewPager.setAdapter(viewPagerAdapter);
        dotsCount=viewPagerAdapter.getCount();
        dots=new ImageView[dotsCount];
        for(int i=0;i<dotsCount;i++){
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotsPanel.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
