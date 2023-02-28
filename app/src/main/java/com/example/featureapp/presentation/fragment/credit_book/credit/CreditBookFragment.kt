package com.example.featureapp.presentation.fragment.credit_book.credit

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentCreditBookBinding
import com.example.featureapp.utils.changeStatusBarColor


class CreditBookFragment : BaseFragment<FragmentCreditBookBinding>(R.layout.fragment_credit_book) {


    override val defineBindingVariables: ((FragmentCreditBookBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor(R.color.white)

        binding.addCustomerButton.setOnClickListener {
            findNavController().navigate(R.id.action_creditBookFragment_to_addCustomerFragment)
        }
    }

}