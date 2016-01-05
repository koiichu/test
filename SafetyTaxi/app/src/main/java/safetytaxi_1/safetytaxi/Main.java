package safetytaxi_1.safetytaxi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())){

            Intent intent = new Intent(Main.this, Login.class);
            startActivity(intent);
            finish();
        }
        else{
            ParseUser currntUser = ParseUser.getCurrentUser();
            if(currntUser != null){
                Intent intent = new Intent(Main.this, Home.class);
                startActivity(intent);
                finish();
            }
            else {
                Intent intent = new Intent(Main.this, Login.class);
                startActivity(intent);
                finish();
            }

        }

    }
}
