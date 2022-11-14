package com.krutsav.ageinminutes

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSelectDate.setOnClickListener { view ->
            clickDatePicker(view)
//            Toast.makeText(this, "Button hehe", Toast.LENGTH_LONG).show()
        }
    }
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance() //Calendar.getInstance() was to make myCalendar Date type
        var year = myCalendar.get(Calendar.YEAR) //get(Calendar.YEAR) will give current year
        val month = myCalendar.get(Calendar.MONTH) //Calendar.MONTH will give current month
        val day = myCalendar.get(Calendar.DAY_OF_MONTH) //
        //year, month and day will be the initial year, month and day in picker
//        val todaydate = "${day}/${month+1}/${year}"
//        Toast.makeText(this, todaydate, Toast.LENGTH_LONG).show()

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {view, mYear, mMonth, dayOfMonth ->
            //code after selection here
            val selectedDate = "${dayOfMonth}/${mMonth+1}/${mYear}"
//            Toast.makeText(this, selectedDate, Toast.LENGTH_LONG).show()
            tvSelectedDate.text = selectedDate;
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val finalDate = sdf.parse(selectedDate)
            //Toast.makeText(this, finalDate, Toast.LENGTH_LONG).show()
            val selectedDateInMinutes = finalDate!!.time /60000;
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time/60000
            val difference =  currentDateInMinutes - selectedDateInMinutes;
            tvAgeInMinutes.text = difference.toString()


        },year,month,day).show()
    }
}