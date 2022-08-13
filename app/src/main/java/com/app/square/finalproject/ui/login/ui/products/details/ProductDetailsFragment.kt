package com.app.square.finalproject.ui.login.ui.products.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.app.square.finalproject.databinding.FragmentDetailsBinding
import com.app.square.finalproject.ui.login.ui.products.ProductsViewModel
import com.bumptech.glide.Glide

class ProductDetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderProduct()
    }

    private fun renderProduct() {
        Glide.with(this).load(args.thumbnail).into(binding.thumbnail)
        binding.mame.text = args.name
        binding.price.text = args.price
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}