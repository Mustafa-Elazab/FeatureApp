package com.example.featureapp.presentation.fragment.cash_book.cash

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentCashBookBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class CashBookFragment : BaseFragment<FragmentCashBookBinding>(R.layout.fragment_cash_book) {


    val viewModel: CashViewModel by activityViewModels()

    override val defineBindingVariables: ((FragmentCashBookBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllCashOperation()

        binding.run {
            addCustomerButton.setOnClickListener {
                findNavController().navigate(R.id.action_cashBookFragment_to_addCashOperationFragment)
            }
        }

        collectFlows(listOf(::collectAllCashOperation))
    }

    private suspend fun collectAllCashOperation() {
        viewModel.cashStateFlow.collectLatest {
            Log.i("TAG", "collectAllCashOperation: $it")
        }
    }
}