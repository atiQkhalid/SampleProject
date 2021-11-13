package com.example.sampleprojectforrecruitment.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sampleprojectforrecruitment.utils.DialogUtils
import com.example.sampleprojectforrecruitment.views.activities.MainActivity
import com.kaopiz.kprogresshud.KProgressHUD

abstract class BaseFragment : Fragment() {

    protected lateinit var mainActivity: MainActivity
    lateinit var progressDialog: KProgressHUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        progressDialog = DialogUtils.showProgressDialog(mainActivity, cancelable = false)
    }
}