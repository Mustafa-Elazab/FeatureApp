package com.example.featureapp.presentation.fragment.more.visa

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentShowCreditCardBinding
import com.example.featureapp.presentation.fragment.more.visa.viewModel.VisaViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShowCreditCardFragment :
    BaseFragment<FragmentShowCreditCardBinding>(R.layout.fragment_show_credit_card) {


    val args by navArgs<ShowCreditCardFragmentArgs>()
    private val viewModel: VisaViewModel by activityViewModels()

    override val defineBindingVariables: ((FragmentShowCreditCardBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBar.appbarTv.text = resources.getText(R.string.add_customer)
        binding.appBar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        showUiData()

        binding.saveVisaBtn.setOnClickListener {
            viewModel.addVisa(
                visaModel = args.model!!
            )

        }
    }

    private fun showUiData() {
        binding.apply {

            bankNameTv.text = args.model?.bankName.toString()
            cardHolderTv.text = args.model?.cardHolder.toString()
            cardCvvTv.text = args.model?.cvv.toString()
            cardExpiryTv.text = args.model?.expiryDate.toString()
            cardNumberTv.text = args.model?.cardNumber.toString()


        }
    }
}