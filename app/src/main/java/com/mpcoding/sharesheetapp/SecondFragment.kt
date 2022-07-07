package com.mpcoding.sharesheetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mpcoding.sharesheetapp.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

//            val shareIntent = Intent(Intent.ACTION_SEND)
//            shareIntent.type = "text/plain"
//            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
//            var shareMessage = "\nhttps://www.fundsindi…\n\n"
//            shareMessage =
//                """
//                ${shareMessage}https://play.google.com/store/apps/details?id=${"com.fundsindia.com"}
//
//
//                """.trimIndent()
//            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
//            startActivity(Intent.createChooser(shareIntent, "choose one"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}