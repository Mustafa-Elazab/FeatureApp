package com.example.featureapp.presentation.fragment.credit_book.add_address

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentAddAddressBinding
import com.example.featureapp.utils.changeStatusBarColor


class AddAddressFragment : BaseFragment<FragmentAddAddressBinding>(R.layout.fragment_add_address) {
    override val defineBindingVariables: ((FragmentAddAddressBinding) -> Unit)?
        get() = {binding->
            binding.lifecycleOwner = viewLifecycleOwner
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor(R.color.white)
        binding.appBar.appbarTv.text = resources.getText(R.string.add_address)
        binding.appBar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.apply {
            saveBtn.setOnClickListener {
                findNavController().navigate(R.id.action_addAddressFragment_to_customerFragment)
            }
        }


    }

}