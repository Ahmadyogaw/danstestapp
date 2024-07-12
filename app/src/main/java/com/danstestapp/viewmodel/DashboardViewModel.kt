package com.danstestapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.danstestapp.data.JobResponse
import com.danstestapp.model.JobRepository
import kotlinx.coroutines.launch
import com.danstestapp.utils.Result

class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private val jobRepository = JobRepository()

    private val _jobs = MutableLiveData<List<JobResponse>>()
    val jobs: LiveData<List<JobResponse>> = _jobs

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchJobs()
    }

    private fun fetchJobs() {
        viewModelScope.launch {
            _isLoading.value = true
            when (val result = jobRepository.getJobs()) {
                is Result.Success -> {
                    _jobs.value = result.data
                    Log.d("DashboardViewModel", "Fetched ${result.data.size} jobs")
                }
                is Result.Error -> {
                    _error.value = result.exception.message ?: "An unknown error occurred"
                    Log.e("DashboardViewModel", "Error fetching jobs", result.exception)
                }
            }
            _isLoading.value = false
        }
    }

    fun retryFetchJobs() {
        fetchJobs()
    }
}