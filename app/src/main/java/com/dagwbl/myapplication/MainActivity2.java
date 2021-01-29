package com.dagwbl.myapplication;
/*
手动计数器
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button ButtonAdd;
    private TextView count;
    public int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButtonAdd=(Button) findViewById(R.id.btnAdd);
        count=(TextView) findViewById(R.id.tvCount);


        ButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                i=i+1;
                count.setText(String.valueOf(i));
//            Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
//            startActivity(intent);

            }
        });


    }
}