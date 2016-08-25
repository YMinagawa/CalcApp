package jp.techacademy.yoshihiro.minagawa.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    double x;
    double y;
    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText)findViewById(R.id.editText1);
        mEditText1.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);
        mEditText2 = (EditText)findViewById(R.id.editText2);
        mEditText2.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);

        //1:+, 2:-, 3:x, 4:÷
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        int numOperator = 0;
        if(v.getId() == R.id.button1){
            numOperator = 1;
        }else if(v.getId() == R.id.button2){
            numOperator = 2;
        }else if(v.getId() == R.id.button3) {
            numOperator = 3;
        }else if(v.getId() == R.id.button4) {
            numOperator = 4;
        }

        //from String to Double
        try {
            x = Double.parseDouble(mEditText1.getText().toString());
            y = Double.parseDouble(mEditText2.getText().toString());
        }catch(NumberFormatException e){
            Toast.makeText(this, "Please enter number !!", Toast.LENGTH_SHORT).show();
            return;
        }


        Log.d("test", "x = " + x);
        Log.d("test", "y = " + y);
        double xy = x+y;
        Log.d("test", "x + y = " + xy);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", x);
        intent.putExtra("VALUE2", y);
        intent.putExtra("OPERATOR", numOperator);
        startActivity(intent);


    }
}
