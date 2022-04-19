package com.inhale.chapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class FragmentLanding3 : Fragment (){
    var txtNama: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_landing3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt = view.findViewById<EditText>(R.id.txtName)
        val btn = view.findViewById<ImageView>(R.id.btnNext)
        btn.setOnClickListener { viewnew ->
            navigateToHome(txt.text.toString())
        }
    }

    private fun navigateToHome(nama: String) {
        if (nama.trim() == "" || nama == null) {

            val snackbar = Snackbar.make(view!!.rootView, "Isikan nama dulu", Snackbar.LENGTH_SHORT)
            snackbar.show()
            return
        }
        val intent = Intent(Intent(context, HomeActivity::class.java)).apply {
            putExtra("nama", nama)
        }
        startActivity(intent)
    }

}