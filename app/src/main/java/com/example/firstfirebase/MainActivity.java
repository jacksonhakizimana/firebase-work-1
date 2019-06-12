package com.example.firstfirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  {
    Button bLogin;
    EditText etEmail,etPassword;
    TextView etAccount;
    FirebaseAuth Jackhan;
    ProgressDialog Marry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Marry = new ProgressDialog(this);

        Jackhan = FirebaseAuth.getInstance ( );
        etAccount = (TextView) findViewById(R.id.etAccount);
        etEmail = (EditText) findViewById ( R.id.etEmail );
        etPassword = (EditText) findViewById ( R.id.etPassword );
        bLogin = (Button) findViewById ( R.id.bLogin );

        etAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistrationForm.class);
                startActivity(intent);
            }
        });
        bLogin.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                validate ( );
startActivity(new Intent(MainActivity.this,Courses.class));
            }
        } );


    }

    public void validate() {

        String Email = etEmail.getText ( ).toString ( ).trim ( );
        String Password = etPassword.getText ( ).toString ( ).trim ( );

        if ( Email.isEmpty ( ) ) {
            Toast.makeText ( MainActivity.this, "Enter your Email please", Toast.LENGTH_LONG ).show ( );
        }

        if ( Password.isEmpty ( ) ) {
            Toast.makeText ( MainActivity.this, "Enter your Password please", Toast.LENGTH_LONG ).show ( );
        }

        else {
            Marry.setMessage ( "Register is in processing please wait...." );
            Marry.show ( );

            Jackhan.createUserWithEmailAndPassword ( Email, Password ).addOnCompleteListener ( this, new OnCompleteListener<AuthResult>( ) {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Marry.dismiss ( );

                    if ( task.isSuccessful ( ) ) {

                        Toast.makeText ( MainActivity.this, " Registered successfully", Toast.LENGTH_LONG ).show ( );
                    }

                }
            } );
        }


    }


}
