package com.example.kraskrit.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kraskrit.R
import com.example.kraskrit.databinding.FragmentAboutBinding
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment(R.layout.fragment_about) {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater,container,false)
        var view = binding.root
        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webViewAbout.settings.javaScriptEnabled = true
        binding.webViewAbout.loadUrl("http://kraskrit.ru/index.php/design-and-features/svedeniya-ob-obrazovatelnoj-organizatsii/osnovnye-svedeniya")

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}