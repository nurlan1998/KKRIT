package com.example.kraskrit.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kraskrit.R
import com.example.kraskrit.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private var _binding:FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScheduleBinding.inflate(inflater,container,false)
        var view = binding.root
        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webViewSchedule.settings.javaScriptEnabled = true
        binding.webViewSchedule.loadUrl("https://disk.yandex.uz/d/0vmvyzN6Yfd43A")

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}