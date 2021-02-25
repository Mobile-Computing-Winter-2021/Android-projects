package com.example.helloworld;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Fragment2 extends Fragment {

  public  static EditText e1;
  public static  EditText e2;
   public static EditText e3;
  public static  EditText e4;

    public Fragment2() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_2, container, false);
        e1=(EditText)view.findViewById(R.id.edit1);
        e2=(EditText)view.findViewById(R.id.edit2);
        e3=(EditText)view.findViewById(R.id.edit3);
        e4=(EditText)view.findViewById(R.id.edit4);

        Details activity = (Details) getActivity();
        String myName = activity.getMyName();
        String rollno = activity.getMyRollno();
        String department = activity.getMyDepartment();
        String email = activity.getMyemailid();
        System.out.println(myName);
        e1.setText(myName);
        e2.setText(rollno);
        e3.setText(department);
        e4.setText(email);
       // if(!((e1.getText())equals())


        //Bundle bundle=getArguments();

       // String myString =bundle.getString("name");
        return view;

    }
}