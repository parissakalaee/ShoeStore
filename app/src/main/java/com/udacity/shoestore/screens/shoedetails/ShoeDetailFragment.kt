package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

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

        binding.shoe = Shoe("", 0.0, "", "", emptyList())
        shoeViewModel.isRedirect.observe(viewLifecycleOwner, Observer { isCompleted ->
            if (isCompleted) {
                findNavController().navigateUp()
                shoeViewModel.redirectCompleted()
                Toast.makeText(activity, "Shoe Added", Toast.LENGTH_SHORT).show()
            }
        })

        binding.cancelDetailButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}