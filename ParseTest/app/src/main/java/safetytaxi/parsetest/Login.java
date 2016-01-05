package safetytaxi.parsetest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

/**
 * Created by Dell5448 on 9/12/2558.
 */
public class Login extends Activity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button sign_up;

    ProgressDialog dialog;

    String username_a;
    String password_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        sign_up = (Button) findViewById(R.id.signup_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(Login.this);
                dialog.setMessage("Login...");
                dialog.setCancelable(false);
                dialog.show();

                username_a = username.getText().toString();
                password_a = password.getText().toString();

                ParseUser.logInInBackground(username_a, password_a, new LogInCallback() {

                    @Override
                    public void done(ParseUser parseUser, com.parse.ParseException e) {
                        if (parseUser != null) {
                            Intent intent = new Intent(Login.this, Welcome.class);
                            startActivity(intent);
                            finish();
                        } else {
                            dialog.dismiss();
                            Toast.makeText(Login.this,
                                    "This user dosen't exist. Please signup",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login.this, RegisterActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}
