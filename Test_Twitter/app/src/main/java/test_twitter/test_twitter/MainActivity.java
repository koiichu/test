package test_twitter.test_twitter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText mUrl;
    Button mButtonOK;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUrl = (EditText) findViewById(R.id.text_url);
        mButtonOK = (Button) findViewById(R.id.button_ok);
        mWebView = (WebView) findViewById(R.id.webView_content);

        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


/*                AsyncHttpClient client = new AsyncHttpClient();
                client.get(mUrl.getText().toString().trim(), new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(String response) {
                        updateWebView(response);
                    }
                });*/

                new SimpleTask().execute(mUrl.getText().toString().trim());
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("menu index", position);
        startActivity(intent);
    }

    OkHttpClient okHttpClient = new OkHttpClient();

    Request.Builder builder = new Request.Builder();
    Request request = builder.url("http://md5.jsontest.com/?text=https://github.com/first087/Android-OkHttp-Example").build();

    okHttpClient.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {
            updateView("Error - " + e.getMessage());
        }

        @Override
        public void onResponse(Response response) {
            if (response.isSuccessful()) {
                try {
                    updateView(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                    updateView("Error - " + e.getMessage());
                }
            } else {
                updateView("Not Success - code : " + response.code());
            }
        }

    public void updateView(final String strResult) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textResult.setText(strResult);
            }
        });

    }




}
