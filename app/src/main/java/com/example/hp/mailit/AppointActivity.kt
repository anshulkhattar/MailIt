package com.example.hp.mailit

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


public class AppointActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appoint)

        var submit_button: Button =findViewById(R.id.submit)
        var date: EditText =findViewById(R.id.date)
        var companyName: EditText =findViewById(R.id.company)
        var designation: EditText =findViewById(R.id.designation)




        submit_button.setOnClickListener {

            var joiningDate:String=date.text.toString()
            var post:String=designation.text.toString()
            var companyname:String=companyName.text.toString()

            var letter:String="I am pleased to inform you that you have been appointed for the role of "+post+". This is an official letter confirming your employment with "+companyname+" starting on "+joiningDate+".\n" +
                    "Your employment is subject to the terms and conditions detailed in the contract document supplied individually with this letter.\n" +
                    "Congratulations and welcome to "+companyname+".\n" +
                    "Sincerely,"


            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, "anshul070300@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Appointment Letter")
                putExtra(Intent.EXTRA_TEXT, letter)
            }
            val title ="choose the mailing app"
            val chooser = Intent.createChooser(intent, title)
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser)}
            else{
                Toast.makeText(this,"Unable to open intent", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
