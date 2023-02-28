package com.example.featureapp.presentation.fragment.credit_book.operation

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentOperationCreditBinding
import com.example.featureapp.utils.changeStatusBarColor
import com.example.featureapp.utils.hide
import com.example.featureapp.utils.show

import java.text.SimpleDateFormat
import java.util.*


class OperationCreditFragment :
    BaseFragment<FragmentOperationCreditBinding>(R.layout.fragment_operation_credit) {



    override val defineBindingVariables: ((FragmentOperationCreditBinding) -> Unit)?
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


        binding.cashRadio.isChecked = true

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.cash_radio -> {
                    show(1)
                }
                R.id.credit_radio -> {
                    show(2)
                }
            }
        }


        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val current = formatter.format(time)
        binding.cashDatePickerTv.text = current





        binding.cashDatePickerTv.setOnClickListener {
            val cal = Calendar.getInstance()
            val y = cal.get(Calendar.YEAR)
            val m = cal.get(Calendar.MONTH)
            val d = cal.get(Calendar.DAY_OF_MONTH)
            val datetimepicker = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox "" + dayOfMonth + " " + monthOfYear + ", " + year
                    binding.cashDatePickerTv.text = "" + year + "-" + (monthOfYear + 1)+ "-" + dayOfMonth
                },
                y,
                m,
                d
            )

            datetimepicker.show()
        }


    }

    private fun show(id: Int) {

        Toast.makeText(
            requireContext(), " On checked change :" +
                    " ${id}",
            Toast.LENGTH_SHORT
        ).show()

        if (id != 1) {
            binding.apply {
                cashOperationEdt.hide()
                cashOperationImg.hide()
                cashDatePickerTv.hide()
                cashOperationNoteEdt.hide()

                installmentProductNameEdt.show()
                installmentProductPriceEdt.show()
                installmentProductFirstPaidEdt.show()
                installmentProductMonthsEdt.show()
                installmentProductPercentageEdt.show()
                payDateEdt.show()
            }
        } else {
            binding.apply {
                cashOperationEdt.show()
                cashOperationImg.show()
                cashDatePickerTv.show()
                cashOperationNoteEdt.show()


                installmentProductNameEdt.hide()
                installmentProductPriceEdt.hide()
                installmentProductFirstPaidEdt.hide()
                installmentProductMonthsEdt.hide()
                installmentProductPercentageEdt.hide()
                payDateEdt.hide()
            }
        }
    }


}