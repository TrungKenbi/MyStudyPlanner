package vn.edu.tdmu.msp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.tdmu.msp.adapter.TimetableAdapter;
import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.Mark;
import vn.edu.tdmu.msp.data.model.Subject;
import vn.edu.tdmu.msp.data.model.TDMUResponse;
import vn.edu.tdmu.msp.utils.ApiUtils;
import vn.edu.tdmu.msp.utils.DateHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static boolean IS_LOGIN = false;
    public static String USERNAME = "";
    public static String PASSWORD = "";

    private TextInputLayout edtUsername;
    private TextInputLayout edtPassword;
    private Button btnLogin;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
            StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

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

        // Demo login
        // edtUsername.getEditText().setText("1824801030067");
        // edtPassword.getEditText().setText("hieu123leggo@456");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                handleLogin();
                break;
            case R.id.btnSignUp:
                String message = "Chức năng đang được xây dựng !";
                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
                break;

                // Intent intent = new Intent(LoginActivity.this, Register.class);
                // startActivity(intent);
                // break;
        }
    }

    private void handleLogin() {
        String username = edtUsername.getEditText().getText().toString();
        String password = edtPassword.getEditText().getText().toString();

        if (username.equals("") || password.equals("")) {
            String message = "Vui lòng nhập đầy đủ thông tin !";
            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }


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
        TDMUService mService = ApiUtils.getTDMUService();
        try {
            List<Mark> marks = mService.getStudentMark(username, password).execute().body();
            if (marks.size() > 0) {
                IS_LOGIN = true;
                USERNAME = username;
                PASSWORD = password;
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
