package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding =
                DataBindingUtil.inflate(
                        inflater,
                        R.layout.fragment_shoe_detail,
                        container,
                        false
                )

        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.cancelDetailButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}