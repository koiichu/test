package safetytaxi.safetytaxiapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Signup extends Activity {

    ProgressDialog dialog;

    EditText username;
    EditText password;
    EditText conPass;
    EditText email;
    EditText tel;
    Button regis;

    String username_a;
    String password_a;
    String conP;
    String Email;
    String Tel;



    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        conPass = (EditText)findViewById(R.id.con_pass);
        email = (EditText)findViewById(R.id.email);
        tel = (EditText)findViewById(R.id.tel);
        regis = (Button)findViewById(R.id.bt_Regis);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog = new ProgressDialog(Signup.this);
                dialog.setMessage("กำลังลงทะเบียน...");
                dialog.setCancelable(false);
                dialog.show();

                username_a = username.getText().toString();
                password_a = password.getText().toString();
                conP = conPass.getText().toString();
                Email = email.getText().toString();
                Tel = tel.getText().toString();

                if(password_a.equals(conP)){
                    pwd = password_a;
                }
                else{
                    dialog.dismiss();
                    password.setText("");
                    conPass.setText("");
                    Toast.makeText(Signup.this,
                            "กรุณากรอกรหัสผ่านอีกครั้ง",
                            Toast.LENGTH_SHORT).show();
                }

                int lengthPass = pwd.length();//count pwd
                if(lengthPass<8) {
                    dialog.dismiss();
                    Toast.makeText(Signup.this,
                            "กรุณากรอกรหัสผ่านมากกว่า 8 ตัวอักษร",
                            Toast.LENGTH_SHORT).show();
                }
                else {

                    if (username_a.equals("") && Email.equals("") && Tel.equals("")) {
                        dialog.dismiss();
                        Toast.makeText(Signup.this,
                                "กรุณากรอกแบบฟอร์มลงทะเบียนให้สมบูรณ์",
                                Toast.LENGTH_SHORT).show();
                    } else {

                        ParseUser user = new ParseUser();
                        user.setUsername(username_a);
                        user.setPassword(pwd);
                        user.setEmail(Email);
                        //user.setTel(Tel);
                        user.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    dialog.dismiss();
                                    Toast.makeText(Signup.this,
                                            "ลงทะเบียนเรียบร้อย",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Signup.this, Login.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    dialog.dismiss();
                                    Toast.makeText(Signup.this,
                                            "ลงทะเบียนไม่สำเร็จ อีเมล์นี้มีผู้ใช้งานแล้ว",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}
