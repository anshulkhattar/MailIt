package com.example.hp.mailit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LeaveActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave)

        var submit_button: Button =findViewById(R.id.submit)
        var daysNum:EditText=findViewById(R.id.days)



        submit_button.setOnClickListener {

            var days:String=daysNum.text.toString()
            var letter:String="Respected Sir/Madam, "+"\n"+"I am writing this application to notify you that I am suffering from severe viral infection and therefore, I need sick leave from work. I caught this infection last night and I will not be able to come to the office for at least "+ days + " days. As notified by my doctor, it is best that I take rest and recover properly before resuming work. The letter from the doctor is also attached for your reference.\n" +
                    "Kindly grant me a leave for " + days +" days. I will be available on phone in case of any priority or urgent cases. Please contact me as per your convenience.\n" +
                    "I hope you will understand and grant me a leave for aforementioned period. Waiting your approval."


            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, "anshul070300@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Sick Leave Application")
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
