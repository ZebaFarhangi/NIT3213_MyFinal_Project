package com.example.myapiandoridapp.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapiandoridapp.data.model.Entity
import com.example.myapiandoridapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()  // Use SafeArgs to pass arguments

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout using ViewBinding
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the passed entity from args
        val entity = args.entity

        // Set the views with entity data
        binding.assetTypeTextView.text = entity.assetType
        binding.tickerTextView.text = entity.ticker
        binding.currentPriceTextView.text = "$${entity.currentPrice}"
        binding.dividendYieldTextView.text = "${entity.dividendYield}%"
        binding.descriptionTextView.text = entity.description
    }

    companion object {
        fun newInstance(entity: Entity): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("entity", entity)
                }
            }
        }
    }
}
