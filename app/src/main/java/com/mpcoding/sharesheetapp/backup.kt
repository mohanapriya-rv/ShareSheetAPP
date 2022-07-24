//package com.mpcoding.sharesheetapp
//
//import android.content.Intent
//import android.graphics.Bitmap
//import android.graphics.drawable.BitmapDrawable
//import android.net.Uri
//import android.os.Build
//import android.os.Bundle
//import android.provider.MediaStore
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.FileProvider
//import androidx.fragment.app.Fragment
//import com.google.android.material.tabs.TabLayout
//import com.google.android.material.tabs.TabLayoutMediator
//import com.mpcoding.sharesheetapp.databinding.FragmentFirstBinding
//import com.squareup.picasso.Picasso
//import java.io.File
//import java.io.FileOutputStream
//
//
///**
// * A simple [Fragment] subclass as the default destination in the navigation.
// */
//class FirstFragment : Fragment(), TabLayout.OnTabSelectedListener {
//
//    private var _binding: FragmentFirstBinding? = null
//    private var selectedTab = 0
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
//        return binding.root
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val adapter = MyViewPager(activity as AppCompatActivity)
//        with(binding) {
//            viewPagerOnboarding.adapter = adapter
//            TabLayoutMediator(circlePagerIndicator, viewPagerOnboarding) { _, _ ->
//            }.attach()
//        }
//        binding.circlePagerIndicator.addOnTabSelectedListener(this)
//        TabLayoutMediator(
//            binding.circlePagerIndicator,
//            binding.viewPagerOnboarding
//        ) { tab, position ->
//            Log.e("priyatest", position.toString())
//        }.attach()
//
//        val image =
//            "https://cdn.fundsindia.com/prelogin/investment-solutions.webp?auto=format&fit=max&w=640"
//        Picasso.get().load(image).into(binding.shareimage)
//
//        binding.buttonFirst.setOnClickListener {
//            method1()
//        }
//    }
//
//    private fun method1() {
//        val bitmapDrawable = binding.shareimage.drawable as BitmapDrawable
//        val bitmap = bitmapDrawable.bitmap
//        val bitmappath = MediaStore.Images.Media.insertImage(
//            context?.contentResolver,
//            bitmap,
//            "Some Title",
//            "priya text"
//        )
//        val bitmapUri = Uri.parse(bitmappath)
//        val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
//        intent.type = "image/*"
////        intent.putExtra(
////            Intent.EXTRA_TEXT,
////            "https://www.fundsindia.com/?gclid=CjwKCAjwiJqWBhBdEiwAtESPaKaPDSAWO5hQ_CjSo_1j05P9MBxNpTLXa269AYvznR4XjOqiLCu2CxoCzNcQAvD_BwE"
////        )
//        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
//        startActivity(Intent.createChooser(intent, "Share Image"))
//    }
//
//
//    @RequiresApi(Build.VERSION_CODES.R)
//    private fun shareImageAndText(bitmap: Bitmap) {
//        val uri = getImageToShare(bitmap)
//        val intent = Intent(Intent.ACTION_SEND)
//        // putting uri of image to be shared
//        intent.putExtra(Intent.EXTRA_STREAM, uri)
//
//        // adding text to share
//        intent.putExtra(
//            Intent.EXTRA_TEXT,
//            "https://www.fundsindia.com/?gclid=CjwKCAjwiJqWBhBdEiwAtESPaKaPDSAWO5hQ_CjSo_1j05P9MBxNpTLXa269AYvznR4XjOqiLCu2CxoCzNcQAvD_BwE"
//        )
//
//        // Add subject Here
//
//        // Add subject Here
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
//
//        // setting type to image
//
//        // setting type to image
//        intent.type = "image/png"
//
//        // calling startactivity() to share
//        startActivity(Intent.createChooser(intent, "Share Via"))
//
//    }
//
//    @RequiresApi(Build.VERSION_CODES.R)
//    private fun getImageToShare(bitmap: Bitmap): Uri {
//        val imagefolder = File(context?.cacheDir, "images")
//        val uri: Uri?
//        imagefolder.mkdirs()
//        val file = File(imagefolder, "shared_image.png")
//        val outputStream = FileOutputStream(file)
//        bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSLESS, 100, outputStream)
//        outputStream.flush()
//        outputStream.close()
//        uri = FileProvider.getUriForFile(
//            requireContext(),
//            "com.mpcoding.sharesheetapp.fileprovider",
//            file
//        )
//        return uri!!
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    override fun onTabSelected(tab: TabLayout.Tab?) {
//        selectedTab = tab!!.position
//    }
//
//    override fun onTabUnselected(tab: TabLayout.Tab?) {
//        Log.e("priya", tab.toString())
//    }
//
//    override fun onTabReselected(tab: TabLayout.Tab?) {
//        Log.e("priya", tab.toString())
//    }
//}