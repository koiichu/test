package safetytaxi.safetytaxiapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class Home extends Activity {
    ProgressDialog dialog;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ParseUser currentUser = ParseUser.getCurrentUser();
        String struser = currentUser.getUsername().toString();

        TextView txtUser = (TextView)findViewById(R.id.txtuser);
        txtUser.setText("You are logged in as " + struser);

        logout = (Button)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(Home.this);
                dialog.setMessage("กำลังออกจากระบบ...");
                dialog.setCancelable(false);
                dialog.show();

                ParseUser.logOut();
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
