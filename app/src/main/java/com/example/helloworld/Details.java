package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Details extends AppCompatActivity {
    String name;
    String rollno;
    String department;
    String emailid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // String name;


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        rollno = intent.getStringExtra("rollno");
         department = intent.getStringExtra("department");
        emailid = intent.getStringExtra("emailid");
        // } catch(Exception e) {
        //  e.printStackTrace();
        // }


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportFragmentManager().beginTransaction().replace(R.id.container2, new Fragment2()).commit();
    }
        public String getMyName() {
            return name;
        }
       public String getMyRollno() {
        return rollno;
        }
        public String getMyDepartment()
        {
            return department;

        }
    public String getMyemailid()
    {
        return emailid;

    }



       // Bundle bundle = new Bundle();
      //  bundle.putString("name",name);
       // bundle.putString("rollno",rollno);
        //bundle.putString("department",department);
       // bundle.putString("emailid",emailid);

        //Fragment2 mapFragment = new Fragment2();
        //mapFragment.setArguments(bundle);


        //bundle.putString("emailid",temp.getDepartment());

        //Fragment2 mapFragment = new Fragment2();
        //mapFragment.setArguments(bundle);
    }
