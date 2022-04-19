package com.inhale.chapter5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.snackbar.Snackbar
import com.inhale.chapter5.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var myChoice: String = ""
    private var comChoice: String = ""

    private var cardview4: CardView? = null
    private var cardview5: CardView? = null
    private var cardview6: CardView? = null
    private var tvTengah: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonRetry = findViewById<Button>(R.id.button1)

        val cardview1 = findViewById<CardView>(R.id.cardimage1)
        val cardview2 = findViewById<CardView>(R.id.cardimage2)
        val cardview3 = findViewById<CardView>(R.id.cardimage3)

        cardview4 = findViewById(R.id.cardimage4)
        cardview5 = findViewById(R.id.cardimage5)
        cardview6 = findViewById(R.id.cardimage6)
        tvTengah = findViewById(R.id.txtVs)

        fun backgroundT () {
            cardview1.setCardBackgroundColor(Color.TRANSPARENT)
            cardview2.setCardBackgroundColor(Color.TRANSPARENT)
            cardview3.setCardBackgroundColor(Color.TRANSPARENT)
            cardview4?.setCardBackgroundColor(Color.TRANSPARENT)
            cardview5?.setCardBackgroundColor(Color.TRANSPARENT)
            cardview6?.setCardBackgroundColor(Color.TRANSPARENT)
            tvTengah?.text = getString(R.string.titlevs)
            tvTengah?.setBackgroundColor(Color.TRANSPARENT)
        }

        fun retryButton(): Boolean {
            var flag = true
            if (cardview1.cardBackgroundColor.isOpaque || cardview2.cardBackgroundColor.isOpaque || cardview3.cardBackgroundColor.isOpaque) flag =
                false
            return flag
        }

        backgroundT()

        cardview1.setOnClickListener {
            if (retryButton()) {
                backgroundT();cardview1.setCardBackgroundColor(Color.parseColor("#c3dae9"));myChoice =
                    "gunting";Log.d("Player Memilih:", "Gunting");hasil()
            }
        }

        cardview2.setOnClickListener {
            if (retryButton()) {
                backgroundT();cardview2.setCardBackgroundColor(Color.parseColor("#c3dae9"));myChoice =
                    "kertas";Log.d("Player Memilih:", "Kertas");hasil()
            }
        }

        cardview3.setOnClickListener {
            if (retryButton()) {
                backgroundT(); cardview3.setCardBackgroundColor(Color.parseColor("#c3dae9"));myChoice =
                    "batu";Log.d("Player Memilih:", "Batu");hasil()
            }
        }

        buttonRetry.setOnClickListener { backgroundT() }

    }

    private fun hasil() {
        val cpu = (1..3).random()
        if (cpu == 1) {
            comChoice = "gunting";cardview4?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        if (cpu == 2) {
            comChoice = "kertas";cardview5?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        if (cpu == 3) {
            comChoice = "batu";cardview6?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        when (myChoice) {
            comChoice -> {
                tvTengah?.text = getString(R.string.hasilDraw);Log.d("Hasil Permainan:", "Draw")
            }
            "gunting" -> {
                when (comChoice) {
                    "kertas" -> {
                        tvTengah?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );tvTengah?.setBackgroundColor(Color.GREEN)
                    }
                    "batu" -> {
                        tvTengah?.text = getString(R.string.player2Menang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );tvTengah?.setBackgroundColor(Color.BLUE)
                    }
                }
            }
            "kertas" -> {
                when (comChoice) {
                    "batu" -> {
                        tvTengah?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );tvTengah?.setBackgroundColor(Color.GREEN)
                    }
                    "gunting" -> {
                        tvTengah?.text = getString(R.string.player2Menang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );tvTengah?.setBackgroundColor(Color.BLUE)
                    }
                }
            }
            "batu" -> {
                when (comChoice) {
                    "gunting" -> {
                        tvTengah?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );tvTengah?.setBackgroundColor(Color.GREEN)
                    }
                    "kertas" -> {
                        tvTengah?.text = getString(R.string.player2Menang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );tvTengah?.setBackgroundColor(Color.BLUE)
                    }
                }
            }
        }
    }


}