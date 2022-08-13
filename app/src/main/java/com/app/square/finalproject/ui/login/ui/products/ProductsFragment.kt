package com.app.square.finalproject.ui.login.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.square.finalproject.R

class ProductsFragment : Fragment() {
    private val productsViewModel: ProductsViewModel by viewModels()
    private var columnCount = 2
    private lateinit var mAdapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_item_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = PhotoAdapter()
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = mAdapter
            }
        }
        productsViewModel.getProducts()
        renderProducts()
    }

    private fun renderProducts() {
        productsViewModel.productsResult.observe(viewLifecycleOwner) { products ->
            mAdapter.setDataList(products.success)
        }

        mAdapter.itemClicked = { image,name,price->
            findNavController().navigate(ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(image,name,price))
        }
    }
}