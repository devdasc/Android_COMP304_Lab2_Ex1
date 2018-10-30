package com.example.dev.devdaschatterjee_comp304_lab2_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {
    private EditText editText1, editTextName,editTextNumber,editTextAddress,editTextComment;
    private RadioButton rCredit,rDebit;
    private  String total, message;
    private int count=0;
    private boolean valid=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        editText1=findViewById(R.id.editText1);
        editTextName=findViewById(R.id.editTextName);
        editTextNumber=findViewById(R.id.editTextNumber);
        editTextAddress=findViewById(R.id.editTextAdress);
        editTextComment=findViewById(R.id.editTextComment);

        rCredit=findViewById(R.id.radioCredit);
        rDebit=findViewById(R.id.radioDebit);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            total=extras.getString("cost");
            Toast.makeText(this,total.toString(),Toast.LENGTH_LONG).show();
            editText1.setText("Total amount: $ "+total+".00");
        }
    }
     public void onEnterClicked(View v){

        if(rCredit.isChecked()){
            getValidation();
            if(valid){
                createIntent();
            }
        }else if(rDebit.isChecked()){
                getValidation();
                if(valid){
                   createIntent();
                }
        }else{
            Toast.makeText(this,"Either Credit or Debit must be selected",Toast.LENGTH_LONG).show();
        }
    }
    public void createIntent(){
        Intent i=new Intent(this,FinalActivity.class);
        i.putExtra("cost",editText1.getText().toString());
        i.putExtra("name",editTextName.getText().toString());
        i.putExtra("address",editTextAddress.getText().toString());
        i.putExtra("comment",editTextComment.getText().toString());
        startActivity(i);
    }
    public boolean getValidation(){
        valid=true;
        if(editTextName.getText().toString().isEmpty()){
            editTextName.setError("Name is required !");
            valid=false;
        }
        if(editTextNumber.getText().toString().isEmpty()|| editTextNumber.getText().toString().length()<=15){
            editTextNumber.setError("Card number is required");
            valid=false;
        }
        if(editTextAddress.getText().toString().isEmpty()){
            editTextAddress.setError("Address is required !");
            valid=false;
        }
        if(editTextComment.getText().toString().isEmpty()){
            editTextComment.setError("Please Leave a comment !");
            valid=false;
        }
        return valid;
    }
    public void onBackClicked(View v){super.onBackPressed();
    }
    public void onExitClicked(View v){finish(); System.exit(0);
    }
}
