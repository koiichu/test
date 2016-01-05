package safetytaxi_1.safetytaxi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class Report extends Activity {
    EditText license_a;
    EditText start_a;
    EditText end_a;
    EditText comment_a;
    Spinner spinner;
    CheckBox one_a;
    CheckBox two_a;
    CheckBox three_a;
    RatingBar rate;
    Button submit;

    String color_choose = "";
    float rate_f = 0;

    ProgressDialog dialog;
    String objectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ParseUser currentUser = ParseUser.getCurrentUser();
        objectId = currentUser.getObjectId().toString();

        spinner = (Spinner) findViewById(R.id.spinner2);
        final String[] color_car = {"เหลือง-เขียว", "เหลือง", "ฟ้า"};
        final Integer[] image = { R.drawable.cancle_but, R.drawable.cancle_but};

        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, color_car);
        // Drop down layout style - list view with radio button
        //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item, color_car);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (color_car[position] == "เหลือง-เขียว") {
                    color_choose = "เหลือง-เขียว";
                } else if (color_car[position] == "เหลือง") {
                    color_choose = "เหลือง";
                } else if (color_car[position] == "ฟ้า") {
                    color_choose = "ฟ้า";
                } else return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }

        });//end spinner

        license_a = (EditText)findViewById(R.id.license);
        start_a = (EditText)findViewById(R.id.start);
        end_a = (EditText)findViewById(R.id.end);
        comment_a = (EditText)findViewById(R.id.comment);
        one_a = (CheckBox)findViewById(R.id.checkBox_1);
        two_a = (CheckBox)findViewById(R.id.checkBox_2);
        three_a = (CheckBox)findViewById(R.id.checkBox_3);
        submit = (Button)findViewById(R.id.report_submit);

        rate = (RatingBar)findViewById(R.id.ratingBar);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating == 0.5){
                    rate_f = rating;
                }
                else if(rating == 1){
                    rate_f = rating;
                }
                else if(rating == 1.5){
                    rate_f = rating;
                }
                else if(rating == 2){
                    rate_f = rating;
                }
                else if(rating == 2.5){
                    rate_f = rating;
                }
                else if(rating == 3){
                    rate_f = rating;
                }
                else if(rating == 3.5){
                    rate_f = rating;
                }
                else if(rating == 4){
                    rate_f = rating;
                }
                else if(rating == 4.5){
                    rate_f = rating;
                }
                else if(rating == 5){
                    rate_f = rating;
                }
                else return;
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(Report.this);
                dialog.setMessage("Reporting...");
                dialog.setCancelable(false);
                dialog.show();

                String License = license_a.getText().toString();
                License = License.trim();
                String Start = start_a.getText().toString();
                String End = end_a.getText().toString();
                String Comment = comment_a.getText().toString();

                //------------------------------------------start checkbox--------------------------
                int numCheck = 0;
                String[] a = new String[3];//0-2
                if (one_a.isChecked()) {//true
                    a[numCheck] = "ขับรถเร็ว";
                    numCheck++;
                }
                if (two_a.isChecked()) {
                    a[numCheck] = "ไม่สุภาพ";
                    numCheck++;
                }
                if (three_a.isChecked()) {
                    a[numCheck] = "ลวนลาม";
                    numCheck++;
                }

                String mix = "";
                for (int i = 0; i <= numCheck - 1; i++) {
                    if (i < numCheck - 1) {
                        mix = mix + a[i] + ", ";
                    } else if (i == numCheck - 1) {
                        mix = mix + a[i];
                    } else {
                        return;
                    }
                }//-----------------------------------------end checkbox----------------------------

                ParseObject report = new ParseObject("Report");
                report.put("License", License);
                report.put("Color", color_choose);
                report.put("Start", Start);
                report.put("End", End);
                report.put("Rating", rate_f);
                report.put("Action", mix);
                report.put("Comment", Comment);
                report.put("user_id", ParseObject.createWithoutData("_User", objectId));
                report.saveInBackground();

                dialog.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(Report.this);
                builder.setTitle("Report");
                builder.setMessage("Report is success")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                license_a.setText("");
                                start_a.setText("");
                                end_a.setText("");
                                comment_a.setText("");
                                spinner.setSelection(dataAdapter.getPosition("เหลือง-เขียว"));
                                rate.setRating(0);
                                one_a.setChecked(false);
                                two_a.setChecked(false);
                                three_a.setChecked(false);
                                return;
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}
