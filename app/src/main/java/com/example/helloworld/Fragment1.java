package com.example.helloworld;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Fragment1 extends Fragment
{


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


   // private String mParam1;
    //private String mParam2;
    RecyclerView recyclerView;
    ArrayList<Student> dataholder;
    Dataclass adapterStu;
    public static int pos;

    public Fragment1() {

    }



   // public static Fragment1 newInstance(String param1, String param2) {
       // Fragment1 fragment = new Fragment1();
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
      // args.putString(ARG_PARAM2, param2);
      //  fragment.setArguments(args);
       //return fragment;
  // }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
          //  mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.fragment_1, container, false);
        recyclerView=view.findViewById(R.id.recycle1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder=new ArrayList<>();
       // updateUI();

        Student s1=new Student("khushboo Bajaj","20060","computer Science","khushboo20060@iiit.ac.in");
        dataholder.add(s1);
        Student s2=new Student("Mayank","20061","computational biology","mayank20061@iiit.ac.in");
        dataholder.add(s2);
        Student s3=new Student("kratik","20062","CSAD","kratik20062@iiitd.ac.in");
        dataholder.add(s3);
        Student s4=new Student("lakshmi","20063","computer Science","lakshmi20063@iiitd.ac.in");
        dataholder.add(s4);
        Student s5=new Student("manasvi","20058","CSAD","manasvi20058@iiitd.ac.in");
        dataholder.add(s5);
        Student s6=new Student("shreyash","20059","HCD","shreyash20059@iiitd.ac.in");
        dataholder.add(s6);
        Student s7=new Student("nidhi","20065","computer Science","nidhi20065@iiitd.ac.in");
        dataholder.add(s7);
        Student s8=new Student("mitali","20066","ECE","mitali20066@iiitd.ac.in");
        dataholder.add(s8);
        Student s9=new Student("kavya","20067","IT","kavya20067@iiitd.ac.in");
        dataholder.add(s9);
        Student s10=new Student("Mukul","20068","eee","mukul20068@iiitd.ac.in");
        dataholder.add(s10);
        Student s11=new Student("Mihir","20069","computer Science","mihir20069@iiitd.ac.in");
        dataholder.add(s11);
        Student s12=new Student("Mayur","20070","Mechanical","Mayur20070@iiitd.ac.in");
        dataholder.add(s12);
        Student s13=new Student("Mayuri","20071","computer Science","mayuri20071@iiitd.ac.in");
        dataholder.add(s13);
        Student s14=new Student("Nikhil","20072","hci","nikhil20072@iiitd.ac.in");
        dataholder.add(s14);
        Student s15=new Student("Ankit","20073","Mechanical","Ankit@iiitd.ac.in");
        dataholder.add(s15);
        Student s16=new Student("Varsha","20074","Computer Science","Varsha20074@iiitd.ac.in");
        dataholder.add(s16);
        Student s17=new Student("karan","20075","Mechanical","karan20075@iiitd.ac.in");
        dataholder.add(s17);
        Student s18=new Student("pinky","20076","EEE","pinky20076@iiitd.ac.in");
        dataholder.add(s18);
        Student s19=new Student("taruna","20077","CSAD","taruna20077@iiitd.ac.in");
        dataholder.add(s19);
        Student s20=new Student("monu","20078","computer Science","monu20078@iiitd.ac.in");
        dataholder.add(s20);
        Student s21=new Student("naina","20079","eee","naina20079@iiitd.ac.in");
        dataholder.add(s21);
        Student s22=new Student("ruchi","20081","ece","ruchi20081@iiitd.ac.in");
        dataholder.add(s22);
        Student s23=new Student("rubina","20082","computer Science","rubina20082@iiitd.ac.in");
        dataholder.add(s23);
        Student s24=new Student("rakhi","20083","CSAD","rakhi20083@iiitd.ac.in");
        dataholder.add(s24);
        Student s25=new Student("gaurav","20084","computer Science","gaurav20084@iiitd.ac.in");
        dataholder.add(s25);
        Student s26=new Student("rohit","20085","csb","rohit20085@iiitd.ac.in");
        dataholder.add(s26);
        Student s27=new Student("yashvi","20086","computer science","yashvi20086@iiitd.ac.in");
        dataholder.add(s27);
        Student s28=new Student("prachi","20087","Mechanical","prachi20087@iiit.ac.in");
        dataholder.add(s28);
        Student s29=new Student("priyank","20088","eee","priyank20088@iiit.ac.in");
        dataholder.add(s29);
        Student s30=new Student("priyanshu","20089","computer Science","priyanshu20089@iiit.ac.in");
        dataholder.add(s30);





       // recyclerView.setAdapter(new Dataclass(dataholder));
        singleton.get(getActivity()).setDetailsHolder(dataholder);
        updateUI();

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
   // public void updateUI() {
      //  MainActivity crimeLab = MainActivity.get(getActivity());
      //  List<Crime> crimesList = crimeLab.getCrimesList();
       // if (mAdapter == null) {
           // mAdapter = new CrimeAdapter(crimesList);
          //  mCrimeRecycleView.setAdapter(mAdapter);
       // } else {
     //       mAdapter.setCrimesList(crimesList);
     //       mAdapter.notifyDataSetChanged();
    //    }

      //  updateSubtitle();
   // }

    private void updateUI()
    {
        singleton singletonClass = singleton.get(getActivity());
        ArrayList<Student> details = singletonClass.getDetailsHolder();

        if (adapterStu == null) {
            adapterStu = new Dataclass(details);
            recyclerView.setAdapter(adapterStu);
        } else {
            adapterStu.notifyDataSetChanged();
        }

    }}
