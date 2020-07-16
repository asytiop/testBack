package io.symbyoz.testback.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseException
import com.parse.ParseObject
import io.symbyoz.testback.R
import io.symbyoz.testback.model.UserData

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var userData: ParseObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            sendData { isConfirmed ->

                if(isConfirmed) {
                    Log.d("Sent", "Yes")
                } else {
                    Log.d("Sent", "No")
                }

            }
        }
    }

    private fun sendData(listener: (isConfirmed: Boolean) -> Unit)
    {
        val entity = UserData()

        entity.id = "198329872983782"
        entity.username = "Test test"
        entity.media_count = "42"

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!
        entity.saveInBackground {exception: ParseException? ->

            if(exception == null)
            {
                listener(true)
            }
            else
            {
                listener(false)
            }
        }

    }
}