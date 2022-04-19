package com.inhale.chapter5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.inhale.chapter5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var myChoice: String = ""
    private var comChoice: String = ""
    private var lawan: String = ""


    private var cardview1: CardView? = null
    private var cardview2: CardView? = null
    private var cardview3: CardView? = null
    private var cardview4: CardView? = null
    private var cardview5: CardView? = null
    private var cardview6: CardView? = null
    private var tvTengahX: TextView? = null

    private val mode by lazy {
        intent.getBooleanExtra("mode",false)
    }

    private val name by lazy {
        intent.getStringExtra("nama")
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (mode)lawan = "Player 2";else lawan =  "COM"
        binding.run {

            txtPemain1.text = name
            tvPemain2.text = lawan
            cardview1 = cardimage1
            cardview2 = cardimage2
            cardview3 = cardimage3
            cardview4 = cardimage4
            cardview5 = cardimage5
            cardview6 = cardimage6
            tvTengahX = txtVs

            cardimage1.setOnClickListener {
                if (retryButton()) {
                    backgroundT();cardimage1.setCardBackgroundColor(Color.parseColor("#c3dae9"));myChoice =
                        "gunting";Log.d("Player Memilih:", "Gunting")
                    if (!mode) hasil(0)
                }
            }

            cardimage2.setOnClickListener {
                if (retryButton()) {
                    backgroundT();cardimage2.setCardBackgroundColor(Color.parseColor("#c3dae9"));myChoice =
                        "kertas";Log.d("Player Memilih:", "Kertas")
                    if (!mode) hasil(0)
                }
            }

            cardimage3.setOnClickListener {

                if (retryButton()) {
                    backgroundT(); cardimage3.setCardBackgroundColor(Color.parseColor("#c3dae9"));myChoice =
                        "batu";Log.d("Player Memilih:", "Batu")
                    if (!mode) hasil(0)
                }


            }

            cardimage4.setOnClickListener {
                if (retryButton2() && mode && myChoice != "") {
                    cardimage4.setCardBackgroundColor(Color.parseColor("#c3dae9"))
                    Log.d("Player 2 Memilih:", "Gunting");hasil(1)
                }
            }

            cardimage5.setOnClickListener {
                if (retryButton2() && mode && myChoice != "") {
                    cardimage5.setCardBackgroundColor(Color.parseColor("#c3dae9"))
                    Log.d("Player 2 Memilih:", "Kertas");hasil(2)
                }
            }

            cardimage6.setOnClickListener {

                if (retryButton2() && mode && myChoice != "") {
                    cardimage6.setCardBackgroundColor(Color.parseColor("#c3dae9"))
                    Log.d("Player 2 Memilih:", "Batu");hasil(3)
                }


            }

            button1.setOnClickListener { backgroundT() }
            btnClose.setOnClickListener { finishAffinity() }
        }
        backgroundT()
    }

    fun backgroundT() {
        cardview1?.setCardBackgroundColor(Color.TRANSPARENT)
        cardview2?.setCardBackgroundColor(Color.TRANSPARENT)
        cardview3?.setCardBackgroundColor(Color.TRANSPARENT)
        cardview4?.setCardBackgroundColor(Color.TRANSPARENT)
        cardview5?.setCardBackgroundColor(Color.TRANSPARENT)
        cardview6?.setCardBackgroundColor(Color.TRANSPARENT)
        tvTengahX?.text = getString(R.string.titlevs)
        tvTengahX?.setBackgroundColor(Color.TRANSPARENT)
        myChoice = ""
    }


    fun retryButton(): Boolean {
        var flag = true
        if (cardview1!!.cardBackgroundColor.isOpaque || cardview2!!.cardBackgroundColor.isOpaque || cardview3!!.cardBackgroundColor.isOpaque) flag =
            false
        return flag
    }
    fun retryButton2(): Boolean {
        var flag = true
        if (cardview4!!.cardBackgroundColor.isOpaque || cardview5!!.cardBackgroundColor.isOpaque || cardview6!!.cardBackgroundColor.isOpaque) flag =
            false
        return flag
    }

    private fun hasil(cpuX:Int) {
        var cpu:Int = cpuX
        if (!mode) cpu = (1..3).random()

        if (cpu == 1) {
            comChoice = "gunting";cardview4?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        if (cpu == 2) {
            comChoice = "kertas";cardview5?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        if (cpu == 3) {
            comChoice = "batu";cardview6?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        Toast.makeText(this,"$lawan memilih $comChoice", Toast.LENGTH_SHORT).show()
        when (myChoice) {
            comChoice -> {
                tvTengahX?.text = getString(R.string.hasilDraw);Log.d("Hasil Permainan:", "Draw");dialog("Seri")
            }
            "gunting" -> {
                when (comChoice) {
                    "kertas" -> {
                        tvTengahX?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );tvTengahX?.setBackgroundColor(Color.GREEN);dialog("$name Menang!")
                    }
                    "batu" -> {
                        tvTengahX?.text = getString(R.string.player2Menang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );tvTengahX?.setBackgroundColor(Color.BLUE);dialog("$lawan Menang!")
                    }
                }
            }
            "kertas" -> {
                when (comChoice) {
                    "batu" -> {
                        tvTengahX?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );tvTengahX?.setBackgroundColor(Color.GREEN);dialog("$name Menang!")
                    }
                    "gunting" -> {
                        tvTengahX?.text = getString(R.string.player2Menang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );tvTengahX?.setBackgroundColor(Color.BLUE);dialog("$lawan Menang!")
                    }
                }
            }
            "batu" -> {
                when (comChoice) {
                    "gunting" -> {
                        tvTengahX?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );tvTengahX?.setBackgroundColor(Color.GREEN);dialog("$name Menang!")
                    }
                    "kertas" -> {
                        tvTengahX?.text = getString(R.string.player2Menang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );tvTengahX?.setBackgroundColor(Color.BLUE);dialog("$lawan Menang!")
                    }
                }
            }
        }
    }

    fun dialog(hasil:String){

        val viewdialog = LayoutInflater.from(this@MainActivity).inflate(androidx.core.R.layout.custom_dialog,null,true)
        val dialogBuilder = AlertDialog.Builder(this@MainActivity)
        dialogBuilder.setView(viewdialog)
        dialogBuilder.setCancelable(false)

        viewdialog.findViewById<TextView>(R.id.btnNext).text = hasil
        val dialog = dialogBuilder.create()
        dialog.show()
        viewdialog.findViewById<Button>(R.id.btnClose).setOnClickListener {
            dialog.dismiss()
            backgroundT()
        }
        viewdialog.findViewById<Button>(R.id.btnClose).setOnClickListener {
            finish()
        }
    }



}