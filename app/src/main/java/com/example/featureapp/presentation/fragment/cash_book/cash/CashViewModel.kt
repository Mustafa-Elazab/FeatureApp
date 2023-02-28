package com.example.featureapp.presentation.fragment.cash_book.cash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featureapp.data.local.entity.CashOperationEntity
import com.example.featureapp.domain.usecase.AddCashUseCase
import com.example.featureapp.domain.usecase.GetAllCashUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CashViewModel @Inject constructor(
    private val addCashUseCase: AddCashUseCase,
    private val getAllCashUseCase: GetAllCashUseCase
) : ViewModel() {




    private val _cashStateFlow = MutableStateFlow(emptyList<CashOperationEntity>())
    val cashStateFlow get() = _cashStateFlow.asStateFlow()


    fun getAllCashOperation() {
        viewModelScope.launch {
            getAllCashUseCase().collect { listFlow ->
                listFlow.map {
                    _cashStateFlow.emit(it)
                }
            }
        }
    }

    fun addCashOperation(operationModel: CashOperationEntity) {
        viewModelScope.launch {
            addCashUseCase(operationModel = operationModel)
        }
    }
}

sealed class CashState {
    object Loading : CashState()
    object Empty : CashState()
    data class Success(val models: List<CashOperationEntity>) : CashState()
    data class Error(val exception: Throwable) : CashState()
}


