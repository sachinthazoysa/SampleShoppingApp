package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AdminAddNewProductActivity extends AppCompatActivity {

    private String categoryName;
    private Button AddNewProductButton;
    private EditText InputProductName, InputProductDescription,InputProductPrice;
    private ImageView InputProductImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        AddNewProductButton = (Button)findViewById(R.id.add_new_product);
        InputProductImage=(ImageView)findViewById(R.id.select_product_image);
        InputProductName=(EditText)findViewById(R.id.product_name);
        InputProductDescription=(EditText)findViewById(R.id.product_description);
        InputProductPrice=(EditText)findViewById(R.id.product_price);

        categoryName = getIntent().getExtras().get("category").toString();


    }

}
 