package com.example.sampleprojectforrecruitment.views.activities

import android.os.Bundle
import com.example.sampleprojectforrecruitment.base.BaseActivity
import com.example.sampleprojectforrecruitment.databinding.ActivityMainBinding
import com.example.sampleprojectforrecruitment.extenssions.replaceFragmentSafely
import com.example.sampleprojectforrecruitment.views.fragments.countrylist.CountryListFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        replaceFragmentSafely(CountryListFragment())

    }
}