package com.woebbi.a20190806_002_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //LAyout für diese activity setzten
        setContentView(R.layout.activity_main);
    }
}
