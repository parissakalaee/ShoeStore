package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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

        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.shoeViewModel = shoeViewModel

        shoeItemLinearLayout = binding.shoeListLayout
        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->
//                val rowInflater = LayoutInflater.from(activity)
//                val rowList = rowInflater.inflate(R.layout.shoe_detail_item, null)
//                rowList.shoe_name_text.text = shoe.name
//                rowList.company_name_text.text = shoe.company
//                rowList.shoe_description_text.text = shoe.description
//
//                val layoutParams = ConstraintLayout.LayoutParams(
//                        ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
////                layoutParams.topMargin = 0
////                layoutParams.leftMargin = 0
////                layoutParams.rightMargin = 0
////                layoutParams.bottomMargin = 0
//                shoeItemLinearLayout!!.addView(rowList, shoeItemLinearLayout!!.childCount - 1, layoutParams)
//
                val listItemBinding = ShoeDetailItemBinding.inflate(layoutInflater, null, false)
                listItemBinding.shoe = shoe
                binding.shoeListLayout.addView(listItemBinding.root)
            }

            shoeList.forEach { shoe ->
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