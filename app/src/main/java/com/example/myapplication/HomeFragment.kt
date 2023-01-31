package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.room.MainDb

class HomeFragment : Fragment() {

    private lateinit var bindingHome: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingHome = FragmentHomeBinding.inflate(inflater)
        return bindingHome.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = MainDb.getDb(this)
        bindingHome.textViewHome.text = ""
        db.getDao().getAllItem().asLiveData().observe(viewLifecycleOwner) {
            it.forEach {
                val text = "Name: ${it.name}\n"
                bindingHome.textViewHome.append(text)
            }
        }
    }
}