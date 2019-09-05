package com.tirivashe.gpacalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {

    GPA nGPA = new GPA();

    EditText class_1;
    EditText class_2;
    EditText class_3;
    EditText class_4;

    EditText grade_1;
    EditText grade_2;
    EditText grade_3;
    EditText grade_4;

    EditText credit_1;
    EditText credit_2;
    EditText credit_3;
    EditText credit_4;

    TextView resultGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        class_1 = (EditText)findViewById(R.id.editText);
        class_2 = (EditText)findViewById(R.id.editText2);
        class_3 = (EditText)findViewById(R.id.editText3);
        class_4 = (EditText)findViewById(R.id.editText4);

        grade_1 = (EditText)findViewById(R.id.editText5);
        grade_2 = (EditText)findViewById(R.id.editText6);
        grade_3 = (EditText)findViewById(R.id.editText7);
        grade_4 = (EditText)findViewById(R.id.editText8);

        credit_1 = (EditText)findViewById(R.id.editText9);
        credit_2 = (EditText)findViewById(R.id.editText10);
        credit_3 = (EditText)findViewById(R.id.editText11);
        credit_4 = (EditText)findViewById(R.id.editText12);

        resultGPA = (TextView)findViewById(R.id.textView);

    }

    public void goGPA(View view){
        String grade1 = grade_1.getText().toString();
        nGPA.setGrade(grade1);
        int cred1 = nGPA.setCredit(Integer.parseInt(credit_1.getText().toString()));
        nGPA.setCredit(cred1);

        String grade2 = grade_2.getText().toString();
        nGPA.setGrade(grade2);
        int cred2 = nGPA.setCredit(Integer.parseInt(credit_2.getText().toString()));
        nGPA.setCredit(cred2);

        String grade3 = grade_3.getText().toString();
        nGPA.setGrade(grade3);
        int cred3 = nGPA.setCredit(Integer.parseInt(credit_3.getText().toString()));
        nGPA.setCredit(cred3);

        String grade4 = grade_4.getText().toString();
        nGPA.setGrade(grade4);
        int cred4 = nGPA.setCredit(Integer.parseInt(credit_4.getText().toString()));
        nGPA.setCredit(cred4);

        int total_cred = cred1+cred2+cred3+cred4;

        double result = nGPA.calc_gpa()/ total_cred;

        resultGPA.setText("Your GPA is "+ result);
        resultGPA.setText(total_cred);
    }
}
