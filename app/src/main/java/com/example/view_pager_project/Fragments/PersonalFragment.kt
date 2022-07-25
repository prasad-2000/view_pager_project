package com.example.view_pager_project.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.view_pager_project.databinding.FragmentPersonalBinding
import kotlinx.android.synthetic.main.fragment_personal.*


class PersonalFragment : Fragment() {
    private lateinit var mBinding: FragmentPersonalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentPersonalBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ValidatePersonal()
    }

    fun ValidatePersonal(): Boolean {
        return if (editTextTextPersonName.text.toString().isEmpty()) {
            Toast.makeText(requireContext(), "Hii", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
            false
        }
    }

}