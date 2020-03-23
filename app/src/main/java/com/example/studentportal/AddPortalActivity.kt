package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_portal.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a Portal"

        btnAddPortal.setOnClickListener { onAddPortalClick() }
    }

    private fun onAddPortalClick() {
        if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
            val portal = Portal(etTitle.text.toString(), etUrl.text.toString())
            val resultIntent = Intent()

            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
    }
}