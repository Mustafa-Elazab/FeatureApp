package com.example.featureapp.presentation.fragment.cash_book.add_cash

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.data.local.entity.CashOperationEntity
import com.example.featureapp.databinding.FragmentAddCashOperationBinding
import com.example.featureapp.presentation.fragment.cash_book.cash.CashViewModel


class AddCashOperationFragment :
    BaseFragment<FragmentAddCashOperationBinding>(R.layout.fragment_add_cash_operation) {


    private var isOperator = false
    private var hasOperator = false

    private val args by navArgs<AddCashOperationFragmentArgs>()
    val viewModel: CashViewModel by activityViewModels()

    override val defineBindingVariables: ((FragmentAddCashOperationBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBar.appbarTv.text = resources.getText(R.string.add_operation)
        binding.appBar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.apply {
            categoryConstraint.setOnClickListener {
                findNavController().navigate(R.id.action_addCashOperationFragment_to_categoryFragment)
            }

        }

        if (args.model != null) {
            binding.categoryValueTv.text = args.model!!.name
        }

        buttonClicked()

        val operation = CashOperationEntity(
            category = "Shopping",
            amount = "500",
            type = "Income"
        )
        binding.btnSave.setOnClickListener {
            viewModel.addCashOperation(
                operationModel = operation
            )

        }
    }


    private fun buttonClicked() {

        binding.btn00.setOnClickListener {
            numberButtonClicked("00")
        }
        binding.btn0.setOnClickListener {
            numberButtonClicked("0")
        }
        binding.btn1.setOnClickListener {
            numberButtonClicked("1")
        }
        binding.btn2.setOnClickListener {
            numberButtonClicked("2")
        }
        binding.btn3.setOnClickListener {
            numberButtonClicked("3")
        }
        binding.btn4.setOnClickListener {
            numberButtonClicked("4")
        }
        binding.btn5.setOnClickListener {
            numberButtonClicked("5")
        }
        binding.btn6.setOnClickListener {
            numberButtonClicked("6")
        }
        binding.btn7.setOnClickListener {
            numberButtonClicked("7")
        }
        binding.btn8.setOnClickListener {
            numberButtonClicked("8")
        }
        binding.btn9.setOnClickListener {
            numberButtonClicked("9")
        }

        binding.btnPlus.setOnClickListener {
            operatorButtonClicked("+")
        }

        binding.btnMinus.setOnClickListener {
            operatorButtonClicked("-")
        }

        binding.btnMulti.setOnClickListener {
            operatorButtonClicked("X")
        }

        binding.btnDiv.setOnClickListener {
            operatorButtonClicked("/")
        }

        binding.btnMod.setOnClickListener {
            operatorButtonClicked("%")
        }
        binding.btnResult.setOnClickListener {
            resultButtonClicked()
        }

        binding.btnBack.setOnClickListener {
            backButtonClicked()
        }
        binding.btnClear.setOnClickListener {
            clearButtonClicked()
        }

        binding.btnDot.setOnClickListener {
            dotButtonClicked()
        }


    }


    private fun numberButtonClicked(number: String) {
        if (isOperator) {
            binding.txtExpression.append(" ")
        }
        isOperator = false

        val expressionText = binding.txtExpression.text.split(" ")

        binding.txtExpression.append(number)
        binding.cashOperationTv.text = calculateExpression()
    }

    private fun operatorButtonClicked(operator: String) {
        if (binding.txtExpression.text.isEmpty()) {
            return
        }

        when {
            isOperator -> {
                val text = binding.txtExpression.text.toString()
                binding.txtExpression.text = text.dropLast(1) + operator
            }
            hasOperator -> {

                return
            }
            else -> {
                binding.txtExpression.append(" $operator")
            }

        }
        val ssb = SpannableStringBuilder(binding.txtExpression.text)

        binding.txtExpression.text = ssb
        isOperator = true
        hasOperator = true
    }


    private fun resultButtonClicked() {
        val expressionTexts = binding.txtExpression.text.split(" ")
        if (binding.txtExpression.text.isEmpty() || expressionTexts.size == 1) {
            return
        }
        if (expressionTexts.size != 3 && hasOperator) {

            return
        }
        if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()) {


            return
        }
        val expressionText = binding.txtExpression.text.toString()
        val resultText = calculateExpression()

        binding.cashOperationTv.text = ""
        binding.txtExpression.text = resultText

        isOperator = false
        hasOperator = false

    }

    private fun calculateExpression(): String {
        val expressionTexts = binding.txtExpression.text.split(" ")

        if (hasOperator.not() || expressionTexts.size != 3) {
            return ""
        } else if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()) {
            return ""
        }
        val exp1 = expressionTexts[0].toBigInteger()
        val exp2 = expressionTexts[2].toBigInteger()
        val op = expressionTexts[1]

        return when (op) {
            "+" -> (exp1 + exp2).toString()
            "-" -> (exp1 - exp2).toString()
            "X" -> (exp1 * exp2).toString()
            "%" -> (exp1 % exp2).toString()
            "/" -> (exp1 / exp2).toString()
            else -> ""
        }
    }

    private fun dotButtonClicked() {
        if (!hasOperator) {
            if (binding.txtExpression.text.isEmpty()) {
                binding.txtExpression.append("0.")
            } else if (!binding.txtExpression.text.toString().contains(".")) {
                binding.txtExpression.append(".")
            }
        } else {
            if (binding.cashOperationTv.text.isEmpty()) {
                binding.cashOperationTv.append("0.")
            } else if (binding.cashOperationTv.text.isNotEmpty() && binding.cashOperationTv.text.toString()
                    .contains(".")
            ) {
                binding.cashOperationTv.append(".")
            }
        }

    }

    private fun clearButtonClicked() {
        binding.txtExpression.text = ""
        binding.cashOperationTv.text = ""
        isOperator = false
        hasOperator = false
    }

    private fun backButtonClicked() {
        binding.txtExpression.text = binding.txtExpression.text.dropLast(1)
        isOperator = false
        hasOperator = false
    }

    fun String.isNumber(): Boolean {
        return try {
            this.toBigInteger()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}