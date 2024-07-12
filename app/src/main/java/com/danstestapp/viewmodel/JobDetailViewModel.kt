package com.danstestapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danstestapp.data.JobResponse
import com.danstestapp.model.JobRepository
import kotlinx.coroutines.launch
import com.danstestapp.utils.Result

class JobDetailViewModel(private val jobRepository: JobRepository = JobRepository()) : ViewModel() {

    private val _job = MutableLiveData<JobResponse>()
    val job: LiveData<JobResponse> = _job

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadJob(jobId: String) {
        viewModelScope.launch {
            when (val result = jobRepository.getJobDetail(jobId)) {
                is Result.Success -> {
                    _job.value = result.data
                }
                is Result.Error -> {
                    _error.value = result.exception.message ?: "An unknown error occurred"
                    Log.e("JobDetailViewModel", "Error loading job", result.exception)
                }
            }
        }
    }
}