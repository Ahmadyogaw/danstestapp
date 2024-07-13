package com.danstestapp.data

import com.danstestapp.utils.Endpoints
import retrofit2.http.GET

interface JobsApi {
    @GET(Endpoints.JOBS_ENDPOINT)
    suspend fun getJobs(): List<JobResponse>
}
