package com.example.helloworld;


public class Student {

        private String Rollno;
        private String name;
        private String Department;
        private String emailid;

        public Student() {
        }

        public Student(String name, String Rollno, String Department, String emailid) {
            this.name = name;
            this.Rollno = Rollno;
            this.Department = Department;
            this.emailid = emailid;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRollno() {
            return Rollno;
        }

        public void setRollno(String rollno) {
            Rollno = rollno;
        }

        public String getDepartment() {
            return Department;
        }

        public void setDepartment(String department) {
            Department = department;
        }

        public String getEmailid() {
            return emailid;
        }

        public void setEmailid(String emailid) {
            this.emailid = emailid;
        }
    }


