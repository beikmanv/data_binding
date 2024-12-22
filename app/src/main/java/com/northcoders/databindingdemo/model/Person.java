package com.northcoders.databindingdemo.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.databinding.BR;

public class Person extends BaseObservable {
    String Name;
    int Age;
    String email;

    public Person () {}

    public Person(String name, int age, String email) {
        Name = name;
        Age = age;
        this.email = email;
    }

    @Bindable
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
