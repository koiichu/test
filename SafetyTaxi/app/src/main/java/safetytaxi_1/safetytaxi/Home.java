package safetytaxi_1.safetytaxi;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class Home extends AppCompatActivity {
    ProgressDialog dialog;
    Button logout;
    Button report;

    ViewPager pager;
    PagerTabStrip tab_strp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ParseUser currentUser = ParseUser.getCurrentUser();
        String struser = currentUser.getUsername().toString();

        TextView txtUser = (TextView) findViewById(R.id.txt_user);
        txtUser.setText("You are logged in as " + struser);

        //logout = (Button) findViewById(R.id.logout);

        ma_pager_adapter mapager = new ma_pager_adapter(getSupportFragmentManager());
        pager=(ViewPager)findViewById(R.id.pager);

        pager.setAdapter(mapager);
        tab_strp=(PagerTabStrip)findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.WHITE);
        //   tab_strp.setTextSize(14,14);
        // tab_strp.setTabIndicatorColor(Color.WHITE);

        report = (Button) findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, timeline_report.class);
                startActivity(intent);
                finish();
            }
        });

        //////////////////////////ปุ่ม sos ด้านล่าง///////////////////////
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogSos();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user) {
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_history) {
            return true;
        }
        if (id == R.id.action_logout) {
            openDialogLogout();
            //return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialogSos() {
        final Dialog dialog = new Dialog(Home.this); // Context, this, etc.
        dialog.setContentView(R.layout.dialog_sos);
        dialog.setTitle("ช่วยด้วยยยยย!!!");
        dialog.show();
    }

    public void openDialogLogout() {
        dialog = new ProgressDialog(Home.this);
        dialog.setMessage("กำลังออกจากระบบ...");
        dialog.setCancelable(false);
        dialog.show();

        ParseUser.logOut();
        Intent intent = new Intent(Home.this, Login.class);
        startActivity(intent);
        finish();
    }
}
