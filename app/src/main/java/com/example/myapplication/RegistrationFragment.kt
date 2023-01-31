package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.room.EntityClass
import com.example.myapplication.room.MainDb

class RegistrationFragment : Fragment() {

    private lateinit var bindingReg: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingReg = FragmentRegistrationBinding.inflate(inflater)
        return bindingReg.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = MainDb.getDb(this)
        bindingReg.bSaveData.setOnClickListener {
            if (bindingReg.textInputName.text.toString().isNotEmpty() && bindingReg.textInputPassword.text.toString().isNotEmpty()) {
                val item = EntityClass(
                    null,
                    bindingReg.textInputName.text.toString(),
                    bindingReg.textInputPassword.text.toString()
                )
                Thread{
                    db.getDao().insertItem(item)
                }.start()
                MAIN.navController.navigate(R.id.action_registrationFragment_to_authorizationFragment)
                Toast.makeText(activity,"Username and password saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity,"Username or password is incorrect. Try again!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}