package test_ui.test_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button clickLogin;
    Button clickRegis;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        clickLogin = (Button) findViewById(R.id.bt_login);
        intent = new Intent(getApplicationContext(), Home.class);

        clickRegis = (Button) findViewById(R.id.bt_regis);
        intent = new Intent(getApplicationContext(), regiister.class);

        clickLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        clickRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }


}
