package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodel.SharedShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeViewModel: SharedShoeViewModel

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

        shoeViewModel = ViewModelProvider(requireActivity()).get(SharedShoeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.shoeViewModel = shoeViewModel

        shoeViewModel.isShoeAdded.observe(viewLifecycleOwner) { isAdded ->
            if (isAdded) {
                findNavController().navigateUp()
                shoeViewModel.onAddShoe()
            }
        }

        binding.cancelDetailButton.setOnClickListener {
            findNavController().navigateUp()
        }

//        // Only runs if there is a view that is currently focused
//        requireActivity().currentFocus?.let { view ->
//            val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
//            imm?.hideSoftInputFromWindow(view.windowToken, 0)
//        }
        return binding.root
    }
}