package com.example.kraskrit.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kraskrit.R
import com.example.kraskrit.databinding.FragmentNewsBinding
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(R.layout.fragment_news) {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater,container,false)
        var view = binding.root
        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webViewNews.settings.javaScriptEnabled = true
        binding.webViewNews.loadUrl("http://kraskrit.ru/index.php/2012-11-23-08-17-17")

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}