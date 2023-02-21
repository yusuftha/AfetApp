package com.moonsoft.afetapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BagisAdresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bagis_adres)

        val btnAfad = findViewById<Button>(R.id.btn_afad)
        btnAfad.setOnClickListener {
            val url =
                "https://www.afad.gov.tr/depremkampanyasi2"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val btnAhbap = findViewById<Button>(R.id.btn_ahbap)
        btnAhbap.setOnClickListener {
            val url =
                "https://ahbap.org/bagisci-ol"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Bağış Adresleri"
    }
}


