package com.example.featureapp.presentation.fragment.credit_book.add_customer

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentAddCustomerBinding
import com.example.featureapp.utils.changeStatusBarColor


class AddCustomerFragment :
    BaseFragment<FragmentAddCustomerBinding>(R.layout.fragment_add_customer) {

    override val defineBindingVariables: ((FragmentAddCustomerBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor(R.color.white)
        binding.appBar.appbarTv.text = resources.getText(R.string.add_customer)
        binding.appBar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.apply {
            etAddress.setOnClickListener {
                findNavController().navigate(R.id.action_addCustomerFragment_to_addAddressFragment)
            }
            saveBtn.setOnClickListener {
                findNavController().navigate(R.id.action_addCustomerFragment_to_customerFragment)
            }
        }


    }

}
