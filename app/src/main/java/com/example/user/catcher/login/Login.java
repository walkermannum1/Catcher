package com.example.user.catcher.Login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.catcher.R;


/**
 * Created by user on 2016/7/14.
 */
public class Login extends Activity implements View.OnClickListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Button login;
    private TextView register;
    private TextView retrpass;
    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox rememberPass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        retrpass = (TextView) findViewById(R.id.retrpass);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        boolean isRemember =pref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin") && password.equals("123456")) {
                    editor = pref.edit();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
