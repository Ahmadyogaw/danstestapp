package com.danstestapp.view.activity

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.danstestapp.databinding.ActivityJobDetailBinding
import com.danstestapp.viewmodel.JobDetailViewModel

class JobDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJobDetailBinding
    private lateinit var viewModel: JobDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[JobDetailViewModel::class.java]

        // Enable the Up button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set the title for the action bar
        supportActionBar?.title = "Job Details"

        val jobId = intent.getStringExtra("jobId")
        jobId?.let {
            viewModel.loadJob(it)
        }

        viewModel.job.observe(this) { job ->
            binding.apply {
                titleTextView.text = job.title
                companyTextView.text = job.company
                locationTextView.text = job.location
                typeTextView.text = job.type

                // Handle HTML in description
                descriptionTextView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(job.description, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(job.description)
                }

                howToApplyTextView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(job.howToApply, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(job.howToApply)
                }
            }
        }
    }

    // Handle Up button in the action bar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}