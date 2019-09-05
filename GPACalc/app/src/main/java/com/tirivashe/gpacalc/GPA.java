package com.tirivashe.gpacalc;

public class GPA {


    public String grade;
    private int credit;
    private double gpa;

    public double calc_gpa(){
        if (setGrade(grade) == 4){
            gpa = (4*setCredit(credit));
            return gpa;
        }
        else if(setGrade(grade) == 2){
            gpa = (3*setCredit(credit));
            return gpa;
        }
        else if(setGrade(grade) == 2){
            gpa = (2*setCredit(credit));
            return gpa;
        }
        else if(setGrade(grade) == 2){
            gpa = (2*setCredit(credit));
            return gpa;
        }
        else
            return 0;
    }

    public int setGrade(String grade){
        if (grade == "A"){
            return 4;
        }
        else if (grade == "B"){
            return 3;
        }
        else if (grade == "C"){
            return 2;
        }
        else if (grade == "D"){
            return 2;
        }
        else
            return 0;
    }

    public int setCredit(int cred){
        credit = cred;
        return cred;
    }

}
