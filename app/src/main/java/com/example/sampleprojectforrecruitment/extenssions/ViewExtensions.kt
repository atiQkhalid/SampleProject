package com.example.sampleprojectforrecruitment.extenssions

import android.widget.Toast
import com.example.sampleprojectforrecruitment.App

/**
 * Extension function to show toast message
 */
fun Any.showToastMsg(message: String) {
    Toast.makeText(App.getAppContext(), message, Toast.LENGTH_SHORT).show()
}