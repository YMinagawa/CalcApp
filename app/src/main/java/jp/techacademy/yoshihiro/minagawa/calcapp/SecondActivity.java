package jp.techacademy.yoshihiro.minagawa.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        int numOperator = intent.getIntExtra("OPERATOR", 0);

        Log.d("test", "value1 = " + value1);
        Log.d("test", "value2 = " + value2);
        Log.d("test", "numOperator = " + numOperator);

        TextView textView = (TextView)findViewById(R.id.textView);

        if(numOperator == 1){
            textView.setText(String.valueOf(value1 + value2));
        }else if(numOperator==2){
            textView.setText(String.valueOf(value1 - value2));
        }else if(numOperator==3){
            textView.setText(String.valueOf(value1 * value2));
        }else if(numOperator==4){
            textView.setText(String.valueOf(value1 / value2));
        }

    }
}
