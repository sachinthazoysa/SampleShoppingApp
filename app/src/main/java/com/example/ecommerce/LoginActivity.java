package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.Model.Users;
import com.example.ecommerce.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {
    private EditText InputPhoneNumber,InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private CheckBox chkBoxRememberMe;
    private TextView AdminLink,NotAdminLink;

    private String parentDbName="Users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       InputPassword =(EditText)findViewById(R.id.login_password_input);
        InputPhoneNumber=(EditText)findViewById(R.id.login_phone_number_input);
        LoginButton=(Button)findViewById(R.id.login_btn);
        loadingBar=new ProgressDialog(this);
        chkBoxRememberMe=(CheckBox)findViewById(R.id.remember_me_chkb);
        AdminLink=(TextView)findViewById(R.id.admin_panel_lnik);
        NotAdminLink=(TextView)findViewById(R.id.not_admin_panel_lnik);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";
            }
        });
        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }



    private void LoginUser() {
        String phone=InputPhoneNumber.getText().toString();
        String password=InputPassword.getText().toString();

        if(TextUtils.isEmpty(phone)){
            Toast.makeText(this,"Please fill the Phone field",Toast.LENGTH_SHORT).show();
        } else if(TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill the Password field", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait,we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount(phone,password);

        }
    }

    private void AllowAccessToAccount(final String phone,final String password) {
        if(chkBoxRememberMe.isChecked()){
            Paper.book().write(Prevalent.UserPhoneKey, phone);
            Paper.book().write(Prevalent.UserPasswordKey, password);

        }
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDbName).child(phone).exists())
                {
                    Users userData=dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);
                    if(userData.getPhone().equals(phone)){
                        if(userData.getPassword().equals(password)){
                           if(parentDbName.equals("Admins")){
                               Toast.makeText(LoginActivity.this,"Welcome admin, Login successful", Toast.LENGTH_SHORT).show();
                               loadingBar.dismiss();
                               Intent intent = new Intent(LoginActivity.this,AdminAddNewProductActivity.class);
                               startActivity(intent);
                           }
                           else if(parentDbName.equals("Users"))
                           {
                               Toast.makeText(LoginActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                               loadingBar.dismiss();
                               Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                               startActivity(intent);
                           }
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Password is incorrect",Toast.LENGTH_LONG).show();
                            loadingBar.dismiss();
                        }
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Account with this "+phone+" number does not exist",Toast.LENGTH_LONG).show();
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this,"You need to create an account",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
