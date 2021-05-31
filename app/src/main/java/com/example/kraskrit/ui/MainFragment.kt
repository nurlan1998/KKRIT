package com.example.kraskrit.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kraskrit.R
import com.example.kraskrit.adapters.MainAdapter
import com.example.kraskrit.data.models.MainData
import com.example.kraskrit.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = MainAdapter()
        binding.rvView.adapter = adapter

        var datas = mutableListOf<MainData>()

        for(i in 0..5){
            if(i == 0){
                val data = MainData(i,"О колледже","iv_about_college")
                datas.add(data)
            }
            if(i == 1){
                val data = MainData(i,"Новости","iv_news_college")
                datas.add(data)
            }
            if(i == 2){
                val data = MainData(i,"Персонал и руководство","iv_staff_leadership")
                datas.add(data)
            }
            if(i == 3){
                val data = MainData(i,"Меню","iv_menu_college")
                datas.add(data)
            }
            if(i == 4){
                val data = MainData(i,"Расписание","iv_schedule")
                datas.add(data)
            }
            if(i == 5){
                val data = MainData(i,"Поделиться приложением","iv_share_app")
                datas.add(data)
            }
        }
        adapter.model = datas

        adapter.setItemClick {
            when (it.id) {
                0 -> {
                    findNavController().navigate(R.id.action_mainFragment_to_aboutFragment2)
                }
                1 -> {
                    findNavController().navigate(R.id.action_mainFragment_to_newsFragment2)
                }
                2 -> {
                    findNavController().navigate(R.id.action_mainFragment_to_staffLeadershipFragment)
                }
                3 -> {
                    findNavController().navigate(R.id.action_mainFragment_to_menuFragment)
                }
                4 -> {
                    findNavController().navigate(R.id.action_mainFragment_to_scheduleFragment)
                }
                5 -> {
                    val intent= Intent()
                    intent.action=Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,"Hey Check out this Great app:")
                    intent.type="text/plain"
                    startActivity(Intent.createChooser(intent,"Поделиться приложением:"))
                }
            }
        }
    }
}