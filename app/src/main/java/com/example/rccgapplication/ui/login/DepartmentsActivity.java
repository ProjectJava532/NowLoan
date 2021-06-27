//This imports a package
package com.example.rccgapplication.ui.login;
//This imports the Activities package.Activities are the different units that define an Android application

//Lifecycles declare how the activity behaves when the user leaves or reneters the activity.Observer
// class defines one to many dependencies between objects

//An intent is a messaging object that you can use to request an action from another application component
//Android Bundle is used to pass data between activities.
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
//Nullable annotation indicates a variable,parameter or return value that can be null

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.example.rccgapplication.R;

public class DepartmentsActivity extends AppCompatActivity implements View.OnClickListener
{
    //private class LoginViewModel
    private LoginViewModel loginViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //Super keyword create Content
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments_1);
	Button children =findViewById(R.id.children);

	children.setOnClickListener(this);

    }

    public void onClick(View v)
	    {
		    switch(v.getId())
			    {
				    case R.id.children:
					    Toast.makeText(this,"ChildrenClicked",Toast.LENGTH_SHORT).show();
					    break;
			    }
		                    Intent intent = new Intent(DepartmentsActivity.this, Departments2Activity.class);
				    startActivity(intent);
				    //EditText editText = (EditText) findViewById(R.id.editText);
				    //startactivity(intent);
				    ////String welcome = getString(R.string.welcome) + model.getDisplayName();
				    //// TODO : initiate successful logged in experience
                                    //   Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();


    
}
}
