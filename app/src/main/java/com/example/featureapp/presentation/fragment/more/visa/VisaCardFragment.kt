package com.example.featureapp.presentation.fragment.more.visa

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentVisaCardBinding
import com.example.featureapp.domain.model.VisaModel
import com.example.featureapp.presentation.fragment.more.visa.viewModel.VisaValidationsErrors
import com.example.featureapp.presentation.fragment.more.visa.viewModel.VisaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class VisaCardFragment : BaseFragment<FragmentVisaCardBinding>(R.layout.fragment_visa_card) {

    private val viewModel: VisaViewModel by viewModels()

    override val defineBindingVariables: ((FragmentVisaCardBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
            binding.fragment = this
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBar.appbarTv.text = resources.getText(R.string.credit_card)
        binding.appBar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.getAllVisa()
        collectFlows(listOf(::collectVisaState, ::collectError))


    }

    private suspend fun collectVisaState() {
        viewModel.visaStateFlow.collectLatest {
            Log.i("VisaCardFragment", "collectVisaState: $it")
        }
    }

    private suspend fun collectError() {
        viewModel.visaErrorState.collectLatest {
            when (it) {
                VisaValidationsErrors.BANK_NAME -> binding.backNameEdt.error =
                    "Bank Name Must not be Empty"
                VisaValidationsErrors.HOLDER_NAME -> binding.nameEdt.error =
                    "Holder Name Must not be Empty"
                VisaValidationsErrors.CARD_NUMBER -> binding.cardNumberEdt.error =
                    "Card Number Must not be Empty"
                VisaValidationsErrors.CARD_EXPIRY -> binding.expiryEdt.error =
                    "Expiry Must not be Empty"
                VisaValidationsErrors.CARD_CVV -> binding.cvvEdt.error = "CVV Must not be Empty"

                VisaValidationsErrors.CARD_NUMBER_LENGTH -> binding.cardNumberEdt.error =
                    "Card Number Must be 16 digits"
                VisaValidationsErrors.CARD_EXPIRY_LENGTH -> binding.expiryEdt.error =
                    "Expiry Must be 4 digits"
                VisaValidationsErrors.CARD_CVV_LENGTH -> binding.cvvEdt.error =
                    "CVV Must be 3 digits"

                VisaValidationsErrors.NoError -> {
                    val action =
                        VisaCardFragmentDirections.actionVisaCardFragmentToShowCreditCardFragment(
                            model = VisaModel(

                                cardNumber = binding.etCardNumber.text.toString(),
                                expiryDate = binding.etExpiry.text.toString(),
                                cvv = binding.etCvv.text.toString(),
                                cardHolder = binding.etName.text.toString(),
                                bankName = binding.etBankName.text.toString(),
                            )
                        )
                    findNavController().navigate(action)
                }
            }
        }
    }


    fun buttonClicked() {

        val bankName = binding.etBankName.text.toString()
        val holderName = binding.etName.text.toString()
        val cardNumber = binding.etCardNumber.text.toString()
        val cardExpiry = binding.etExpiry.text.toString()
        val cardCVV = binding.etCvv.text.toString()

        viewLifecycleOwner.lifecycleScope.launch {
            //   viewModel.validateForm(bankName, holderName, cardNumber, cardExpiry, cardCVV)
            viewModel.addVisa(visaModel = VisaModel("nknv", "bkbkcds", "4566", "555", "111"))
        }


    }

}