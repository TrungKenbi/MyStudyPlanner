package vn.edu.tdmu.msp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout edtUsername;
    private TextInputLayout edtPassword;
    private Button btnLogin;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.layoutPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        TextInputEditText edtPass = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        edtPass.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                handleLogin();
                return true;
            }
            return false;
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                handleLogin();
                break;
            case R.id.btnSignUp:
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
                break;
        }
    }

    private void handleLogin() {
        String username = edtUsername.getEditText().getText().toString();
        String password = edtPassword.getEditText().getText().toString();

        if (checkLogin(username, password)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            String message = "Tài khoản hoặc mật khẩu không chính xác !";
            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private boolean checkLogin(String username, String password) {
        if (username.equals("admin") && password.equals("123456"))
            return true;
        return false;
    }
}
