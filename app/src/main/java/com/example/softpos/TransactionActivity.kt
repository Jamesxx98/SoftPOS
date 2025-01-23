package com.example.softpos
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.nfc.NfcEvent
import android.nfc.Tag
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.softpos.R
import com.google.android.material.button.MaterialButton


class TransactionActivity : AppCompatActivity() {

    private lateinit var nfcAdapter: NfcAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        // Initialize NFC adapter
        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if (nfcAdapter == null) {
            Toast.makeText(this, "NFC is not available on this device", Toast.LENGTH_SHORT).show()
            return
        }

        // Initialize the NFC payment button and other UI components as before
        val btnPay = findViewById<MaterialButton>(R.id.btnPay)
        btnPay.setOnClickListener {
            // Handle NFC payment initiation
            startNfcPayment()
        }
    }

    private fun startNfcPayment() {
        // This would trigger NFC processing when the user taps the button
        // In this case, we are just showing a message that NFC has been started
        Toast.makeText(this, "Initiating NFC payment...", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        // Enable NFC in the activity
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            val tag: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
            // Handle the NFC tag detection and process it
            // processNfcTag(tag)
        }
    }

    override fun onPause() {
        super.onPause()
        // Disable NFC to avoid unnecessary scanning while the activity is paused
    }
}
