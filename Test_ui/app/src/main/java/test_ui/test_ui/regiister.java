package test_ui.test_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class regiister extends AppCompatActivity {

    public Button clickSignUpButton;
    public Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiister);

         clickSignUpButton = (Button)findViewById(R.id.bt_signUp);
         i = new Intent(getApplicationContext(),Home.class);

        clickSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }



}
