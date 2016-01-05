package test_ui.test_ui;

//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.ActionBar;
import android.view.View;
import android.widget.Button;
//import android.support.v7.widget.Toolbar;
//import android.view.View;


public class Home extends AppCompatActivity {

    Button clickHome;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        clickHome = (Button)findViewById(R.id.home);
        intent = new Intent(getApplicationContext(),regiister.class);

        clickHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
