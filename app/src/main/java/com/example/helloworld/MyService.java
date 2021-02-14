package com.example.helloworld;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.io.IOException;

public class MyService extends Service implements MediaPlayer.OnPreparedListener {
    MediaPlayer mediaPlayer;

    //private NotificationManagerCompat myNotification;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("oncreate");
        Toast.makeText(this, "Service is Created", Toast.LENGTH_LONG).show();
    //  String text= MusicFragment.valueFromSpinner;


        //  Intent intent= new Intent();

        //String text = intent.getStringExtra("extrastring");
      /* if (text.equals("Westworld")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.westworld);

        }
        if (text.equals("Friends")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.friends);
        }
        if (text.equals("Jumanji drums")) {

            mediaPlayer = MediaPlayer.create(this, R.raw.jumanji);
        }
        if (text.equals("National Anthem")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.nationalanthem);
        }
        if (text.equals("first")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.s1);
        }
        if (text.equals("Narcos ringtone")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.narcos);
        }
*/
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onstartcommand");
        if(mediaPlayer == null)
        {
            mediaPlayer= new MediaPlayer();
        }

       if(intent.hasExtra("filename")) {

          String result= intent.getStringExtra("filename");

          System.out.println("hiii");
         if(mediaPlayer.isPlaying()) {
             mediaPlayer.reset();
          }
         // mediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://"+getPackageName()+"/raw/"));
           String directory= Environment.getDataDirectory().getAbsolutePath()+"/data/com.example.helloworld/files/s2.mp3";

           try {

               mediaPlayer.setDataSource(directory);
               System.out.println(directory);
               mediaPlayer.setOnPreparedListener(this);
               mediaPlayer.prepareAsync();
              // mediaPlayer.start();
           } catch (IOException e) {
               e.printStackTrace();

           }
       }
       else {
           String text = intent.getExtras().getString("extrastring");
        // String text= MusicFragment.valueFromSpinner;
           if(mediaPlayer.isPlaying()) {
               mediaPlayer.stop();
               mediaPlayer.reset();

           }
           if (text.equals("Westworld")) {
               mediaPlayer = MediaPlayer.create(this, R.raw.westworld);

           }
           if (text.equals("Friends")) {
               mediaPlayer = MediaPlayer.create(this, R.raw.friends);
           }
           if (text.equals("Jumanji drums")) {

               mediaPlayer = MediaPlayer.create(this, R.raw.jumanji);
           }
           if (text.equals("National Anthem")) {
               mediaPlayer = MediaPlayer.create(this, R.raw.nationalanthem);
           }
           if (text.equals("first")) {
               mediaPlayer = MediaPlayer.create(this, R.raw.s1);
           }
           if (text.equals("Narcos ringtone")) {
               mediaPlayer = MediaPlayer.create(this, R.raw.narcos);
           }
           mediaPlayer.start();
       }

        // if (intent != null && intent.getExtras() != null) {
        // String value = intent.getExtras().getString("extrastring");

        // String text = intent.getStringExtra("extrastring");
        // MusicFragment m=new MusicFragment();
        // System.out.println(MusicFragment.valueFromSpinner);
        //  String text1=m.valueFromSpinner;
        //Toast.makeText(this, value, Toast.LENGTH_LONG).show();

        /*if (text.equals("Westworld")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.westworld);

        }
        if (text.equals("Friends")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.friends);
        }
        if (text.equals("Jumanji drums")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.jumanji);
        }
        if (text.equals("National Anthem")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.nationalanthem);
        }
        if (text.equals("first")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.s1);
        }
        if (text.equals("Narcos ringtone")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.narcos);
        }

         */
        //mediaPlayer.start();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("Channelid", "Music Player", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);

        }
        Intent intent1 = new Intent(this, MainActivity.class);
        Log.d("text", "Music is Playing");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);
        Notification notification = new NotificationCompat.Builder(this, "Channelid").setContentTitle("Music")
                .setContentText("Your music is playing in the foreground")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);


        return START_NOT_STICKY;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public void createchannel() {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}


    // @Override
    // public void onCreate() {
    // Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
    // myNotification = NotificationManagerCompat.from(this);
    // @Override
    //  public IBinder onBind (Intent intent){
    // TODO: Return the communication channel to the service.
    //  throw new UnsupportedOperationException("Not yet implemented");
    //  }
    // }
//}
//}
//public int onStartCommand(Intent intent, int flags, int startid) {
    // notificationManager = (NotificationManager)
    // getSystemService(Context.NOTIFICATION_SERVICE);
       // int icon = android.R.drawable.stat_notify_sync;
       // CharSequence tickerText = "Hello";
   //     long when = System.currentTimeMillis();
     //   Notification notification = new Notification(icon, tickerText, when);
      //  Context context = getApplicationContext();
       // CharSequence contentTitle = "My notification";
      //  CharSequence contentText = "Hello World!";
     //   Intent notificationIntent = new Intent(this, Main.class);
    //    PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
    //    notificationIntent, 0);
      //  notification.setLatestEventInfo(context, contentTitle, contentText,
    //    contentIntent);
     //   notificationManager.notify(NOTIFICATION_EX, notification);
      //  Toast.makeText(this, "Started!", Toast.LENGTH_LONG);
     //   timer.scheduleAtFixedRate(new TimerTask() {


//}
