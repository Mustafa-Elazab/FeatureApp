package com.example.featureapp.presentation.fragment.more

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentMoreBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoreFragment : BaseFragment<FragmentMoreBinding>(R.layout.fragment_more) {
    override val defineBindingVariables: ((FragmentMoreBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardBusiness.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_businessCardFragment)
        }
        binding.cardCredit.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_visaCardFragment)
        }
    }

}