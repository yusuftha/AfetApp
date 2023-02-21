package com.moonsoft.afetapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityButtons()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.deprem_frame, MyFragment(), "MyFragment")
        transaction.commit()

    }

    fun activityButtons() {
        val toplanmaBtn = findViewById<Button>(R.id.btn_toplanma)
        val kanBtn = findViewById<Button>(R.id.btn_kan)
        val bagisBtn = findViewById<Button>(R.id.btn_bagis)
        toplanmaBtn.setOnClickListener {
            val url =
                "https://www.turkiye.gov.tr/afet-ve-acil-durum-yonetimi-acil-toplanma-alani-sorgulama"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        kanBtn.setOnClickListener {
            val url = "https://www.turkiye.gov.tr/turk-kizilay-en-yakin-kan-bagis-merkezi"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        bagisBtn.setOnClickListener {
            val intent = Intent(this, BagisAdresActivity::class.java)
            startActivity(intent)
        }
    }

}
