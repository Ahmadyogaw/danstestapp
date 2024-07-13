package com.danstestapp.data

import com.google.gson.annotations.SerializedName

data class JobResponse (
    val id: String,
    val type: String,
    val url: String,
    @SerializedName("created_at") val createdAt: String,
    val company: String,
    @SerializedName("company_url") val companyURL: String,
    val location: String,
    val title: String,
    val description: String,
    @SerializedName("how_to_apply") val howToApply: String,
    @SerializedName("company_logo") val companyLogo: String
)