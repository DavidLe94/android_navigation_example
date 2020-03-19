package com.navigation.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private DataTest dataTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataTest = new DataTest();
        dataTest.setId(1);
        dataTest.setValue("Hello frag second");
    }

    public DataTest getDataTest() {
        return dataTest;
    }
}
