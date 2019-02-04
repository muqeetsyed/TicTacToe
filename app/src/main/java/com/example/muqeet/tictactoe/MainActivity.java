package com.example.muqeet.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    GridView gridView;

    int[][] Array =
            {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {1, 4, 7},
                    {2, 5, 8},
                    {3, 6, 9},
                    {1, 5, 9},
                    {3, 5, 7}
            };

    int X[] = {0,0,0,0,0,0,0,0,0};
    int  Y[] = {0,0,0,0,0,0,0,0,0};
    int count=0,i=0,j=0,a=0,flag=0,black=0;
    int p = 0;
    int q = 0;
    int r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid);

        final GridAdaptter gridAdaptter = new GridAdaptter(MainActivity.this);
        gridView.setAdapter(gridAdaptter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9)
                {
                    view.setBackgroundResource(R.drawable.capture2);
                    X[i] = position + 1;
                    Log.d("x mark ", "" + X[i]);
                    Log.d("flag mark ", "" + flag);

                    if (i >= 2)
                    {
                        if (flag == 0) {
                            p = X[0];
                            q = X[1];
                            r = X[2];
                            Log.d("Check 1", " " + X[0] + X[1] + X[2]);
                            black = callmeX(p, q, r, black);
                        }
                        if (black == 0 && Y[3] != 0) {
                            p = X[1];
                            q = X[2];
                            r = X[3];
                            Log.d("Check 2-0", " " + X[1] + X[2] + X[3]);
                            black = callmeX(p, q, r, black);

                            p = X[2];
                            q = X[3];
                            r = X[0];
                            Log.d("Check 2-1", " " + X[2] + X[3] + X[0]);
                            black = callmeX(p, q, r, black);

                            p = X[3];
                            q = X[0];
                            r = X[1];
                            Log.d("Check 2-2", " " + X[3] + X[0] + X[1]);
                            black = callmeX(p, q, r, black);
                        }
                    }
                    i++;
                } else {
                    if (count == 0 || count == 2 || count == 4 || count == 6 || count == 8) {

                        view.setBackgroundResource(R.drawable.capture1);

                        Y[j] = position + 1;
                        Log.d("y mark ", "" + Y[i]);
                        Log.d("black mark ", "" + black);

                        if (j >= 2) {
                            if (black == 0) {
                                p = Y[0];
                                q = Y[1];
                                r = Y[2];
                                black = callmeY(p, q, r, black);
                            }
                            if (black == 0 && Y[3] != 0 && Y[4] == 0) {
                                p = Y[0];
                                q = Y[1];
                                r = Y[2];
                                black = callmeY(p, q, r, black);

                                p = Y[0];
                                q = Y[1];
                                r = Y[3];
                                black = callmeY(p, q, r, black);

                                p = Y[0];
                                q = Y[2];
                                r = Y[3];
                                black = callmeY(p, q, r, black);

                                p = Y[1];
                                q = Y[2];
                                r = Y[3];
                                black = callmeY(p, q, r, black);
                            }
                            if (black == 0 && Y[3] != 0 && Y[4] != 0) {
                                p = Y[0];
                                q = Y[1];
                                r = Y[2];
                                black = callmeY(p, q, r, black);

                                p = Y[0];
                                q = Y[1];
                                r = Y[3];
                                black = callmeY(p, q, r, black);

                                p = Y[0];
                                q = Y[1];
                                r = Y[4];
                                black = callmeY(p, q, r, black);

                                p = Y[0];
                                q = Y[2];
                                r = Y[3];
                                black = callmeY(p, q, r, black);


                                p = Y[0];
                                q = Y[2];
                                r = Y[4];
                                black = callmeY(p, q, r, black);

                                p = Y[0];
                                q = Y[3];
                                r = Y[4];
                                black = callmeY(p, q, r, black);

                                p = Y[1];
                                q = Y[2];
                                r = Y[3];
                                black = callmeY(p, q, r, black);

                                p = Y[1];
                                q = Y[2];
                                r = Y[4];
                                black = callmeY(p, q, r, black);

                                p = Y[1];
                                q = Y[3];
                                r = Y[4];
                                black = callmeY(p, q, r, black);

                                p = Y[2];
                                q = Y[3];
                                r = Y[4];
                                black = callmeY(p, q, r, black);

                            }
                        }
                        j++;
                    }
                }
                count++;
            }
        });

    }

    public int callmeX(int a,int b, int c,int flag)
    {
        for (int m = 0; m <= 7; m++)
        {
            if (a == Array[m][0] && b == Array[m][1] && c == Array[m][2] || a == Array[m][0] && c == Array[m][1] && b == Array[m][2]
                    || c == Array[m][0] && a == Array[m][1] && b == Array[m][2] || c == Array[m][0] && b == Array[m][1] && a == Array[m][2]
                    || b == Array[m][0] && a == Array[m][1] && c == Array[m][2] || b == Array[m][0] && c == Array[m][1] && a == Array[m][2])
            {
                Win(" Zero Mark wins!");
                return 1;
            }
        }
        return 0;
    }

    public int callmeY(int p,int q, int r,int flag)
    {
        Log.d("call me y ",p+" "+q+" "+r+" "+flag);
        for (int m = 0; m <= 7; m++)
        {
            if (p == Array[m][0] && q == Array[m][1] && r == Array[m][2] || p == Array[m][0] && r == Array[m][1] && q == Array[m][2]
                    || q == Array[m][0] && p == Array[m][1] && r == Array[m][2] || q == Array[m][0] && r == Array[m][1] && p == Array[m][2]
                    || r == Array[m][0] && p == Array[m][1] && q == Array[m][2] || r == Array[m][0] && q == Array[m][1] && p == Array[m][2])
            {
                Win(" Cross Mark wins!");
                return 1;
            }
            Log.d("count",Array[m][0]+" "+Array[m][1]+" "+Array[m][2]+" "+m);

        }
        return 0;
    }

    public void Win(String a)
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.toast_layout_root));

        final Toast toast = new Toast(getApplicationContext());

        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.drawable.images);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(a);
        text.setTextSize(15);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);


        new CountDownTimer(300, 100)
        {
            public void onTick(long millisUntilFinished) {
                toast.show();
            }
            public void onFinish()
            {
                toast.show();
                recreate();
            }

        }.start();

    }

    public void refresh(View view)
    {
        recreate();
    }
}




