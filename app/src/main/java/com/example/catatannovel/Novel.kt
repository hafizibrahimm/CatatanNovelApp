package com.example.catatannovel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Novel(
    val name: String,
    val author: String,
    val description: String,
    val photo: String
): Parcelable
