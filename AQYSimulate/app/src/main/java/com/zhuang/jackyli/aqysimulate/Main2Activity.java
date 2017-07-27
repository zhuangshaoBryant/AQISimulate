package com.zhuang.jackyli.aqysimulate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.line1);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view2 = LayoutInflater.from(Main2Activity.this).inflate(R.layout.base_type346_layout,layout,false);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,1);
                view2.setLayoutParams(params);
                layout.addView(view2);

                TextView leftTitle = (TextView) view2.findViewById(R.id.up_title);
                leftTitle.setText("庄少");
            }
        });




    }

}
