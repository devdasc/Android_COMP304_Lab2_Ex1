package com.example.dev.devdaschatterjee_comp304_lab2_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.logoView);
        enterButton=findViewById(R.id.btnEnter);


    }
    public  void on_btnEnter_Click(View v){
        Intent intent= new Intent(this,FoodActivity.class);
        startActivity(intent);

    }

}
