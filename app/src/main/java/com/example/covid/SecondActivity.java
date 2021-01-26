package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import android.widget.EditText;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    public String value;
    public int counter2 = 1;
   public  int counting;
    public static final String TAG2 = "THE_SECOND_ACTIVITY";
    public String current = "onCreate";
    public String previous = "onCreate";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Activity 2");
        if (counter2 == 1) {
            Log.i(TAG2, "State of SecondActivity in onCreate");

            Toast.makeText(getApplicationContext(), "State of SecondActivity in Oncreate", Toast.LENGTH_LONG).show();
        } else {
            current = "onCreate";
            Log.i(TAG2, "State of SecondActivity changed from " + previous + " to " + current);
            Toast.makeText(getApplicationContext(), "State of SecondActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
            previous = "onCreate";
        }
        counter2++;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        TextView textview1 = (TextView) findViewById(R.id.textView5);
        Button safe = (Button) findViewById(R.id.button3);

        Bundle bundle = getIntent().getExtras();


        String data = bundle.getString(Intent.EXTRA_TEXT);

        if (data.length()==2) {

            textview1.setText("You do not have any data to show");
        } else {
            textview1.setText(data);
        }

        safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counting = 1;

                int checkvalue = Checkcount();
                if (checkvalue == 5) {
                    Log.i(TAG2, "yes");

                    Toast.makeText(getApplicationContext(),"YES,YOU ARE SAFE",Toast.LENGTH_LONG).show();
                    value = "Congratulations,you are safe.I am proud of you";
                } else {
                    Log.i(TAG2, "no");

                    Toast.makeText(getApplicationContext(),"NO,YOU ARE NOT SAFE",Toast.LENGTH_LONG).show();
                    value = "You are not safe.You do not follow all precautions";
                }
               // Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                //intent1.putExtra("message_key", value);
                //startActivity(intent1);
                MainActivity.textview2.setText(value);

            }
        });

        }


       // @Override
       // public void onBackPressed()
      //  {

           // super.onBackPressed();

            //if (counting == 1) {
               // Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
             //   intent1.putExtra("message_key", value);
             //   startActivity(intent1);

           // }
       // }
       // public void Back(View v){
           // onBackPressed();










        public int Checkcount()
    {
        int countcheck = 0;
        if ((MainActivity.check1).isChecked()) {
            countcheck++;
        }
        if ((MainActivity.check2).isChecked()) {
            countcheck++;
        }
        if ((MainActivity.check3).isChecked()) {
            countcheck++;
        }
        if ((MainActivity.check4).isChecked()) {
            countcheck++;
        }
        if ((MainActivity.check5).isChecked()) {
            countcheck++;
        }
        return countcheck;
    }



    @Override
    protected void onStart() {
        super.onStart();
        current = "onStart";
        Log.i(TAG2, "State of SecondActivity changed from " + previous + " to " + current);

        Toast.makeText(getApplicationContext(), "State of SecondActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onStart";

    }


    @Override
    protected void onResume() {
        super.onResume();
        current = "onResume";
        Log.i(TAG2, "State of SecondActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of SecondActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onResume";
    }


    @Override
    protected void onPause() {
        super.onPause();
        current = "onPause";
        Log.i(TAG2, "State of SecondActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of SecondActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onPause";
    }


    @Override
    protected void onStop() {
        super.onStop();
        current = "onStop";
        Log.i(TAG2, "State of SecondActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of SecondActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onStop";
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        current = "onDestroy";
        Log.i(TAG2, "State of SecondActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of SecondActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onDestroy";
    }

    @Override
    public void onRestart() {
        super.onRestart();
        current = "onRestart";
        Log.i(TAG2, "State of SecondActivity changed from " + previous + " to " + current);
        Toast.makeText(getApplicationContext(), "State of SecondActivity changed from " + previous + " to " + current, Toast.LENGTH_LONG).show();
        previous = "onRestart";
    }




       // SecondActivity secactivity;



       // public void method() {
            // some code

            //secactivity.call_method();// 'Method' is Name of the any one method in SecondActivity

        }

