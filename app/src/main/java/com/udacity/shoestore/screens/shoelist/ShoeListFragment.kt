package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeDetailItemBinding
import com.udacity.shoestore.screens.shoedetails.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel
    private var shoeItemLinearLayout: LinearLayout? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListBinding =
                DataBindingUtil.inflate(
                        inflater,
                        R.layout.fragment_shoe_list,
                        container,
                        false
                )

        binding.fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))
        setHasOptionsMenu(true)

        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel = shoeViewModel

        shoeItemLinearLayout = binding.shoeListLayout
        shoeViewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
            shoeList.forEach { shoe ->
                val listItemBinding = ShoeDetailItemBinding.inflate(layoutInflater, null, false)
                listItemBinding.shoe = shoe
                binding.shoeListLayout.addView(listItemBinding.root)
                val itemSeparator = View(requireContext(), null, 0, R.style.divider)
                binding.shoeListLayout.addView(itemSeparator)
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return requireView().findNavController().navigateUp()
    }
}