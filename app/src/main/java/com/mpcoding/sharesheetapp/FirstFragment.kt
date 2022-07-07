package com.mpcoding.sharesheetapp

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.mpcoding.sharesheetapp.databinding.FragmentFirstBinding
import java.io.File
import java.io.FileOutputStream


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val bitmap = binding.shareimage.drawable.toBitmap()
            shareImageAndText(bitmap)
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun shareImageAndText(bitmap: Bitmap) {
        val uri = getImageToShare(bitmap)
        val intent = Intent(Intent.ACTION_SEND)
        // putting uri of image to be shared
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        // adding text to share
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "https://www.fundsindia.com/?gclid=CjwKCAjwiJqWBhBdEiwAtESPaKaPDSAWO5hQ_CjSo_1j05P9MBxNpTLXa269AYvznR4XjOqiLCu2CxoCzNcQAvD_BwE"
        )

        // Add subject Here

        // Add subject Here
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")

        // setting type to image

        // setting type to image
        intent.type = "image/png"

        // calling startactivity() to share
        startActivity(Intent.createChooser(intent, "Share Via"))

    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun getImageToShare(bitmap: Bitmap): Uri {
        val imagefolder = File(context?.cacheDir, "images")
        var uri: Uri?
        imagefolder.mkdirs()
        val file = File(imagefolder, "shared_image.png")
        val outputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSLESS, 100, outputStream)
        outputStream.flush()
        outputStream.close()
        uri = FileProvider.getUriForFile(
            requireContext(),
            "com.mpcoding.sharesheetapp.fileprovider",
            file
        )

        return uri!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}