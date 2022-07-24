package com.mpcoding.sharesheetapp

import android.provider.MediaStore
//
///**
// * A simple [Fragment] subclass as the second destination in the navigation.
// */
//
//    package com.mpcoding.sharesheetapp
//
//    import android.content.Intent
//    import android.graphics.Bitmap
//    import android.net.Uri
//    import android.os.Build
//    import android.os.Bundle
//    import android.os.StrictMode
//    import android.os.StrictMode.VmPolicy
//    import android.view.LayoutInflater
//    import android.view.View
//    import android.view.ViewGroup
//    import androidx.annotation.RequiresApi
//    import androidx.appcompat.app.AppCompatActivity
//    import androidx.core.content.FileProvider
//    import androidx.fragment.app.Fragment
//    import com.google.android.material.tabs.TabLayoutMediator
//    import com.mpcoding.sharesheetapp.databinding.FragmentFirstBinding
//    import java.io.File
//    import java.io.FileOutputStream
//
//
//    /**
//     * A simple [Fragment] subclass as the default destination in the navigation.
//     */
//    class FirstFragment : Fragment() {
//
//        private var _binding: FragmentFirstBinding? = null
//
//        // This property is only valid between onCreateView and
//        // onDestroyView.
//        private val binding get() = _binding!!
//
//        override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//        ): View {
//
//            _binding = FragmentFirstBinding.inflate(inflater, container, false)
//            return binding.root
//
//        }
//
//        @RequiresApi(Build.VERSION_CODES.R)
//        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//            super.onViewCreated(view, savedInstanceState)
//
//
//
//            val adapter = MyViewPager(activity as AppCompatActivity)
//            with(binding) {
//                viewPagerOnboarding.adapter = adapter
//                TabLayoutMediator(circlePagerIndicator, viewPagerOnboarding) { _, _ ->
//                }.attach()
//            }
////        val imageUrl =
////            "https://cdn.fundsindia.com/prelogin/investment-solutions.webp?auto=format&fit=max&w=640"
////        Picasso.get().load(imageUrl).into(binding.shareimage)
//            binding.buttonFirst.setOnClickListener {
//                method1()
//                //  method2()
//                // method3()
//            }
//        }
//
//        private fun method3() {
//        val bitmap = bitmapDrawable.bitmap
//        val bitmappath = MediaStore.Images.Media.insertImage(
//            context?.contentResolver,
//            bitmap,
//            "Some Title",
//            "priya text"
//        )
//            val bitmapUri = Uri.parse(bitmappath)
//        val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
//        intent.type = "*/*"
//        intent.putExtra(
//            Intent.EXTRA_TEXT,
//            "https://www.fundsindia.com/?gclid=CjwKCAjwiJqWBhBdEiwAtESPaKaPDSAWO5hQ_CjSo_1j05P9MBxNpTLXa269AYvznR4XjOqiLCu2CxoCzNcQAvD_BwE"
//        )
//        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
//        val share = Intent.createChooser(Intent().apply {
//            action = Intent.ACTION_SEND_MULTIPLE
//            putExtra(
//                Intent.EXTRA_TEXT,
//                "https://www.fundsindia.com/?gclid=CjwKCAjwiJqWBhBdEiwAtESPaKaPDSAWO5hQ_CjSo_1j05P9MBxNpTLXa269AYvznR4XjOqiLCu2CxoCzNcQAvD_BwE"
//            )
//
//            // (Optional) Here we're setting the title of the content
//            putExtra(Intent.EXTRA_TITLE, "Introducing content previews")
//            putExtra(Intent.EXTRA_STREAM, bitmapUri)
//
//            // (Optional) Here we're passing a content URI to an image to be displayed
//            data = bitmapUri
//            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
//        }, null)
//        startActivity(share)
//        }
//
//        @RequiresApi(Build.VERSION_CODES.R)
//        private fun method2() {
//            val builder = VmPolicy.Builder()
//            StrictMode.setVmPolicy(builder.build())
//            //  val bitmap = binding.shareimage.drawable.toBitmap()
//            //  shareImageAndText(bitmap)
//        }
//
//        private fun method1() {
////        val bitmapDrawable = binding.shareimage.drawable as BitmapDrawable
////        val bitmap = bitmapDrawable.bitmap
////        val bitmappath = MediaStore.Images.Media.insertImage(
////            context?.contentResolver,
////            bitmap,
////            "Some Title",
////            "priya text"
////        )
////        val bitmapUri = Uri.parse(bitmappath)
////        val intent = Intent(Intent.ACTION_SEND)
////        intent.type = "image/*"
////        intent.putExtra(
////            Intent.EXTRA_TEXT,
////            "https://www.fundsindia.com/?gclid=CjwKCAjwiJqWBhBdEiwAtESPaKaPDSAWO5hQ_CjSo_1j05P9MBxNpTLXa269AYvznR4XjOqiLCu2CxoCzNcQAvD_BwE"
////        )
////        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
////        startActivity(Intent.createChooser(intent, "Share Image"))
//        }
//
//        @RequiresApi(Build.VERSION_CODES.R)
//        private fun shareImageAndText(bitmap: Bitmap) {
//            val uri = getImageToShare(bitmap)
//            val intent = Intent(Intent.ACTION_SEND)
//            // putting uri of image to be shared
//            intent.putExtra(Intent.EXTRA_STREAM, uri)
//
//            // adding text to share
//            intent.putExtra(
//                Intent.EXTRA_TEXT,
//                "https://www.fundsindia.com/?gclid=CjwKCAjwiJqWBhBdEiwAtESPaKaPDSAWO5hQ_CjSo_1j05P9MBxNpTLXa269AYvznR4XjOqiLCu2CxoCzNcQAvD_BwE"
//            )
//
//            // Add subject Here
//
//            // Add subject Here
//            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
//
//            // setting type to image
//
//            // setting type to image
//            intent.type = "image/png"
//
//            // calling startactivity() to share
//            startActivity(Intent.createChooser(intent, "Share Via"))
//
//        }
//
//        @RequiresApi(Build.VERSION_CODES.R)
//        private fun getImageToShare(bitmap: Bitmap): Uri {
//            val imagefolder = File(context?.cacheDir, "images")
//            val uri: Uri?
//            imagefolder.mkdirs()
//            val file = File(imagefolder, "shared_image.png")
//            val outputStream = FileOutputStream(file)
//            bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSLESS, 100, outputStream)
//            outputStream.flush()
//            outputStream.close()
//            uri = FileProvider.getUriForFile(
//                requireContext(),
//                "com.mpcoding.sharesheetapp.fileprovider",
//                file
//            )
//            return uri!!
//        }
//
//        override fun onDestroyView() {
//            super.onDestroyView()
//            _binding = null
//        }
//    }
