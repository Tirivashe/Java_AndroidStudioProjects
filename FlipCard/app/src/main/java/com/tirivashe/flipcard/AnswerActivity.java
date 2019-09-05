package com.tirivashe.flipcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.content.*;
import android.widget.*;

public class AnswerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Button questionbtn = (Button)findViewById(R.id.button);
        questionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showQuestion = new Intent(AnswerActivity.this,QuestionActivity.class);
                startActivity(showQuestion);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        overridePendingTransition(R.anim.answer_out,R.anim.question_in);
    }
}
