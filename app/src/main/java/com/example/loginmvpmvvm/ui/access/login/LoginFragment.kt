package com.example.loginmvpmvvm.ui.access.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.loginmvpmvvm.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel by viewModel<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getUsersCoroutines()

        viewModel.usersLiveData.observe(viewLifecycleOwner){

        }

        viewModel.signIn.observe(viewLifecycleOwner){
            it?.let {

            }?: kotlin.run {

            }
        }

        val button = view.findViewById<Button>(R.id.btn_get_data)

        button.setOnClickListener{
            val email: String = view.findViewById<EditText>(R.id.et_email_login).text.toString()
            val password: String = view.findViewById<EditText>(R.id.et_password_login).text.toString()

            viewModel.signIn(email = email, password = password)
        }
    }
}
