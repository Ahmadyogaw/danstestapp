package com.danstestapp.data

data class JobResponse (
    val id: String,
    val type: String,
    val url: String,
    val createdAt: String,
    val company: String,
    val companyURL: String,
    val location: String,
    val title: String,
    val description: String,
    val howToApply: String,
    val companyLogo: String
)
