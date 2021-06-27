//This imports a package
package com.example.rccgapplication.ui.login;
//This imports the Activities package.Activities are the different units that define an Android application
import android.app.Activity;

//Lifecycles declare how the activity behaves when the user leaves or reneters the activity.Observer
// class defines one to many dependencies between objects
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;

//An intent is a messaging object that you can use to request an action from another application component
import android.content.Intent;
//Android Bundle is used to pass data between activities.
import android.os.Bundle;
//Nullable annotation indicates a variable,parameter or return value that can be null
import androidx.annotation.Nullable;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rccgapplication.R;
import com.example.rccgapplication.ui.login.LoginViewModel;
import com.example.rccgapplication.ui.login.LoginViewModelFactory;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity
{
    //private class LoginViewModel
    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //Super keyword create Content
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = (LoginViewModel) new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>()
        {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState)
            {
                if (loginFormState == null)
                {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null)
                {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null)
                {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>()
        {
            @Override
            public void onChanged(@Nullable LoginResult loginResult)
            {
                if (loginResult == null)
                {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null)
                {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null)
                {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if (actionId == EditorInfo.IME_ACTION_DONE)
                {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }


    /** Called when the user taps the Send button */
    public void sendMessage(View view)
    {

    }

    /** Called when the user taps the Signup Login  button */

    private void updateUiWithUser(LoggedInUserView model)
    {
        Intent intent = new Intent(this, DepartmentsActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);


        startActivity(intent);
       // String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
     //   Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString)
    {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}