package com.example.finalrecipeapplication.presentation.screens.first_time_user_screen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginInScreenViewModel(
    private val applicationContext: Context
): ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    private val _authenticationState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authenticationState: StateFlow<AuthState> = _authenticationState


    private val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("998664279203-4s52gbvta8tuin97a2qpvaj2t03sa2bo.apps.googleusercontent.com")
        .requestEmail()
        .build()

    private val googleSignInClient = GoogleSignIn.getClient(applicationContext, googleSignInOptions)




    sealed class AuthState {
        object Initial : AuthState()
        object SigningIn : AuthState()
        data class SignInFailed(val exception: Exception) : AuthState()
        data class SignedIn(val user: FirebaseUser?) : AuthState()
    }

}

