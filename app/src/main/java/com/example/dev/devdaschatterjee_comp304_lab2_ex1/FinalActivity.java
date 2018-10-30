package com.example.dev.devdaschatterjee_comp304_lab2_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    private TextView textView;
    private String cost,name,address,comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        textView=findViewById(R.id.textView);

        Bundle bundle=getIntent().getExtras();

        cost=bundle.getString("cost");
        name=bundle.getString("name");
        address=bundle.getString("address");
        comment=bundle.getString("comment");
        textView.setText("Thank You for your order!"+"\nName: "+name.toString()+"\nAddress: "+address.toString()+"\nComment: "+comment.toString());
    }
    public void onExitClicked(View v){finish(); System.exit(0);
    }
}
