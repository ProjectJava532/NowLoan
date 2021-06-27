package com.example.rccgapplication.ui.login;

import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Authentication result : success (user details) or error message.
 */

public class LoginResult extends AppCompatActivity
{
    @Nullable
    private LoggedInUserView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error)


    {
        this.error = error;
    }

    LoginResult(@Nullable LoggedInUserView success)

    {
        this.success = success;
    }

    @Nullable
    LoggedInUserView getSuccess()
    {
        return success;
    }

    @Nullable
    Integer getError()

    {
        return error;
    }



}