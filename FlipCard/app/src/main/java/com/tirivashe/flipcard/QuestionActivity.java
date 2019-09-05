package com.tirivashe.flipcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.content.*;
import android.widget.*;
import android.animation.*;
import android.transition.*;
import android.R.anim.*;

public class QuestionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Button answerbtn = (Button)findViewById(R.id.button);
        answerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showAnswer = new Intent(QuestionActivity.this,AnswerActivity.class);
                startActivity(showAnswer);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        overridePendingTransition(R.anim.question_out,R.anim.answer_in);
    }
}
