package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public int counter1 = 1;
    public static final String TAG1 = "THE_FIRST_ACTIVITY";
    public String current = "onCreate";
    public String previous = "onCreate";
    public static CheckBox check1, check2, check3, check4, check5;
    private Button submit;
    private Button clear;
    private EditText edittext1;
    private EditText edittext2;
    public TextView textview1;
    public static TextView textview2;
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (counter1 == 1) {
            Log.i(TAG1, "State of MainActivity in onCreate");

            Toast.makeText(getApplicationContext(), "State of MainActivity in Oncreate ", Toast.LENGTH_LONG).show();
        } else {
            current = "onCreate";
            Log.i(TAG1, "State of MainActivity changed from " + previous + " to " + current);
            Toast.makeText(getApplicationContext(), " State of MainActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
            previous = "onCreate";
        }
        counter1++;


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.button);
        clear = (Button) findViewById(R.id.button2);
        edittext1 = (EditText) findViewById(R.id.editTextTextPersonName3);
        textview2 = (TextView) findViewById(R.id.textView4);
        check1 = (CheckBox) findViewById(R.id.checkBox);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check3 = (CheckBox) findViewById(R.id.checkBox3);
        check4 = (CheckBox) findViewById(R.id.checkBox4);
        check5 = (CheckBox) findViewById(R.id.checkBox5);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.getText().clear();
                check1.setChecked(false);
                check2.setChecked(false);
                check3.setChecked(false);
                check4.setChecked(false);
                check5.setChecked(false);
                textview2.setText("");
            }
            });




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();


                //private String isCheckedOrNot(CheckBox checkBox){
                // if(checkBox.isChecked())
                //return "is checked";
                // else
                //  return "is not checked";
                // get the value which input by user in EditText
                // and convert it to string
                String str = edittext1.getText().toString();
                result.append("NAME:-");
                result.append(str);
                result.append("\n The precautions you take are:");
                if (check1.isChecked()) {
                    result.append("\n Wearing a mask when outside");

                }
                if (check2.isChecked()) {
                    result.append("\n Washing hands regularly");
                }
                if (check3.isChecked()) {
                    result.append("\n Maintaining 2 feet distance");

                }
                if (check4.isChecked()) {
                    result.append("\n Covering nose and  mouth while sneezing and coughing");

                }
                if (check5.isChecked()) {
                    result.append("\n Taking health diets");

                }

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);


                Bundle bundle = new Bundle();



                bundle.putString(Intent.EXTRA_TEXT, result.toString());


                intent.putExtras(bundle);


                startActivity(intent);
                //intent.putExtra("message_key", str);

                Intent intent1=getIntent();
                 String safeornot= intent1.getStringExtra("message_key");
                 textview2.setText(safeornot);
            }
        });
    }
    //public void send(View view) {
    // Intent intent = new Intent(this, SecondActivity.class);
    //CheckBox checkbox1 = (EditText) findViewById(R.id.editText);
    //String message = editText.getText().toString();
    //intent.putExtra(TAG1, message);
    //startActivity(intent);

   // public void Recreating() {
       // Intent intent = new Intent(this, MainActivity.class);
       // startActivity(intent);
    //}
   @Override
   public void onConfigurationChanged(Configuration newConfig) {
       super.onConfigurationChanged(newConfig);
   }
    @Override
    protected void onStart() {
        super.onStart();
        current = "onStart";
        Log.i(TAG1, "State of MainActivity changed from " + previous + " to  " + current);

        Toast.makeText(getApplicationContext(), "State of MainActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onstart";

    }


    @Override
    protected void onResume() {
        super.onResume();
        current = "onResume";
        Log.i(TAG1, "State of MainActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of MainActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onResume";
    }


    @Override
    protected void onPause() {
        super.onPause();
        current = "onPause";
        Log.i(TAG1, "State of MainActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of MainActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onPause";
    }


    @Override
    protected void onStop() {
        super.onStop();
        current = "onStop";
        Log.i(TAG1, "State of MainActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of MainActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onStop";
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        current = "onDestroy";
        Log.i(TAG1, "State of MainActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of MainActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onDestroy";
    }

    @Override
    public void onRestart() {
        super.onRestart();
        current = "onRestart";
        Log.i(TAG1, "State of MainActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of MainActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onRestart";
    }
}
