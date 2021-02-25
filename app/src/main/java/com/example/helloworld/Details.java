package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Details extends AppCompatActivity {
    String name1;
    String rollno1;
    String department1;
    String emailid1;
    int position2;
    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransact;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // String name;


       Intent intent = getIntent();
        name1 = intent.getStringExtra("name");
        rollno1 = intent.getStringExtra("rollno");
        department1 = intent.getStringExtra("department");
       emailid1= intent.getStringExtra("emailid");
       // position2=intent.getStringExtra("position1");
        position2= intent.getIntExtra("position1",0);
        Fragment1.pos=position2;


        fragmentmanager = getSupportFragmentManager();
        fragmenttransact = fragmentmanager.beginTransaction();
        Fragment2 student2 = new Fragment2();
        fragmenttransact.add(R.id.container2,student2 );
        //fragmentTransaction.addToBackStack(null);
        fragmenttransact.commit();




    }
        public String getMyName() {
            return name1;
        }
      public String getMyRollno() {
        return rollno1;
        }
        public String getMyDepartment()
        {
            return department1;

        }
    public String getMyemailid()
    {
        return emailid1;

   }
    public int getPosition2()
    {
        return position2;

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
