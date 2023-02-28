package com.example.featureapp.presentation.fragment.cash_book.category

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.featureapp.R
import com.example.featureapp.base.BaseFragment
import com.example.featureapp.databinding.FragmentCategoryBinding
import com.example.featureapp.presentation.fragment.cash_book.category.adapter.CategoryAdapter
import com.example.featureapp.presentation.fragment.cash_book.category.data.CategoryModel
import com.example.featureapp.presentation.fragment.cash_book.category.viewmodel.CategoryViewModel
import com.example.featureapp.utils.changeStatusBarColor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    private val viewModel : CategoryViewModel by viewModels()

    override val defineBindingVariables: ((FragmentCategoryBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
            binding.fragment = this
        }

    val adapter = CategoryAdapter{
        onItemClick(it)
    }

    private fun onItemClick(categoryModel: CategoryModel) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToAddCashOperationFragment(model = categoryModel)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor(R.color.white)
        binding.appBar.appbarTv.text = resources.getText(R.string.add_customer)
        binding.appBar.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.rvCategory.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        collectFlows(listOf(::collectCategoryState))


    }



    private suspend fun collectCategoryState(){
        viewModel.categoryStateFlow.collectLatest {
            adapter.submitList(it)
            Log.i("TAG", "collectCategoryState: $it")
        }
    }
}