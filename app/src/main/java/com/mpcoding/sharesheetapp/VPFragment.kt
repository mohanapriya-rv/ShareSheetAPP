package com.mpcoding.sharesheetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mpcoding.sharesheetapp.databinding.FragmentSecondBinding


class VPFragment : Fragment() {

    private var page: Int = 0
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val PAGE_NUMBER = "page_number"
        fun newInstance(page: Int): VPFragment {
            val vpFragment = VPFragment()
            val args = Bundle()
            args.putInt(PAGE_NUMBER, page)
            vpFragment.arguments = args
            return vpFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = arguments?.getInt(PAGE_NUMBER, 1) ?: 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        when (page) {
            0 -> setViews("https://cdn.fundsindia.com/prelogin/investment-solutions.webp?auto=format&fit=max&w=640")
            1 -> setViews("https://cdn.fundsindia.com/prelogin/mf-home-icon.webp?auto=format&fit=max&w=1920")
            2 -> setViews("https://cdn.fundsindia.com/prelogin/products-image.webp?auto=format&fit=max&w=1080  ")
        }
    }

    private fun setViews(imageResource: String) {
        with(binding) {
            val imageUrl = imageResource
            ivOnboardingImage.setImageResource(R.drawable.sample)
//            Picasso.get().load(imageUrl).into(binding.ivOnboardingImage)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}