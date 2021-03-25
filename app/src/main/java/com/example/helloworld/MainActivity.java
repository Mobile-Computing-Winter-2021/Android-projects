package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.room.Database;
import androidx.room.Room;
import java.util.*;

import java.sql.Date;
import com.example.helloworld.GPS;
import com.example.helloworld.Database1;
import com.example.helloworld.Daoclass;
public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor sensoracc;
    private Sensor sensorlinear;
    private Sensor sensorproximity;
    private Sensor sensortemp;
    private Sensor sensorlight;
    private Sensor sensorgps;
    private Button accx;
    private Button accy;
    private Button accz;
    private Button acctemp;
    private Button checkstat;
    private TextView avgaccx;
    private TextView avgaccy;
    private TextView avgaccz;
    private TextView avgacctemp;
    private TextView display1;
    private TextView display2;
    private TextView display3;
    private TextView display4;
    private TextView display5;
    private TextView display6;
    private TextView motion;
    private Switch switch1 = null;
    private Switch switch2 = null;
    private Switch switch3 = null;
    private Switch switch4 = null;
    private Switch switch5 = null;
    private Switch switch6 = null;
    private float[] Gravity;
    private double accl;
    private double Current;
    private double Last;
    private long lastUpdate = 0;

    private int LOCATION_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accx = (Button) findViewById(R.id.button);
        accy = (Button) findViewById(R.id.button2);
        accz = (Button) findViewById(R.id.button3);
        acctemp = (Button) findViewById(R.id.button4);
       motion=(TextView)findViewById(R.id.textView8);
        avgaccx = (TextView) findViewById(R.id.textView9);
        avgaccy = (TextView) findViewById(R.id.textView10);
        avgaccz = (TextView) findViewById(R.id.textView11);
        avgacctemp = (TextView) findViewById(R.id.textView12);
        display1 = (TextView) findViewById(R.id.textView13);
        display2 = (TextView) findViewById(R.id.textView14);
        display3 = (TextView) findViewById(R.id.textView15);
        display4 = (TextView) findViewById(R.id.textView16);
        display5 = (TextView) findViewById(R.id.textView17);
        display6 = (TextView) findViewById(R.id.textView18);
        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch4 = (Switch) findViewById(R.id.switch4);
        switch5 = (Switch) findViewById(R.id.switch5);
        switch6 = (Switch) findViewById(R.id.switch6);
        switch1.setTextOn("On");
        switch1.setTextOff("Off");
        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        sensoracc = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorlinear = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensortemp = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorlight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorproximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        accl = 0.00f;
        Current = SensorManager.GRAVITY_EARTH;
        Last = SensorManager.GRAVITY_EARTH;
        ActivityCompat.requestPermissions(MainActivity.this,
               new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOCATION_REQUEST);

        GPS GPSTracker = new GPS(getApplicationContext());
        Location location = GPSTracker.getLocation();
        accx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        accy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        accz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        acctemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });




        if (switch1.isChecked()) {
            Toast.makeText(this, "accelerometer started", Toast.LENGTH_SHORT).show();


            System.out.println("Switch 1 is checked");
        }
        if (switch2.isChecked()) {

            Toast.makeText(this, "linear acceleration started", Toast.LENGTH_SHORT).show();
        }
        if (switch3.isChecked()) {
            //sensorproximity = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            Toast.makeText(this, "ambient temperature started", Toast.LENGTH_SHORT).show();

        }
        if (switch4.isChecked()) {
            //sensorlight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            Toast.makeText(this, "light sensor  started", Toast.LENGTH_SHORT).show();
        }
        if (switch6.isChecked()) {
            //sensorproximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            Toast.makeText(this, "proximity sensor  started", Toast.LENGTH_SHORT).show();
        }

       switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    //Toast.makeText(this,"gps sensor started",Toast.LENGTH_SHORT).show();
                    System.out.println("gps sensor started");

                    if (location != null) {

                      //  Toast.makeText(this, "gps sensor  inside", Toast.LENGTH_SHORT).show();
                        System.out.println("inside gps sensor");
                        Double latValue = location.getLatitude();
                        Double longValue = location.getLongitude();
                        String mytext = Double.toString(latValue);
                        display5.setText(mytext);


                         saveDatagps(latValue, longValue);
                      //  Toast.makeText(this, "lat=" + latValue + ", longitude=" +longValue , Toast.LENGTH_LONG).show();


                    }
        }

            }
        });
    }


    private void saveDatagps(double latitude, double longitude) {


    GPSdb model1 = new GPSdb();
    model1.setXval(latitude);
    model1.setYval(longitude);

    //long time = new Date().getTime();
    //long sysTime = System.currentTimeMillis();
      Database1.getInstance(MainActivity.this).mainDao().insertAllDataGps(model1);


     Toast.makeText(MainActivity.this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();
    }
    private void saveDataProx(float x) {


        Proximity model = new Proximity();
        model.setXval(x);


        Database1.getInstance(getApplicationContext()).mainDao().insertAllProx(model);


        // Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();


    }

    private void saveDataTemp(float x) {

        Temperaturedb model = new Temperaturedb();
        model.setXval(x);


        Database1.getInstance(getApplicationContext()).mainDao().insertDatatemp(model);


        //Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();

    }

    private void saveDatalinear(float x, float y, float z) {
        Lineardb model = new Lineardb();
        model.setXval(x);
        model.setYval(y);
        model.setZval(z);


        Database1.getInstance(getApplicationContext()).mainDao().insertAllLinear(model);


        // Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();

    }

    private void saveDataAcc(float x, float y, float z) {
        Acceloroom model = new Acceloroom();
        model.setXval(x);
        model.setYval(y);
        model.setZval(z);
       // model.setTime(time);


        Database1.getInstance(getApplicationContext()).mainDao().insertAllData(model);


        // Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();

    }

    private void saveDatalight(float x) {
        Lightdb model = new Lightdb();
        model.setXval(x);

        Database1.getInstance(getApplicationContext()).mainDao().insertAllLight(model);


        //Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();

    }


    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        //sensor accuracy changes
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            if (switch1.isChecked()) {
                float x = event.values[0];

                float y = event.values[1];
                float z = event.values[2];
                //  float time=event.timestamp;
                long currentTime = System.currentTimeMillis();


                Toast.makeText(this, "x=" + x + ", y=" + y + ", z=" + z, Toast.LENGTH_LONG).show();
                saveDataAcc(x, y, z);

                Gravity = event.values.clone();

                float s = Gravity[0];
                float t = Gravity[1];
                float u = Gravity[2];
                Last = Current;
                Current = Math.sqrt(x * x + y * y + z * z);
                double delta = Current - Last;
                accl = accl * 0.9f + delta;
                if (accl > 0.5) {
                    motion.setText("Motion Detected");
                } else {
                    motion.setText(" ");
                }

            }
        }






            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {

                if (switch6.isChecked()) {
                    float val = event.values[0];
                    String mytext = Float.toString(val);
                    display6.setText(mytext);
                    Toast.makeText(this, "x=" + val, Toast.LENGTH_LONG).show();
                    saveDataProx(val);
                }
            }
            if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
                if (switch3.isChecked()) {
                    float val = event.values[0];
                    String mytext = Float.toString(val);
                    Toast.makeText(this, "x=" + val, Toast.LENGTH_LONG).show();
                    display3.setText(mytext);
                    saveDataTemp(val);
                }
            }
            if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
                if (switch2.isChecked()) {
                    float x = event.values[0];

                    float y = event.values[1];
                    float z = event.values[2];


                    Toast.makeText(this, "x=" + x + ", y=" + y + ", z=" + z, Toast.LENGTH_LONG).show();
                    saveDatalinear(x, y, z);


                }
            }
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                if (switch4.isChecked()) {
                    float x = event.values[0];
                    Toast.makeText(this, "x=" + x, Toast.LENGTH_LONG).show();
                    saveDatalight(x);


                }
            }


        }








    @Override
    protected void onResume() {
        super.onResume();
        if (sensoracc != null) {
            mSensorManager.registerListener(this, sensoracc, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensorlinear != null) {
            mSensorManager.registerListener(this, sensorlinear, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensorproximity != null) {
            mSensorManager.registerListener(this, sensorproximity, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensortemp != null) {
            mSensorManager.registerListener(this, sensortemp, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensorlight != null) {
            mSensorManager.registerListener(this, sensorlight, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);



    }
}



