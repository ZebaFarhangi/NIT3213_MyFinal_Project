package com.example.myapiandoridapp.ui.details

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapiandoridapp.R
import com.example.myapiandoridapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entity = args.entity
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