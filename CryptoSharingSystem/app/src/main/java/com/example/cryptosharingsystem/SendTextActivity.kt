package com.example.cryptosharingsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_send_text.*
import Information
import android.widget.Toast
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class SendTextActivity : AppCompatActivity() {

    private var url: String = ""
    var request: ServerCommunication = ServerCommunication()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_text)

        url = intent.getStringExtra("url")

        var sendTextButton = findViewById(R.id.sendTextButton) as Button

        sendTextButton!!.setOnClickListener {
            if(url != "") {
                sendText()
            }
        }
    }

    fun sendText()
    {
        println("Sending text")
        var filename: String = fileNameTextbox.text.toString()
        var contents: String = contentsTextbox.text.toString()

        var info: Information = Information(filename, contents)

        val server = ServerCommunication()
        var response : Response? = null
        var responseCode = 0

        val thread = Thread(Runnable {
            try {
                response = server.post(url, info)
                responseCode = response!!.code()


            } catch (e: Throwable) {
                //response = e.message.toString()
                e.printStackTrace()
            }
        })

        thread.start()
        thread.join()

        if(responseCode == 200)
        {
            Toast.makeText(applicationContext, "Success!", Toast.LENGTH_LONG).show()
        }
        else
            Toast.makeText(applicationContext, "Failure!", Toast.LENGTH_LONG).show()
    }
}
