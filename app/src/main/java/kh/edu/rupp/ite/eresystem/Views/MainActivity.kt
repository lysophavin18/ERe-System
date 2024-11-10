package kh.edu.rupp.ite.eresystem.Views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.eresystem.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Hide the ActionBar
        supportActionBar?.hide()

        // Use Handler with the main Looper to delay the transition to HomeActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Create an Intent to start HomeActivity
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            // Optionally, call finish() if you don't want to allow the user to return to MainActivity
            finish()
        }, 3000) // 3 second delay
    }
}
