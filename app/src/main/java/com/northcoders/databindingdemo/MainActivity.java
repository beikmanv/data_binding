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
import com.northcoders.databindingdemo.adapter.PersonAdapter;
import com.northcoders.databindingdemo.model.Person;

import java.util.ArrayList;
import java.util.List;

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

        // Create a list of Person objects
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John Doe", 30, "john.doe@example.com"));
        personList.add(new Person("Jane Smith", 25, "jane.smith@example.com"));
        personList.add(new Person("Mike Johnson", 35, "mike.johnson@example.com"));
        personList.add(new Person("Emily Davis", 28, "emily.davis@example.com"));
        personList.add(new Person("Chris Brown", 40, "chris.brown@example.com"));

        // Set up the adapter
        PersonAdapter adapter = new PersonAdapter(this, personList);

        // Bind the adapter to the ListView
        activityMainBinding.personListView.setAdapter(adapter);

    }
}