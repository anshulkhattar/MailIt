package com.example.hp.mailit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InterviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview)

        var submit_button: Button =findViewById(R.id.submit)
        var date: EditText =findViewById(R.id.date)
        var applicantName: EditText =findViewById(R.id.applicantname)
        var post: EditText =findViewById(R.id.designation)



        submit_button.setOnClickListener {

            var joiningDate:String=date.text.toString()
            var applicName:String=applicantName.text.toString()
            var designation:String=post.text.toString()
            var letter:String="Dear "+ applicName+",\n" +
                    " \n" +
                    " \n" +
                    "\n" +
                    "I am writing this letter regarding your application for the position of "+designation+" in our company.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "We would like to inform you that you are the one from ten candidates who is selected for the interview in our firm. The interview will take place on "+ joiningDate +". Please, review the attached schedule for more details. We believe that you are one of the most qualified people for this position and wish you best of luck.\n" +
                    " \n" +
                    "\n" +
                    "Please, be in the Hall of our office half hour before the interview starts since you might require some time in order to find the place. Please be on time.\n" +
                    " \n" +
                    "\n" +
                    "Congratulations again and we are looking forward to seeing you at the interview.\n" +
                    " \n" +
                    "All the best."


            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, "anshul070300@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Call for interview")
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
