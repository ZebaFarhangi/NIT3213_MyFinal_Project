package com.example.myapiandoridapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapiandoridapp.MainActivity
import com.example.myapiandoridapp.R
import com.example.myapiandoridapp.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    //Error handling and loading states
    sealed class UiState<out T> {
        data object Loading : UiState<Nothing>()
        data class Success<T>(val data: T) : UiState<T>()
        data class Error(val message: String) : UiState<Nothing>()
    }
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            viewModel.login(username, password)
            findNavController(R.id.action_loginFragment_to_dashboardFragment)
        }

        viewModel.loginResult.observe(this) { result ->
            if (result.isSuccess) {
                // Navigate to MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else if (result.isFailure) {
                // Show error message
                Toast.makeText(this, "Login failed: ${result.exceptionOrNull()?.message}", Toast.LENGTH_SHORT).show()
            }
        }




    }


}