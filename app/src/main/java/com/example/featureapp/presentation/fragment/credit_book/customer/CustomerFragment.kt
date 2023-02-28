package com.example.featureapp.presentation.fragment.credit_book.customer

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentCustomerBinding
import com.example.featureapp.utils.changeStatusBarColor


class CustomerFragment : BaseFragment<FragmentCustomerBinding>(R.layout.fragment_customer) {


    override val defineBindingVariables: ((FragmentCustomerBinding) -> Unit)?
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
            iGotBtn.setOnClickListener {
                val nav = CustomerFragmentDirections.actionCustomerFragmentToOperationCreditFragment(isGot = true)
                findNavController().navigate(nav)
            }

            iGaveBtn.setOnClickListener {
                val nav = CustomerFragmentDirections.actionCustomerFragmentToOperationCreditFragment(isGot = false)
                findNavController().navigate(nav)
            }
        }


    }
}