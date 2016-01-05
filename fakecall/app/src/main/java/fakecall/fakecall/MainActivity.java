package fakecall.fakecall;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    // TextView nameView;
    private TextView calltext;
    private EditText edit_NameCall;
    private Button bt_Call, bt_Call2, bt_Call3, bt_Call4, bt_Call5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //nameView = (TextView)findViewById(R.id.nameView);
        //userName = (EditText)findViewById(R.id.edit_NameCall);
        //userName.setText("Your name...");

        bt_Call = (Button) findViewById(R.id.bt_Call);
        bt_Call2 = (Button) findViewById(R.id.bt_Call2);
        bt_Call3 = (Button) findViewById(R.id.bt_Call3);
        bt_Call4 = (Button) findViewById(R.id.bt_Call4);
        bt_Call5 = (Button) findViewById(R.id.bt_Call5);

        bt_Call.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, call.class);
                EditText userName = (EditText)findViewById(R.id.edit_NameCall);
                i.putExtra("Name",userName.getText().toString());
                startActivity(i);
            }


        });

        bt_Call2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, call.class);

                startActivity(i);
            }
        });

    }
}