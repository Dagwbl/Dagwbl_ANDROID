package com.dagwbl.myapplication;
/*
主界面
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button func1;
    private Button func2;
    private Button func3;
    private Button func4;
    private Button func5;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){
            case R.id.menu_userLogin:
                intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_feedBack:
                //TODO
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/Dagwbl/Dagwbl_ANDROID/issues"));
                startActivity(intent);
                break;
            case R.id.menu_about:
                //TODO
//                intent = intent = new Intent(MainActivity.this,MainActivity4.class);
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://github.com/Dagwbl/Dagwbl_ANDROID"));
                    startActivity(intent);
                break;
            case R.id.menu_exit:
                //销毁活动
                finish();
                break;
        }

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        func1 = findViewById(R.id.func1);
        func2 = findViewById(R.id.func2);
        func3 = findViewById(R.id.func3);
//        func4 = findViewById(R.id.func4);
        func5 = findViewById(R.id.func5);

        OnClick onClick =new OnClick();
        func1.setOnClickListener(onClick);
        func2.setOnClickListener(onClick);
        func3.setOnClickListener(onClick);
//        func4.setOnClickListener(onClick);
        func5.setOnClickListener(onClick);

    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent targetIntent = null;
            switch (view.getId()){
                case R.id.func1:
                    targetIntent =new Intent(getApplicationContext(),MainActivity2.class);
                    break;
                case R.id.func2:
                    targetIntent =new Intent(getApplicationContext(),MainActivity3.class);
                    break;
                case R.id.func3:
                    targetIntent =new Intent(getApplicationContext(),MainActivity4.class);
                    break;
//                case R.id.func4:
//                    targetIntent =new Intent(getApplicationContext(),LoginActivity.class);
//                    break;
                case R.id.func5:
                    targetIntent =new Intent(getApplicationContext(),TimeScreenActivity.class);
                    break;
            }
            startActivity(targetIntent);
        }
    }
}