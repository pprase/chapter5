package com.inhale.chapter5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inhale.chapter5.databinding.FragmentLanding1Binding

class FragmentLanding1 : Fragment() {
    private lateinit var binding: FragmentLanding1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanding1Binding.inflate(inflater, container, false)
        return binding.root
    }
}