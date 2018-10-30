package com.example.dev.devdaschatterjee_comp304_lab2_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class VegActivity extends AppCompatActivity {
    private String message,str;
    private Button enter,back,exit;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private EditText editText1,editText2,editText3,editText4,editText6;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg);
        //create buttons
        enter=findViewById(R.id.btnEnter);
        back=findViewById(R.id.btnBack);
        exit=findViewById(R.id.btnExit);

        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);

        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText6=findViewById(R.id.editText6);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            message=extras.getString("RADIO_CHOSEN");
            Toast.makeText(this,"You selected "+message+" ",Toast.LENGTH_LONG).show();
        }
        switch(message){
            case "Vegetables/Legumes/Beans":
                checkBox1.setText("Mixed Vegetable");
                editText1.setText("2");
                checkBox2.setText("Baked Potato");
                editText2.setText("4");
                checkBox3.setText("Russian Salad");
                editText3.setText("6");
                checkBox4.setText("Pork in Mix Bean");
                editText4.setText("8");
                break;
            case "Fruit":
                checkBox1.setText("Pineapple");
                checkBox2.setText("Mango");
                checkBox3.setText("Strawberry");
                checkBox4.setText("Apple");
                editText1.setText("5");
                editText2.setText("10");
                editText3.setText("15");
                editText4.setText("20");
                break;
            case "Grain (Creeal) foods":
                checkBox1.setText("Cheerios");
                checkBox2.setText("Granola");
                checkBox3.setText("Quinoa");
                checkBox4.setText("Oatmeal");
                editText1.setText("3");
                editText2.setText("5");
                editText3.setText("8");
                editText4.setText("10");
                break;
            case "Lean meats and poultry, fish, eggs, tofu, nuts and seeds and legumes/beans":
                checkBox1.setText("Salmon");
                checkBox2.setText("Vegetable Tofu");
                checkBox3.setText("Beef stew with bean");
                checkBox4.setText("Egg toast");
                editText1.setText("4");
                editText2.setText("6");
                editText3.setText("8");
                editText4.setText("10");
                break;
            case "Milk, yogurt cheese and/or alternatives ":
                checkBox1.setText("Vanila yogurt");
                checkBox2.setText("icecream");
                checkBox3.setText("Apple pie");
                checkBox4.setText("Coconut yogurt");
                editText1.setText("2");
                editText2.setText("4");
                editText3.setText("6");
                editText4.setText("8");
                break;

        }

    }
    public void countTotal(){
        if(checkBox1.isChecked()){
            total+=(int)parseInt(editText1.getText().toString());
        }
        if(checkBox2.isChecked()){
            total+=(int)parseInt(editText2.getText().toString());
        }
        if(checkBox3.isChecked()){
            total+=(int)parseInt(editText3.getText().toString());
        }
        if (checkBox4.isChecked()){
            total+=(int)parseInt(editText4.getText().toString());
        }
        Toast.makeText(this,String.valueOf(total),Toast.LENGTH_LONG).show();
    }
     public void onEnterClicked(View v){
        str="";//,str2="",str3="",str4="";
       Intent i=new Intent(this,CheckoutActivity.class);
        total=0;
         switch(message){
             case "Vegetables/Legumes/Beans":
                 countTotal();
                 str=String.valueOf(total);
                 i.putExtra("cost",str);
                 startActivity(i);
                break;
             case "Fruit":
                 countTotal();
                 str=String.valueOf(total);
                 i.putExtra("cost",str);
                 startActivity(i);
                 break;
             case "Grain (Creeal) foods":
                 countTotal();
                 str=String.valueOf(total);
                 i.putExtra("cost",str);
                 startActivity(i);
                 break;
             case "Lean meats and poultry, fish, eggs, tofu, nuts and seeds and legumes/beans":
                 countTotal();
                 str=String.valueOf(total);
                 i.putExtra("cost",str);
                 startActivity(i);
                 break;
             case "Milk, yogurt cheese and/or alternatives ":
                 countTotal();
                 str=String.valueOf(total);
                 i.putExtra("cost",str);
                 startActivity(i);
                 break;
         }
    }
    public void onBackClicked(View v){super.onBackPressed();
    }
    public void onExitClicked(View v){finish(); System.exit(0);
    }
}
