package com.example.featureapp.presentation.fragment.more.business

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentBusinessCardBinding
import com.example.featureapp.utils.changeStatusBarColor


class BusinessCardFragment :
    BaseFragment<FragmentBusinessCardBinding>(R.layout.fragment_business_card) {
    override val defineBindingVariables: ((FragmentBusinessCardBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor(R.color.white)
        binding.appBar.appbarTv.text = resources.getText(R.string.add_address)
        binding.appBar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }


        binding.saveBtn.setOnClickListener {
            findNavController().navigate(R.id.action_businessCardFragment_to_showBusinessCardFragment)
        }
    }

}