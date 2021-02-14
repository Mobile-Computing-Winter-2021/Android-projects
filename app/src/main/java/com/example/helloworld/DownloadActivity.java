package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadActivity extends AppCompatActivity {
    final static int MY_PERMISSIONS_REQUEST = 1;
    public static final int MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 123;
    public static final String TAG1 = "THE_DOWNLOAD_ACTIVITY";
    MediaPlayer m;
    private Button Download;
    private Button play;
    private Button Check;
    private Button Stop;
    //private final String MP3_URL = "";

    private File file;
    private EditText address;
    public String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        Download = (Button) findViewById(R.id.download);
        play = (Button) findViewById(R.id.playd);
        Check = (Button) findViewById(R.id.check);
       // address = (EditText) findViewById(R.id.edit1);
        Stop = (Button) findViewById(R.id.down);
       // String url1 = address.getText().toString();
        play.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent play1=new Intent(getApplicationContext(),MyService.class);
                play1.putExtra("filename","s2.mp3");
                startForegroundService(play1);
            }
        });
        Stop.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v)
                                    {
                                       Intent stop1=new Intent(getApplicationContext(),MyService.class);
                                        stopService(stop1);
                                    }


                               });
        Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager conn = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo network =
                        conn.getActiveNetworkInfo();
                if (network != null
                        && network.isConnected()) {


                    DownloadSync task = new DownloadSync();



                           task.execute("https://faculty.iiitd.ac.in/~mukulika/s1.mp3");


                }
            }
        });


        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isActive()) {
                    Toast.makeText(getApplicationContext(), "Internet is Connected", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public boolean isActive() {
        boolean connected = false;
        try {
            ConnectivityManager conn = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo network = conn.getActiveNetworkInfo();
            connected = network != null && network.isAvailable() && network.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    protected class DownloadSync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... URL) {
            int length;
            System.out.println("on doinback");
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                try {

                    URL url = new URL(URL[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    connection.connect();

                    InputStream input = connection.getInputStream();
                    // File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "filename.mp3");
                    // OutputStream output = new FileOutputStream();
                    FileOutputStream output = openFileOutput("s2.mp3", Context.MODE_PRIVATE);
                    byte[] data = new byte[1024];

                    while ((length = input.read(data)) != -1) {
                        output.write(data, 0, length);
                    }

                    output.flush();
                    output.close();
                    input.close();

                } catch (Exception e) {
                    Log.e("Error: ", e.getMessage());
                }
            }

            return null;
        }

    //    @Override
        //protected void onPostExecute(String s) {
          //  System.out.println("on postexecute");
       // }
    }
}