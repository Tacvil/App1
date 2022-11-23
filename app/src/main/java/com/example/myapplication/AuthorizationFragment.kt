package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    private lateinit var bindingAuth: FragmentAuthorizationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingAuth = FragmentAuthorizationBinding.inflate(inflater)
        return bindingAuth.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingAuth.bHome.setOnClickListener {
            if (bindingAuth.loginInput.text.toString() == "test" && bindingAuth.passwordInput.text.toString() == "test"){
                MAIN.navController.navigate(R.id.action_authorizationFragment_to_homeFragment)
            } else {
             Toast.makeText(activity,"Username or password is incorrect. Try again!", Toast.LENGTH_SHORT).show()
            }
            dataModel.loginName.value = "Hello, ${bindingAuth.loginInput.text.toString()}, you have successfully logged in!"
        }
    }
}