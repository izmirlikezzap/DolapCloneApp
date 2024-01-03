package com.example.dolapcloneapp.data

import com.example.dolapcloneapp.util.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email:String, password: String) : Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String) : Flow<Resource<AuthResult>>

}