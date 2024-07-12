package com.danstestapp.model

import com.danstestapp.api.ApiClient
import com.danstestapp.api.JobsApi
import com.danstestapp.data.JobResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.danstestapp.utils.Result

class JobRepository {
    private val jobsApi: JobsApi = ApiClient.retrofit.create(JobsApi::class.java)

    suspend fun getJobs(): Result<List<JobResponse>> = withContext(Dispatchers.IO) {
        try {
            val jobs = jobsApi.getJobs()
            Result.Success(jobs)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getJobDetail(id: String): Result<JobResponse> = withContext(Dispatchers.IO) {
        try {
            val jobs = jobsApi.getJobs()
            val job = jobs.find { it.id == id }
            if (job != null) {
                Result.Success(job)
            } else {
                Result.Error(Exception("Job not found"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}