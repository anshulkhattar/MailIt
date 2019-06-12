package com.example.hp.mailit

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


public class AppointActivity : AppCompatActivity() {

    var letter:String="";




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appoint)

        var applicant_name=findViewById<EditText>(R.id.applicant_name)
        var company_name=findViewById<EditText>(R.id.company_name)
        var job_title=findViewById<EditText>(R.id.job_title)
        var joining_date=findViewById<EditText>(R.id.joining_date)
        var submit_button=findViewById<Button>(R.id.submit_button)

        val applicantName:String=applicant_name.text.toString()
        val companyName:String=company_name.text.toString()
        val jobTitle:String=job_title.text.toString()
        val joiningDate:String=joining_date.text.toString()


        val subject="Appointment Letter"
        letter="Dear "+applicantName +"\n"+ "Thank you for accepting and signing the job offer letter. I am pleased to inform you that your employment with "+ companyName+" has been confirmed in the capacity of " + jobTitle + " ."+
                "\nAs agreed, your starting date will be "+ joiningDate+" . Further information governing your employment can be found in the signed contract as well as the Employee Policy document."+
                "\nIf you have further queries about your employment, you may contact me directly or approach the HR department."+
                "\nCongratulations on your appointment and welcome to [Company Name]. We look forward to years of fruitful cooperation and success. We wish you the best of luck in your new post."+
                "\nSincerely,"


        submit_button.setOnClickListener {


            val intent = Intent(Intent.ACTION_SEND).apply {

                putExtra(Intent.EXTRA_EMAIL,"anshul070300@gamil.com")
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, "hello")

                }
            val title ="choose the mailing app"
            val chooser = Intent.createChooser(intent, title)
                if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser)}
            else{
                Toast.makeText(this,"Unable to open intent",Toast.LENGTH_SHORT).show()
            }
        }
    }

}
