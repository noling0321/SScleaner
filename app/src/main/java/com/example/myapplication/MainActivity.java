package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = (TextView)findViewById(R.id.text0);
        final TextView text2 = (TextView)findViewById(R.id.text1);
        final TextView text3 = (TextView)findViewById(R.id.text2);
        final TextView text4 = (TextView)findViewById(R.id.text3);
        final Button btn1 = (Button)findViewById(R.id.button);
        btn1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                try {
                    btn1.setEnabled(false);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            text.setText("1");
                            text2.setText("2");
                            text3.setText("3");
                            text4.setText("4");
                            final ArrayList li = new ArrayList();
                            Random rd = new Random();
                            final int temp[] = new int[4];
                            int ok = 0;
                            li.add(0,"강현구");
                            li.add(1,"권태호");
                            li.add(2,"김민후");
                            li.add(3,"김현");
                            li.add(4,"김현승");
                            li.add(5,"박찬휘");
                            li.add(6,"송재원");
                            li.add(7,"임준영");
                            li.add(8,"장순우");
                            li.add(9,"장인성");
                            li.add(10,"정희수");

                            while(true) {
                                for(int i = 0; i < 4; i++) {
                                    temp[i] = rd.nextInt(li.size());
                                }
                                ok = 0;
                                for(int i = 0; i< 4; i++) {
                                    for(int j = 0; j < 4; j++) {
                                        if(temp[i] != temp[j] && i != j) {
                                            ok++;
                                        }
                                    }
                                }

                                if(ok == 12) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            new Handler().postDelayed(new Runnable()
                                            {
                                                @Override
                                                public void run()
                                                {
                                                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.pling);
                                                    mediaPlayer.start();
                                                    text.setText(""+li.get(temp[0]));
                                                }
                                            }, 1000);
                                            new Handler().postDelayed(new Runnable()
                                            {
                                                @Override
                                                public void run()
                                                {
                                                    mediaPlayer.start();
                                                    text2.setText(""+li.get(temp[1]));
                                                }
                                            }, 2000);
                                            new Handler().postDelayed(new Runnable()
                                            {
                                                @Override
                                                public void run()
                                                {
                                                    mediaPlayer.start();
                                                    text3.setText(""+li.get(temp[2]));
                                                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.dugu);
                                                    mediaPlayer.start();
                                                }
                                            }, 3000);
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    text4.setText(""+li.get(temp[3]));
                                                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.tada);
                                                    mediaPlayer.start();
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            btn1.setEnabled(true);
                                                        }
                                                    });
                                                }
                                            }, 7900);
                                        }
                                    });
                                    break;
                                }
                            }
                        }
                    }).start();

                }
                catch (Exception Ex)
                {
                    Ex.printStackTrace();
                    btn1.setEnabled(true);
                }

            }
        });
    }
}
