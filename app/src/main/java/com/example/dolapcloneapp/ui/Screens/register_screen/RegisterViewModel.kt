package com.example.dolapcloneapp.ui.Screens.register_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dolapcloneapp.data.AuthRepository
import com.example.dolapcloneapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel(){

    val _registerState = Channel<RegisterState>()
    val signUpState = _registerState.receiveAsFlow()


    fun registerUser(email : String, password :String) = viewModelScope.launch {
        repository.registerUser(email, password).collect{result->
            when(result){
                is Resource.Success ->{
                    _registerState.send(RegisterState(isSuccess = "Sign Up Success"))
                }
                is Resource.Loading ->{
                    _registerState.send(RegisterState(isLoading = true))

                }

                is Resource.Error ->{
                    _registerState.send(RegisterState(isError = result.message))
                }

                else -> {}
            }

        }
    }
}