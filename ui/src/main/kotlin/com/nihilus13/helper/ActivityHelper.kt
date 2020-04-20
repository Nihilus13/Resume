package com.nihilus13.helper

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.nihilus13.resume.R

fun Fragment.startActivitySafely(intent: Intent) =
    try {
        startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
        showErrorSnackbar(this.requireActivity(), getString(R.string.error_no_activity) + intent.action)
    }

fun showErrorSnackbar(activity: Activity, message: String) =
    Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        .show()