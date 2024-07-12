package com.danstestapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.danstestapp.view.activity.HomeActivity
import com.danstestapp.view.activity.LoginActivity
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.auth


class MainActivity : AppCompatActivity() {

    private lateinit var loadingIndicator: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
        loadingIndicator = findViewById(R.id.loadingIndicator)

        showLoading()

        Firebase.auth.addAuthStateListener { auth ->
            if (auth.currentUser != null) {
                hideLoading()
                navigateToHome()
            } else {
                hideLoading()
                navigateToLogin()
            }
        }
    }

    private fun showLoading() {
        loadingIndicator.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        loadingIndicator.visibility = View.GONE
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}