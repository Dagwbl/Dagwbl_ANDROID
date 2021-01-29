package com.dagwbl.myapplication;
/*
随机数生成
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    private Button button;
    private EditText minNumber;
    private EditText maxNumber;
    private TextView randomNumber;
    private android.content.Context Context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button = (Button) findViewById(R.id.generate_button);
        minNumber = (EditText) findViewById(R.id.editTextNumber_min);
        maxNumber = (EditText) findViewById(R.id.editTextNumber_max);
        randomNumber = (TextView) findViewById(R.id.editTextNumber_result);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /*               context = getApplicationContext();*/
                Random random = new Random();
                String min_str=minNumber.getText().toString();
                if(
                        TextUtils.isEmpty(minNumber.getText().toString()) ||
                        TextUtils.isEmpty(maxNumber.getText().toString())||
                        Integer.parseInt(minNumber.getText().toString())>Integer.parseInt(maxNumber.getText().toString())) {
                        Toast.makeText(MainActivity3.this,"请确认边界条件!",Toast.LENGTH_LONG).show();
                }else {

                    int a = Integer.parseInt(minNumber.getText().toString());
                    int b = Integer.parseInt(maxNumber.getText().toString());

                    try {
                        int rn = random.nextInt(b)%(b-a+1)+a;
                        randomNumber.setText(String.valueOf(rn));
                    }catch(ArithmeticException e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity3.this,"请确认边界条件!",Toast.LENGTH_LONG).show();
                    }finally{

                    }



                }}
        });


    }
}