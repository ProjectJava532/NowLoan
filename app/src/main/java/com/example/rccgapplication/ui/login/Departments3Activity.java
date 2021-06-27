package com.example.rccgapplication.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rccgapplication.R;

//Nullable annotation indicates a variable,parameter or return value that can be null

public class Departments3Activity extends AppCompatActivity
{
    //private class LoginViewModel
    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //Super keyword create Content
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments_3);

    }
}