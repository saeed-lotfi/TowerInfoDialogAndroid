package com.seedlotfi.towerinfodialogandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seedlotfi.towerinfodialog.TowerDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = TowerDialog.Companion.Builder()
            // set context required
            .setContext(this)
            .setTitle("custom title")
            .setIsSuccess(true)
            .setMessage(" The dialog box ")
            // set title bold default is false
            .setTileIsBold(true)
            .setButtonText("Done")
            .build()

        dialog.show {
            // manage click
        }
    }
}