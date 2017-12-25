package com.example.auser.date1019;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView tv;
    CheckBox[] cb= new CheckBox[3];
    int sum=0;
    String str="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        tv = new TextView(this);
        for(int i=0; i<3; i++) {
            cb[i] = new CheckBox(this);
            cb[i].setText("Check " + i);
            cb[i].setId(i);
        }


        cb[0].setText("牛排 500元");
        cb[1].setText("漢堡 120元");
        cb[2].setText("氣水  50元");


        cb[0].setOnCheckedChangeListener(new SampleCheck());
        cb[1].setOnCheckedChangeListener(new SampleCheck());
        cb[2].setOnCheckedChangeListener(new SampleCheck());

        for(int i=0; i<3; i++)
            linearLayout.addView(cb[i]);
        linearLayout.addView(tv);
    }



    public class SampleCheck implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            str="";
            if (cb[0].isChecked()){
                sum+=500;
                str+=" 牛排 ";
            } else if (!cb[0].isChecked())
                sum-=500;
            if (cb[1].isChecked()){
                sum+=120;
                str+=" 漢堡 ";
            } else if (!cb[1].isChecked())
                sum-=120;
            if (cb[2].isChecked()){
                sum+=50;
                str+=" 汽水 ";
            } else if (!cb[2].isChecked())
                sum-=50;
            tv.setText("您買了:"+str+"\n共計:"+sum);

        }
    }

}



