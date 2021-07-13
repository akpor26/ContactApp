package com.kenneth.contactdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kenneth.contactdetails.databinding.ActivityProfileBinding

lateinit var binding: ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileName.text = intent.getStringExtra("name")
        binding.profilePhoneNumber.text = intent.getStringExtra("phoneNumber")
        //val profileName = intent.getStringExtra("name")
    }
}