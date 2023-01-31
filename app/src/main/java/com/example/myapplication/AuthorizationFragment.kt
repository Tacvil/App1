package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import com.example.myapplication.databinding.FragmentAuthorizationBinding
import com.example.myapplication.room.MainDb

class AuthorizationFragment : Fragment() {

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
        val db = MainDb.getDb(this)
        bindingAuth.bHome.setOnClickListener {
            var accFound = 0
            db.getDao().getAllItem().asLiveData().observe(viewLifecycleOwner) {
                it.forEach {
                    if (bindingAuth.loginInput.text.toString() == it.name && bindingAuth.passwordInput.text.toString() == it.passWord) {
                        accFound = 1; return@forEach
                    }
                }
                if (accFound == 1){
                    MAIN.navController.navigate(R.id.action_authorizationFragment_to_homeFragment)
                    Toast.makeText(activity,"Hello, ${bindingAuth.loginInput.text.toString()}, you have successfully logged in!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity,"Username or password is incorrect. Try again or sign up!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        bindingAuth.bRegistration.setOnClickListener {
            MAIN.navController.navigate(R.id.action_authorizationFragment_to_registrationFragment3)
        }
    }
}