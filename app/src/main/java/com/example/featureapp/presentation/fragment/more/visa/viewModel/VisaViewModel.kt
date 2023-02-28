package com.example.featureapp.presentation.fragment.more.visa.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featureapp.domain.model.VisaModel
import com.example.featureapp.domain.usecase.AddVisaUseCase
import com.example.featureapp.domain.usecase.DeleteVisaUseCase
import com.example.featureapp.domain.usecase.GetAllVisaUseCase
import com.example.featureapp.domain.usecase.GetVisaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VisaViewModel @Inject constructor(
    private val addVisaUseCase: AddVisaUseCase,
    private val getVisaUseCase: GetVisaUseCase,
    private val getAllVisaUseCase: GetAllVisaUseCase,
    private val deleteVisaUseCase: DeleteVisaUseCase
) : ViewModel() {


    private val _visaStateFlow = MutableStateFlow(emptyList<VisaModel>())
    val visaStateFlow get() = _visaStateFlow.asStateFlow()

    private val _visaErrorState = MutableSharedFlow<VisaValidationsErrors>()
    val visaErrorState get() = _visaErrorState.asSharedFlow()

    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    val uiState: StateFlow<ViewState> = _uiState


    fun getAllVisa() {
        viewModelScope.launch {
            getAllVisaUseCase().collect { flow ->
                flow.map {
                    _visaStateFlow.emit(it)
//                    if (it.isEmpty()) {
//                        _uiState.value = com.example.featureapp.presentation.fragment.more.visa.viewModel.ViewState.Empty
//                    } else {
//                        _uiState.value = com.example.featureapp.presentation.fragment.more.visa.viewModel.ViewState.Success(it)
//
//                    }
                }
            }
        }
    }

    fun removeVisa(visaModel: VisaModel) {
        viewModelScope.launch {
            deleteVisaUseCase(visaModel)

        }
    }


    fun addVisa(visaModel: VisaModel) {
        viewModelScope.launch {
            addVisaUseCase(visaModel)
        }
    }

    suspend fun validateForm(
        bankName: String,
        holderName: String,
        cardNumber: String,
        cardExpiry: String,
        cardCVV: String
    ) {
        if (bankName.isEmpty()) {
            _visaErrorState.emit(VisaValidationsErrors.BANK_NAME)
        } else if (holderName.isEmpty()) {
            _visaErrorState.emit(VisaValidationsErrors.HOLDER_NAME)
        } else if (cardNumber.isEmpty()) {
            _visaErrorState.emit(VisaValidationsErrors.CARD_NUMBER)
        } else if (cardNumber.length != 16) {
            _visaErrorState.emit(VisaValidationsErrors.CARD_NUMBER_LENGTH)
        } else if (cardExpiry.length != 4) {
            _visaErrorState.emit(VisaValidationsErrors.CARD_EXPIRY_LENGTH)
        } else if (cardCVV.length != 3) {
            _visaErrorState.emit(VisaValidationsErrors.CARD_CVV_LENGTH)
        } else if (cardExpiry.isEmpty()) {
            _visaErrorState.emit(VisaValidationsErrors.CARD_EXPIRY)
        } else if (cardCVV.isEmpty()) {
            _visaErrorState.emit(VisaValidationsErrors.CARD_CVV)
        } else {
            // _visaErrorState.emit(VisaValidationsErrors.NoError)
            addVisa(
                visaModel = VisaModel(
                    bankName = bankName,
                    cardHolder = holderName,
                    cardNumber =cardNumber,
                    expiryDate = cardExpiry,
                    cvv = cardCVV
                )
            )
        }
    }


}


enum class VisaValidationsErrors {
    BANK_NAME,
    HOLDER_NAME,
    CARD_NUMBER,
    CARD_NUMBER_LENGTH,
    CARD_EXPIRY_LENGTH,
    CARD_CVV_LENGTH,
    CARD_EXPIRY,
    CARD_CVV,
    NoError
}

sealed class ViewState {
    object Loading : ViewState()
    object Empty : ViewState()
    data class Success(val visa: List<VisaModel>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}