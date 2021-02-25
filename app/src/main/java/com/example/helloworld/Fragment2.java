package com.example.helloworld;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


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

        ArrayList<Student> detail_List = singleton.get(getActivity()).getDetailsHolder();
        Student sdetails = detail_List.get(Fragment1.pos);
        e1.setText(sdetails.getName());
        e2.setText(sdetails.getRollno());
        e3.setText(sdetails.getDepartment());
        e4.setText(sdetails.getEmailid());

        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Student sdetails = detail_List.get(Fragment1.pos);
                sdetails.setName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Student sdetails = detail_List.get(Fragment1.pos);
                sdetails.setName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Student sdetails = detail_List.get(Fragment1.pos);
                sdetails.setName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });


        return view;

    }
}