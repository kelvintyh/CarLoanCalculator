package com.example.android.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{ calculate()}
        findViewById<Button>(R.id.buttonReset).setOnClickListener{ reset()}

    }

    private fun calculate(){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toDouble()
        val downPaymentAmount = findViewById<EditText>(R.id.editTextDownPayment).text.toString().toDouble()
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toDouble()
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate).text.toString().toDouble()
        val carLoan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)
        try {
            val carloan = carPrice - downPaymentAmount
            val _interest = carloan * (interestRate/100)* loanPeriod
            val monthlyrepayment = (carloan + _interest)/ loanPeriod/ 12
            carLoan.text = String.format("%.2f",carloan)
            interest.text = String.format("%.2f",_interest)
            monthlyRepayment.text = String.format("%.2f",monthlyrepayment)
        } catch (nfe: NumberFormatException) {
            // not number
        }
    }

    private fun reset(){
        findViewById<EditText>(R.id.editTextCarPrice).text = null;
        findViewById<EditText>(R.id.editTextDownPayment).text = null;
        findViewById<EditText>(R.id.editTextLoanPeriod).text = null;
        findViewById<EditText>(R.id.editTextInterestRate).text = null;
        findViewById<TextView>(R.id.textViewLoan).text = null;
        findViewById<TextView>(R.id.textViewInterest).text = null;
        findViewById<TextView>(R.id.textViewMonthlyRepayment).text = null;
    }




}
