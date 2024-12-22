package com.northcoders.databindingdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityMainBinding;
import com.northcoders.databindingdemo.model.Person;

public class MainActivity extends AppCompatActivity {

    // Automatically created data binding class
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Intitialise the activityMainBinding by setting it to the DataBindingUtil class
        activityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main
        );

        Person simon = new Person("Simon", "21", "simon@northcoders.co.uk");

        // Set the specific data object to be used - this can be dynamic
        activityMainBinding.setPerson(simon);

    }
}