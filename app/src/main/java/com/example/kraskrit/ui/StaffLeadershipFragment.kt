package com.example.kraskrit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.kraskrit.R
import com.example.kraskrit.adapters.MainAdapter
import com.example.kraskrit.data.models.MainData
import com.example.kraskrit.databinding.FragmentStaffLeadershipBinding
import kotlinx.android.synthetic.main.fragment_staff_leadership.*

class StaffLeadershipFragment : Fragment(R.layout.fragment_staff_leadership) {

    private var _binding: FragmentStaffLeadershipBinding? = null

    private val binding get() = _binding!!

    private val shareViewModel: ShareViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStaffLeadershipBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var adapter = MainAdapter()
        binding.rvLeadership.adapter = adapter

        var datas = mutableListOf<MainData>()

        for(i in 0..4){
            if(i == 0){
                val data = MainData(i,"Алина Зуева","iv_alina_zueva","МДК 02.01 Разработка, внедрение и адаптация ПО отраслевой направленности")
                datas.add(data)
            }
            if(i == 1){
                val data = MainData(i,"Алла Кетрова","iv_alla","Методы оптимизации")
                datas.add(data)
            }
            if(i == 2){
                val data = MainData(i,"Антон Татарников","iv_anton","Основы алгоритмизации и программирования")
                datas.add(data)
            }
            if(i == 3){
                val data = MainData(i,"Татьяна Панарина","iv_tatyana","Компьютерная графика")
                datas.add(data)
            }
            if(i == 4){
                val data = MainData(i,"Дарья Тятенкова","iv_darya"," МДК 03.01. Сопровождение и продвижение ПО отраслевой направленности")
                datas.add(data)
            }
        }
        adapter.model = datas



        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        adapter.setItemClick {
            shareViewModel.updateData(it.imageName)
            findNavController().navigate(R.id.action_staffLeadershipFragment_to_fullPhotoFragment)
        }
    }
}