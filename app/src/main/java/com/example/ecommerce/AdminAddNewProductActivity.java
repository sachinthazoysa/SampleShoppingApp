package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class AdminAddNewProductActivity extends AppCompatActivity {

    private String categoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);
        Toast.makeText(this,"Welcome admin",Toast.LENGTH_LONG).show();

        categoryName = getIntent().getExtras().get("category").toString();

        Toast.makeText(this,categoryName,Toast.LENGTH_LONG).show();
    }

}
 