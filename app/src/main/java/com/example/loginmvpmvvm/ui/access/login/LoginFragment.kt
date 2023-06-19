package com.example.loginmvpmvvm.ui.access.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.example.loginmvpmvvm.R
import com.example.loginmvpmvvm.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel by viewModel<LoginViewModel>()
    private var binding: FragmentLoginBinding? = null
    private val _binding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return _binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getUsersCoroutines()

        viewModel.errorMsg.observe(viewLifecycleOwner){

            _binding.etEmail.doAfterTextChanged {
                _binding.tilEmail.isErrorEnabled = false
            }

            _binding.etPassword.doAfterTextChanged {
                _binding.tilPassword.isErrorEnabled = false
            }
        }

        viewModel.usersLiveData.observe(viewLifecycleOwner){

        }

        viewModel.signIn.observe(viewLifecycleOwner){
            it?.let {

            }?: kotlin.run {

            }
        }

        val button = view.findViewById<Button>(R.id.btn_get_data)

        button.setOnClickListener{
            val email: String = view.findViewById<EditText>(R.id.et_email).text.toString()
            val password: String = view.findViewById<EditText>(R.id.et_password).text.toString()

            viewModel.signIn(email = email, password = password)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
