package safetytaxi.safetytaxiapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button sign_up;
    TextView forget;

    ProgressDialog dialog;

    String username_a;
    String password_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.bt_login);
        sign_up = (Button) findViewById(R.id.bt_signup);
        forget = (TextView) findViewById(R.id.forgetPwd);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(Login.this);
                dialog.setMessage("กำลังเข้าสู่ระบบ...");
                dialog.setCancelable(false);
                dialog.show();

                username_a = username.getText().toString();
                password_a = password.getText().toString();

                if(username_a.equals("") && password_a.equals("")){
                    dialog.dismiss();
                    Toast.makeText(Login.this,
                            "กรุณากรอกชื่อผู้ใช้งาน และรหัสผ่าน",
                            Toast.LENGTH_SHORT).show();
                }

                ParseUser.logInInBackground(username_a, password_a, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, com.parse.ParseException e) {

                        if (parseUser != null) {
                            Intent intent = new Intent(Login.this, Home.class);
                            startActivity(intent);
                            finish();
                        } else {
                            dialog.dismiss();
                            Toast.makeText(Login.this,
                                    "กรอกชื่อผู้ใช้งาน หรือรหัสผ่านผิด",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login.this, Signup.class);
                startActivity(intent2);
                finish();
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login.this, Forgetpwd.class);
                startActivity(intent2);
                finish();
            }
        });

    }
}
