package com.tirivashe.autopurchase;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class LoanSummary extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loansummary);

        TextView monthlyPaymentET = (TextView) findViewById(R.id.textView2);
        TextView loanReportET = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();

        String report;
        report = intent.getStringExtra("LoanReport");

        String monthlyPay;
        monthlyPay = intent.getStringExtra("MonthlyPayment");
        monthlyPaymentET.setText(monthlyPay);
        loanReportET.setText(report);
    }
    public void goDataEntry(View view){
        finish();
    }
}
