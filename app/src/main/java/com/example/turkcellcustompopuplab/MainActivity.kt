package com.example.turkcellcustompopuplab

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    }

    fun devamEt() {
        Toast.makeText(this, "Devam Ediyor", Toast.LENGTH_SHORT).show()
    }

    fun popupGoster(baslik: String, mesaj: String, evetAction: () -> Unit) {
        val inflater = getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.popup_uyari, null)
        val popUyari =
            PopupWindow(v, windowManager.defaultDisplay.width, windowManager.defaultDisplay.height)

        popUyari.showAtLocation(v, Gravity.CENTER, 0, 0)

        val tvBaslik = v.findViewById<TextView>(R.id.baslik)
        val tvMesaj = v.findViewById<TextView>(R.id.mesaj)
        val butonHayir = v.findViewById<Button>(R.id.buttonHayir)
        val butonEvet = v.findViewById<Button>(R.id.buttonEvet)

        tvBaslik.text = baslik
        tvMesaj.text = mesaj

        butonHayir.setOnClickListener {
            Toast.makeText(this, "Durdu", Toast.LENGTH_SHORT).show()
            popUyari.dismiss()
        }
        butonEvet.setOnClickListener {
            evetAction()
            popUyari.dismiss()
        }
    }

    fun uyariGoster(view: View) {
        popupGoster("Uyarı", "Uyari Mesajı Gösteriliyor", ::devamEt)
    }
}