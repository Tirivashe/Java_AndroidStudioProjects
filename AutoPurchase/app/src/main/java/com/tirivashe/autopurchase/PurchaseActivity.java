package com.tirivashe.autopurchase;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class PurchaseActivity extends Activity {
    Auto mAuto;
    String loanReport;
    String monthlyPayment;

    private EditText carPriceET;
    private EditText downPayET;
    private RadioGroup loanTermRG;

    private static final String msg = "Purchase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_layout);

        carPriceET = (EditText) findViewById(R.id.editText1);
        downPayET = (EditText)findViewById(R.id.editText2);
        loanTermRG = (RadioGroup) findViewById(R.id.radioGroup1);

        mAuto = new Auto();
    }

    private void collectAutoInputData(){
        mAuto.setPrice((double) Integer.valueOf(carPriceET.getText().toString()));
        mAuto.setDownPayment((double)Integer.valueOf(downPayET.getText().toString()));

        Integer radioId = loanTermRG.getCheckedRadioButtonId();
        RadioButton term = (RadioButton) findViewById(radioId);
        mAuto.setLoanTerm(term.getText().toString());
    }
    private void buildLoanReport(){
        Resources res = getResources();
        monthlyPayment = res.getString(R.string.report_line_1) + String.format("%.02f",mAuto.monthlyPayent());

        loanReport = res.getString(R.string.report_line_6)+String.format("%10.02f",mAuto.getPrice());
        loanReport += res.getString(R.string.report_line_7)+String.format("%10.02f",mAuto.getDownPayment());
        loanReport += res.getString(R.string.report_line_9)+String.format("%18.02f",mAuto.taxAmount());
        loanReport += res.getString(R.string.report_line_10)+String.format("%18.02f",mAuto.totalCost());
        loanReport += res.getString(R.string.report_line_11)+String.format("%12.02f",mAuto.borrowedAmount());
        loanReport += res.getString(R.string.report_line_12)+String.format("%12.02f",mAuto.interestAmount());

        loanReport += "\n\n" + res.getString(R.string.report_line_8)+ mAuto.getLoanTerm()+"years";
        loanReport += "\n\n" + res.getString(R.string.report_line_2);
        loanReport += "\n\n" + res.getString(R.string.report_line_3);
        loanReport += "\n\n" + res.getString(R.string.report_line_4);
        loanReport += "\n\n" + res.getString(R.string.report_line_5);
    }
    public void activateLoanSummary(View view){
        collectAutoInputData();
        buildLoanReport();

        Intent launchReport = new Intent(this,LoanSummary.class);

        launchReport.putExtra("LoanReport", loanReport);
        launchReport.putExtra("MonthlyPayment", monthlyPayment);

        startActivity(launchReport);
    }
}
