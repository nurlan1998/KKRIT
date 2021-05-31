package com.example.kraskrit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.kraskrit.databinding.FragmentFullPhotoBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FullPhotoFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFullPhotoBinding? = null

    private val binding get() = _binding!!

    private val shareViewModel: ShareViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFullPhotoBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shareViewModel.dataToShare.observe(viewLifecycleOwner, Observer {
            Glide.with(requireContext()).load(getImage(it)).optionalCenterCrop().into(binding.ivDetail)
        })
    }
    fun getImage(imageName: String?): Int {
        return resources.getIdentifier(imageName, "drawable", requireContext().packageName)
    }
}