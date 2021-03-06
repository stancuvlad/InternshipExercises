package com.example.internshipexercises;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private int incrementValue = 0;
    private TextView label_counter;
    private TextView counter_value;
    private Button incrementButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        initViews();

        label_counter.setText("Number of clicks");
        counter_value.setText(String.valueOf(incrementValue));
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementValue++;
                counter_value.setText(String.valueOf(incrementValue));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key", incrementValue);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        incrementValue = savedInstanceState.getInt("key");
        counter_value.setText(String.valueOf(incrementValue));
    }

    private void initViews(){
        label_counter = findViewById(R.id.label_counter);
        counter_value = findViewById(R.id.counter_value_tv);
        incrementButton = findViewById(R.id.incrementButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();//nu se apeleaza mereu
        Log.d(TAG,"onDestroy: BYE BYE");
    }
}
