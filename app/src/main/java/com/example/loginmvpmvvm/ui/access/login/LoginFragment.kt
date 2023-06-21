package com.example.loginmvpmvvm.ui.access.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.loginmvpmvvm.R
import com.example.loginmvpmvvm.databinding.FragmentLoginBinding
import com.example.loginmvpmvvm.ui.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel by viewModel<LoginViewModel>()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getUsersCoroutines()

        viewModel.errorMsg.observe(viewLifecycleOwner){

            binding.etEmail.doAfterTextChanged {
                binding.tilEmail.isErrorEnabled = false
            }

            binding.etPassword.doAfterTextChanged {
                binding.tilPassword.isErrorEnabled = false
            }
        }

        viewModel.usersLiveData.observe(viewLifecycleOwner){

        }

        viewModel.signInSuccess.observe(viewLifecycleOwner){
            it?.let {
                val intent = Intent(requireContext(), HomeActivity::class.java).apply {
                    putExtra("id", it.idUser)
                }
                startActivity(intent)
            }?: kotlin.run {
                Toast.makeText(requireContext(), "Login e Senha Inválido", Toast.LENGTH_SHORT).show()
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
        _binding = null
    }
}
