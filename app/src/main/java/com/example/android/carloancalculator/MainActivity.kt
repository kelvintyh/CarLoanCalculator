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

        findViewById<Button>(R.id.calculate_button).setOnClickListener{
            calculate(it)
        }
    }

    private fun calculate(view: View){
        val carPrice = findViewById<EditText>(R.id.car_price_editText).text.toString().toDouble()
        val downPaymentAmount = findViewById<EditText>(R.id.down_payment_amount_editText).text.toString().toDouble()
        val loanPeriod = findViewById<EditText>(R.id.loan_period_editText).text.toString().toDouble()
        val interestRate = findViewById<EditText>(R.id.interest_rate_editText).text.toString().toDouble()
        val carLoan = findViewById<TextView>(R.id.car_loan_view)
        val interest = findViewById<TextView>(R.id.interest_view)
        val monthlyRepayment = findViewById<TextView>(R.id.monthly_repayment_view)
        try {
            val carloan = carPrice - downPaymentAmount
            val _interest = carloan * interestRate* loanPeriod
            val monthlyrepayment = (carloan + _interest)/ loanPeriod/ 12
            carLoan.text = String.format("%.2f",carloan)
            interest.text = String.format("%.2f",_interest)
            monthlyRepayment.text = String.format("%.2f",monthlyrepayment)
        } catch (nfe: NumberFormatException) {
            carLoan.text = "hahaha"
        }
    }




}
