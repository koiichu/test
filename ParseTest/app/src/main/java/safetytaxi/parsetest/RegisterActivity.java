package safetytaxi.parsetest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends Activity
{
    private EditText username;
    private EditText password;
    private EditText email;
    private Button SignUp;
    private Button back;

    String Username;
    String Password;
    String Email;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        SignUp = (Button)findViewById(R.id.signup);
        back = (Button)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog = new ProgressDialog(RegisterActivity.this);
                dialog.setMessage("Signing Up...");
                dialog.setCancelable(false);
                dialog.show();

                Username = username.getText().toString();
                Password = password.getText().toString();
                Email = email.getText().toString();

                /*ParseUser user = new ParseUser();
                user.setUsername(Username);
                user.setPassword(Password);
                user.setEmail(Email);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(RegisterActivity.this,
                                    "Successfully Signed Up.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, Login.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this,
                                    "Sign Up error.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

                if(Username.equals("") && Password.equals("") && Email.equals("")){
                    dialog.dismiss();
                    Toast.makeText(RegisterActivity.this,
                            "Please complete the sign up form.",
                            Toast.LENGTH_SHORT).show();
                }
                else{

                    ParseUser user = new ParseUser();
                    user.setUsername(Username);
                    user.setPassword(Password);
                    user.setEmail(Email);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                dialog.dismiss();
                                Toast.makeText(RegisterActivity.this,
                                        "Successfully Signed Up.",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, Login.class);
                                startActivity(intent);
                                finish();
                            } else {
                                dialog.dismiss();
                                Toast.makeText(RegisterActivity.this,
                                        "Sign Up error.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }

}
