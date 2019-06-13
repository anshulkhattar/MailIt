package com.example.hp.mailit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ResignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resign)

        var submit_button: Button =findViewById(R.id.submit)
        var date: EditText =findViewById(R.id.date)
        var companyName: EditText =findViewById(R.id.company)
        var recepientName: EditText =findViewById(R.id.recipientname)




        submit_button.setOnClickListener {

            var lastDate:String=date.text.toString()
            var name:String=recepientName.text.toString()
            var companyname:String=companyName.text.toString()

            var letter:String="Dear "+name+",\n" +
                    "\n" +
                    "I’m writing today to give my resignation and let you know that my last day with "+companyname+" will be "+lastDate+".\n" +
                    "\n" +
                    "I’ve enjoyed my time here at the company immensely and will miss working with the team. I’m so grateful to have had the chance to work with you all, and I know the skills I’ve learned over the past five years will serve me well in my new adventure.\n" +
                    "\n" +
                    "Please let me know what I can to do to ease the transition. I’m happy to help train my replacement, and can also provide a quick cheat sheet to the client list for anyone who’s taking over my duties on a temporary basis.\n" +
                    "\n" +
                    "Thanks again for everything.\n" +
                    "\n" +
                    "Best,"


            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, "anshul070300@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Resignation Letter")
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
