package com.example.dev.devdaschatterjee_comp304_lab2_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {
    private RadioButton rbVeg,rbFruit, rbGrain,rbMeat,rbMilk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        rbVeg=findViewById(R.id.rbVeg);
        rbFruit=findViewById(R.id.rbFruit);
        rbGrain=findViewById(R.id.rbCereal);
        rbMeat=findViewById(R.id.rbMeat);
        rbMilk=findViewById(R.id.rbMilk);
    }
    public void createIntent(){
        Intent intent=new Intent(this,VegActivity.class);
        intent.putExtra("RADIO_CHOSEN",rbVeg.getText().toString());
        startActivity(intent);
    }
    public void onEnterClicked(View v){
        if(rbVeg.isChecked()){
            createIntent();
        }else if(rbFruit.isChecked()){
            createIntent();
        }else if(rbGrain.isChecked()){
            createIntent();
        }else if(rbMeat.isChecked()){
            createIntent();
        }else if(rbMilk.isChecked()){
            createIntent();
        }
    }
   /* public void onEnterClicked(View v){

    }*/
    public void onBackClicked(View v){super.onBackPressed();
    }
    public void onExitClicked(View v){finish(); System.exit(0);
    }
}
