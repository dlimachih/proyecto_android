package com.example.david.probaresto;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Restaurante_Hilton extends AppCompatActivity {
    List<Book> istBook;

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[]dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante__hilton);
        istBook=new ArrayList<>();
        istBook.add(new Book("Chococcino","Categorie Book","Description book",R.drawable.chococcino));
        istBook.add(new Book("Ceviche Californiano","Categorie Book","Description book",R.drawable.cevivhe_californiano));
        istBook.add(new Book("Crab cake","Categorie Book","Description book",R.drawable.crabcake));
        istBook.add(new Book("Bife ancho americano","Categorie Book","Description book",R.drawable.bife));
        istBook.add(new Book("Salmón","Categorie Book","Description book",R.drawable.salmon_cocido));
        istBook.add(new Book("Cheescake","Categorie Book","Description book",R.drawable.cheescake));
        istBook.add(new Book("Brownie con pecanas","Categorie Book","Description book",R.drawable.brownie_conpecanas));
        istBook.add(new Book("Chococcino","Categorie Book","Description book",R.drawable.chococcino));
        istBook.add(new Book("Ceviche Californiano","Categorie Book","Description book",R.drawable.cevivhe_californiano));
        istBook.add(new Book("Crab cake","Categorie Book","Description book",R.drawable.crabcake));
        istBook.add(new Book("Bife ancho americano","Categorie Book","Description book",R.drawable.bife));
        istBook.add(new Book("Salmón","Categorie Book","Description book",R.drawable.salmon_cocido));
        istBook.add(new Book("Cheescake","Categorie Book","Description book",R.drawable.cheescake));
        istBook.add(new Book("Brownie con pecanas","Categorie Book","Description book",R.drawable.brownie_conpecanas));

        RecyclerView myrv=(RecyclerView)findViewById(R.id.recyclerview_id);
        RecycleViewAdapter myAdapter=new RecycleViewAdapter(this,istBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


        //
      viewPager=(ViewPager)findViewById(R.id.viewPager);
        sliderDotspanel=(LinearLayout)findViewById(R.id.SliderDota);

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount=viewPagerAdapter.getCount();
        dots=new ImageView[dotscount];

        for (int i=0;i<dotscount;i++){
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotspanel.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<dotscount;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),200,4000);
    }
   public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            Restaurante_Hilton.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }else if (viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }else if (viewPager.getCurrentItem()==3){
                        viewPager.setCurrentItem(4);
                    }else if (viewPager.getCurrentItem()==4){
                        viewPager.setCurrentItem(5);
                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}
