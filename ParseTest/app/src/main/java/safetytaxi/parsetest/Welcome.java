package safetytaxi.parsetest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class Welcome extends Activity {
    Button logout;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ParseUser currentUser = ParseUser.getCurrentUser();

        String struser = currentUser.getUsername().toString();

        TextView txtUser = (TextView)findViewById(R.id.txtuser);
        txtUser.setText("You are logged in as " + struser);

        logout = (Button)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(Welcome.this);
                dialog.setMessage("Logout...");
                dialog.setCancelable(false);
                dialog.show();

                ParseUser.logOut();
                Intent intent = new Intent(Welcome.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
