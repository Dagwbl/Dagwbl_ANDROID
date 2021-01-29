package com.dagwbl.myapplication;
/*
大话骰
 */

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    private Button shake;
    private Button openButton;
    private TextView dice1;
    private TextView dice2;
    private TextView dice3;
    private TextView dice4;
    private TextView dice5;
    private MediaPlayer mediaPlayer=new MediaPlayer();
    private Boolean flag = true;
//    private MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.shake_dice_sound);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        shake = (Button) findViewById(R.id.shakeDice);
        openButton = (Button) findViewById(R.id.openButton);
        dice1 = (TextView) findViewById(R.id.dice1);
        dice2 = (TextView) findViewById(R.id.dice2);
        dice3 = (TextView) findViewById(R.id.dice3);
        dice4 = (TextView) findViewById(R.id.dice4);
        dice5 = (TextView) findViewById(R.id.dice5);

        ArrayList dices=new ArrayList<>(5);

        dice1.setBackgroundResource(R.drawable.corner_view1);
        dice2.setBackgroundResource(R.drawable.corner_view1);
        dice3.setBackgroundResource(R.drawable.corner_view);
        dice4.setBackgroundResource(R.drawable.corner_view);
        dice5.setBackgroundResource(R.drawable.corner_view);
//        AssetFileDescriptor fileDescriptor =getResources().openRawResourceFd(R.raw.shake_dice_sound);

        shake.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Random random=new Random();
                dices.clear();
                for (int i=0;i<5;i++){
                    dices.add(random.nextInt(6)%(6)+1);
                }
            dice1.setText("@");
            dice2.setText("@");
            dice3.setText("@");
            dice4.setText("@");
            dice5.setText("@");

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
                }

            }
        });

        openButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (flag==true){
                    try {
                        dice1.setText(dices.get(0).toString());
                        dice2.setText(dices.get(1).toString());
                        dice3.setText(dices.get(2).toString());
                        dice4.setText(dices.get(3).toString());
                        dice5.setText(dices.get(4).toString());
                        openButton.setText("合");
                        flag = false;
                    }catch(Exception e2){
                        Toast.makeText(MainActivity4.this,"还没开始摇骰子呢",Toast.LENGTH_SHORT).show();
                    }

            }else{
                    dice1.setText("@");
                    dice2.setText("@");
                    dice3.setText("@");
                    dice4.setText("@");
                    dice5.setText("@");
                    flag=true;
                    openButton.setText("起");
                }
            }
        });

    }

}