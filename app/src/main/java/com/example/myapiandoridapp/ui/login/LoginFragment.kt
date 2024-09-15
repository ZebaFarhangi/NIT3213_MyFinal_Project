package com.example.myapiandoridapp.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myapiandoridapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment: Fragment() {
    //creating reference to viewModel
    private val viewModel: LoginViewModel by viewModels()

    // private lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //accessing to viewModel.value syntax how i access to mutableStateFlow data that contain
        /*view.findViewById<TextView>(R.id.loginPage).text = viewModel.greetingText.value*/

        //implementing lifecycleScope for fragment and coroutines
        lifecycleScope.launch {
            delay(3000)
        }
        val username = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)
        val loginButton = view.findViewById<Button>(R.id.btn_login)

        loginButton.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()
            // Call login method in ViewModel
            viewModel.login(user, pass)
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }

        //Use viewModel in loginPageFragment
        /* println(viewModel::class.java)*/


    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.d.l)
    }*/


}