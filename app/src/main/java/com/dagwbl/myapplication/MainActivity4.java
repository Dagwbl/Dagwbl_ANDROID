package com.dagwbl.myapplication;
/*
大话骰
 */

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    private static final String TAG = "摇骰子";
    private Button shake;
    private Button openButton;
    private ImageView dice1;
    private ImageView dice2;
    private ImageView dice3;
    private ImageView dice4;
    private ImageView dice5;
    private MediaPlayer mediaPlayer=new MediaPlayer();
    private Boolean flag = true;
    String name = null;

//    private MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.shake_dice_sound);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        shake = (Button) findViewById(R.id.shakeDice);
        openButton = (Button) findViewById(R.id.openButton);
        dice1 = (ImageView) findViewById(R.id.dice1);
        dice2 = (ImageView) findViewById(R.id.dice2);
        dice3 = (ImageView) findViewById(R.id.dice3);
        dice4 = (ImageView) findViewById(R.id.dice4);
        dice5 = (ImageView) findViewById(R.id.dice5);


        ArrayList dices=new ArrayList<>(5);


        shake.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                dice1.setImageResource(R.drawable.dice);
                dice2.setImageResource(R.drawable.dice);
                dice3.setImageResource(R.drawable.dice);
                dice4.setImageResource(R.drawable.dice);
                dice5.setImageResource(R.drawable.dice);
                Random random=new Random();
                dices.clear();
                for (int i=0;i<5;i++){
                    dices.add(random.nextInt(6)%(6)+1);
                }

                try {
                    mediaPlayer.reset();
                    AssetFileDescriptor fileDescriptor =getResources().openRawResourceFd(R.raw.shake_dice_sound);
                    mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
                    mediaPlayer.prepare();

                } catch (IOException e) {
                    e.printStackTrace();
                }catch (NullPointerException e1){
                    Toast.makeText(MainActivity4.this,"NullPointerException",Toast.LENGTH_SHORT).show();
                }catch (Exception ar){
                    Toast.makeText(MainActivity4.this,"不知道为啥，就是出错了",Toast.LENGTH_SHORT).show();
                }
                finally{
                    mediaPlayer.start();
                    Toast.makeText(MainActivity4.this,"骰子摇好了",Toast.LENGTH_SHORT).show();
                }

            }
        });

        openButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (flag==true){
                    try {
                        dice1.setImageResource(getId(dices.get(0).toString()));
                        dice2.setImageResource(getId(dices.get(1).toString()));
                        dice3.setImageResource(getId(dices.get(2).toString()));
                        dice4.setImageResource(getId(dices.get(3).toString()));
                        dice5.setImageResource(getId(dices.get(4).toString()));
                        openButton.setText("合");
                        flag = false;
                    }catch(Exception e2){
                        e2.printStackTrace();
                        Toast.makeText(MainActivity4.this,"还没开始摇骰子呢",Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "错误onClick: "+e2.toString());
                    }

            }else{
                    dice1.setImageResource(R.drawable.dice);
                    dice2.setImageResource(R.drawable.dice);
                    dice3.setImageResource(R.drawable.dice);
                    dice4.setImageResource(R.drawable.dice);
                    dice5.setImageResource(R.drawable.dice);
                    flag=true;
                    openButton.setText("起");
                }
            }
        });

    }
    public int getId(String value){

        switch (value){
            case "1":
                name = "dice1";
                break;
            case "2":
                name = "dice2";
                break;
            case "3":
                name = "dice3";
                break;
            case "4":
                name = "dice4";
                break;
            case "5":
                name = "dice5";
                break;
            case "6":
                name = "dice6";
                break;

        }
        Resources res=getResources();

        //return res.getIdentifier(name,null,null);//带上地址 例如 包:type/name           (org.anjoy.act:drawable/ic)

        return res.getIdentifier(name,"drawable",getPackageName());//名称例如 ic

    }

}