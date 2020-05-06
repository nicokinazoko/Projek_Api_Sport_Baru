package com.example.projek_api_sport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projek_api_sport.VIew.Activity.MainActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    //deklarasi untuk bagian EditTeks
    EditText editTextEmail;
    EditText editTextPassword;

    //deklarasi untuk bagian TeksInputLayout
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //deklarasi untuk Button
    Button buttonLogin;

    //deklarasi SQLiteHelper
    SqliteHelper sqliteHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqliteHelper                            =   new SqliteHelper(this);

        initCreateAccountTextView();
        initViews();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Mengecek login apakah sudah benar atau belum
                if(validate())
                {
                    //Ambil data dari field EditText
                    String email                =   editTextEmail.getText().toString();
                    String password             =   editTextPassword.getText().toString();

                    //Autentikasi User
                    User CurrentUser            =   sqliteHelper.Authenticate(new User(null,null,email,password));

                    //Mengecek apakah autentikasi sukses atau tidak
                    if(CurrentUser != null)
                    {
                        Snackbar.make(buttonLogin,"Login Berhasil !",Snackbar.LENGTH_SHORT).show();

                        //User berhasil login dan memunculkan home
                        Intent intent           =   new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    else

                    {
                        //User gagal Login
                        Snackbar.make(buttonLogin,"Login Gagal, Silahkan Coba Lagi",Snackbar.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

    //method ini digunakan untuk set Create Account TextView text dan click event

    private void initCreateAccountTextView()
    {
        TextView textViewCreateAccount          =   (TextView)findViewById(R.id.TextViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>Saya belum mempunyai akun. </font><font color='#0c0099'>create one</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent                   =   new Intent(LoginActivity.this,RegisterAcivity.class);
                startActivity(intent);
            }
        });
    }

    //method ini digunakan untuk menghubungkan XML dengan objek nya
    private void initViews()
    {
        editTextEmail                           =   (EditText) findViewById(R.id.EditTextEmail);
        editTextPassword                        =   (EditText) findViewById(R.id.EditTextPassword);

        textInputLayoutEmail                    =   (TextInputLayout)findViewById(R.id.TextInputLayoutEmail);
        textInputLayoutPassword                 =   (TextInputLayout)findViewById(R.id.TextInputLayoutPassword);

        buttonLogin                             =   (Button)findViewById(R.id.ButtonLogin);
    }

    //Method ini digunakan untuk mengatasi fromHTML method depreciation
    public static Spanned fromHtml(String html)
    {
        Spanned result;
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            result                              = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY);
        }
        else
        {
            result                              =   Html.fromHtml(html);
        }

        return result;
    }


    //Method ini digunakan untuk validasi input yang dilakukan oleh user
    public boolean validate()
    {
        boolean valid                           =   false;

        //mengambil value dari field EditText
        String email                            =   editTextEmail.getText().toString();
        String password                         =   editTextPassword.getText().toString();

        //Validasi untuk email
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            valid                               =   false;
            textInputLayoutEmail.setError("Email Tidak Valid");
        }
        else
        {
            valid                               =   true;
            textInputLayoutEmail.setError(null);
        }

        //Validasi untuk password
        if(password.isEmpty())
        {
            valid                               =   false;
            textInputLayoutPassword.setError("Password Tidak Boleh Kosong");
        }
        else
            if(password.length() > 5)
            {
                valid                           =   true;
                textInputLayoutPassword.setError(null);
            }
            else
            {
                valid                           =   false;
                textInputLayoutPassword.setError("Password Terlalu Pendek!");
            }
            return  valid;
    }
}

