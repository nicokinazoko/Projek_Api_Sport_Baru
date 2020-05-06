package com.example.projek_api_sport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class RegisterAcivity extends AppCompatActivity {
    //deklarasi EditText
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    //deklarasi TextInputLayout
    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Deklarasi Button
    Button buttonRegister;

    //Deklarasi Sqlitehelper
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acivity);

        sqliteHelper                                =   new SqliteHelper(this);
        initTextViewLogin();
        initViews();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    String UserName                 =   editTextUserName.getText().toString();
                    String Email                    =   editTextEmail.getText().toString();
                    String Password                 =   editTextPassword.getText().toString();

                    //Mengecek apakah data ada yang sama dengan email
                    if(!sqliteHelper.isEmailExists(Email))
                    {
                        //email does not exists now add new user to database
                        sqliteHelper.addUser(new User(null,UserName,Email,Password));
                        Snackbar.make(buttonRegister, "User Berhasil Dibuat ! Silahkan Login",Snackbar.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        },Snackbar.LENGTH_LONG);
                    }
                    else
                    {
                        //email sudah ada, memunculkan error bahwa email sudah pernah terdaftar
                        Snackbar.make(buttonRegister,"User Sudah Ada dengan Email yang Sama",Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //method ini digunakan untuk set Login TextView click event
    private void initTextViewLogin()
    {
        TextView textViewLogin                          =   (TextView)findViewById(R.id.TextViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    //method ini digunakan untuk menghubungkan view XML dengan objek
    private void initViews()
    {
        editTextEmail                                   =   (EditText)findViewById(R.id.EditTextEmail);
        editTextUserName                                =   (EditText)findViewById(R.id.EditTextUserName);
        editTextPassword                                =   (EditText)findViewById(R.id.EditTextPassword);
        textInputLayoutEmail                            =   (TextInputLayout)findViewById(R.id.TextInputLayoutEmail);
        textInputLayoutUserName                         =   (TextInputLayout)findViewById(R.id.TextInputLayoutUserName);
        textInputLayoutPassword                         =   (TextInputLayout)findViewById(R.id.TextInputLayoutPassword);
        buttonRegister                                  =   (Button)findViewById(R.id.ButtonRegister);
    }

    //method ini digunakan untuk validasi input user
    private boolean validate()
    {
        boolean valid                                   =   false;

        //mengambil value dari field EditText
        String UserName                                 =   editTextUserName.getText().toString();
        String Email                                    =   editTextEmail.getText().toString();
        String Password                                 =   editTextPassword.getText().toString();

        //validasi untuk field UserName
        if(UserName.isEmpty())
        {
            valid                                       =   false;
            textInputLayoutUserName.setError("Username tidak boleh Kosong !");
        }
        else
        {
            if(UserName.length() > 5)
            {
                valid                                   =   true;
                textInputLayoutUserName.setError(null);
            }
            else
            {
                valid                                   =   false;
                textInputLayoutUserName.setError("Username Terlalu Pendek !");
            }
        }

        //validasi untuk field email
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            valid                                       =   false;
            textInputLayoutEmail.setError("Email tidak boleh Kosong !");
        }
            else
            {
                valid                                   =   false;
                textInputLayoutPassword.setError("");
            }

            //validasi untuk field password
        if(Password.isEmpty())
        {
            valid                                       =   false;
            textInputLayoutPassword.setError("Password Tidak Boleh Kosong !");
        }
        else
            if(Password.length() > 5)
            {
                valid                                   =   true;
                textInputLayoutPassword.setError(null);
            }
            else
            {
                valid                                   =   false;
                textInputLayoutPassword.setError("Password Terlalu Pendek");
            }
        return valid;
    }

}
