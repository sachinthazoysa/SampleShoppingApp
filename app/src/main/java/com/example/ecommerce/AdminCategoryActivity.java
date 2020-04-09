package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {
    private ImageView tShirts,sportsTshirts,femaleDresses,sweathers;
    private ImageView glasses,hatsCaps,walletsBagsPurses,shoes;
    private ImageView headPhonesHandFree,Laptops,watches,mobilePhones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);
        tShirts=(ImageView)findViewById(R.id.t_shirts);
        sportsTshirts=(ImageView)findViewById(R.id.sports_t_shirts);
        femaleDresses=(ImageView)findViewById(R.id.female_dresses);
        sweathers=(ImageView)findViewById(R.id.sweather);

        glasses=(ImageView)findViewById(R.id.glasses);
        hatsCaps=(ImageView)findViewById(R.id.hats_caps);
        walletsBagsPurses=(ImageView)findViewById(R.id.purses_bags_wallets);
        shoes=(ImageView)findViewById(R.id.shoes);

        headPhonesHandFree=(ImageView)findViewById(R.id.headphones_handfree);
        Laptops=(ImageView)findViewById(R.id.laptop_pc);
        watches=(ImageView)findViewById(R.id.watches);
        mobilePhones=(ImageView)findViewById(R.id.mobilesphones);


                 tShirts.setOnClickListener(new View.OnClickListener() {
                    @Override
                         public void onClick(View v) {
                        Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                        intent.putExtra("category", "tShirts");
                        startActivity(intent);
                    }
                    });


                sportsTshirts.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","sports Tshirts");
                        startActivity(intent);
                    }
                });

                femaleDresses.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","female Dresses");
                        startActivity(intent);
                    }
                });
                sweathers.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","sweathers");
                        startActivity(intent);
                    }
                });


                glasses.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","glasses");
                        startActivity(intent);
                    }
                });

                hatsCaps.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","Hats Caps");
                        startActivity(intent);
                    }
                });

                glasses.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","glasses");
                        startActivity(intent);
                    }
                });

                walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","Wallets Bags Purses");
                        startActivity(intent);
                    }
                });

                shoes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","shoes");
                        startActivity(intent);
                    }
                });

                Laptops.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","Laptops");
                        startActivity(intent);
                    }
                });

                watches.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","Watches");
                        startActivity(intent);
                    }
                });

                mobilePhones.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                        intent.putExtra("category","Mobile Phones");
                        startActivity(intent);
                    }
                });

            }

}
