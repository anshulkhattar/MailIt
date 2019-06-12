package com.example.hp.mailit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val interview_button=findViewById(R.id.interview) as Button;
        val resign_button=findViewById<Button>(R.id.resign);
        val leave_button=findViewById<Button>(R.id.leave);
        val appoint_button=findViewById<Button>(R.id.appoint);

        interview_button.setOnClickListener{
            val intent = Intent(this, InterviewActivity::class.java);
            startActivity(intent);
        }

        resign_button.setOnClickListener {
            val intent = Intent(this, ResignActivity::class.java);
            startActivity(intent);
        }
        appoint_button.setOnClickListener {
            val intent = Intent(this, AppointActivity::class.java);
            startActivity(intent);
        }
        leave_button.setOnClickListener {
            val intent = Intent(this, LeaveActivity::class.java);
            startActivity(intent);
        }
    }
}
