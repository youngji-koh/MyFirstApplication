package com.example.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "default";
    public static Integer count = 0;
    public static Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button2);
        count = 0;
        button.setText(count.toString());
    }

    public void increaseNum(View view){
        count++;
        button.setText(count.toString());
    }

    public void resetCounter(View view){
        count = 0;
        button.setText(count.toString());

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();

        if(message.isEmpty()){
            toastMe(view);
        } else {
            intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
        }
    }

    public void toastMe(View view){
        Toast myToast = Toast.makeText(this, "There is no message", Toast.LENGTH_SHORT);
        myToast.show();
    }


}
