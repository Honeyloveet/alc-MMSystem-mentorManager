package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterFormOneBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.RegisterFormOneViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.*

@Suppress("DEPRECATION")
class RegisterFormOneFragment : Fragment() {

    private lateinit var viewModel: RegisterFormOneViewModel

    var binding: FragmentRegisterFormOneBinding? = null
    private var imageBody : MultipartBody.Part? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentRegisterFormOneBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[RegisterFormOneViewModel::class.java]

        Glide.with(this).load(R.mipmap.ic_launcher)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding!!.imageViewProfileImg)

        val fakeCountries = listOf("Egypt", "Libya", "Ghana", "Cameron")
        val adapterCountries = ArrayAdapter(requireContext(), R.layout.list_item, fakeCountries)
        binding?.dropdownCountry?.setAdapter(adapterCountries)

        val fakeCities = listOf("Cairo", "Kazanlak", "Khartoum", "Alex")
        val adapterCities = ArrayAdapter(requireContext(), R.layout.list_item, fakeCities)
        binding?.dropdownCity?.setAdapter(adapterCities)

        binding?.buttonSelectFile?.setOnClickListener {
//            val cameraPermissions = arrayOf(Manifest.permission.CAMERA)
//            if (!MyPermissions.isPermissionsGranted(requireActivity(), cameraPermissions)) {
//                MyPermissions.requestPermissionFragment(
//                    this,
//                    cameraPermissions,
//                    1
//                )
//            } else {
//                openImageChooserIntent()
//            }
            if (PermissionChecker.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE) != PermissionChecker.PERMISSION_GRANTED)
                this.requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
            else
                openImageChooserIntent()
        }

        binding?.buttonNext?.setOnClickListener {
            findNavController().navigate(RegisterFormOneFragmentDirections.actionRegisterFormOneFragmentToRegisterFormTwoFragment())
        }

        return binding?.root
    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

//        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
//            val imageUri: Uri? = data.data
//            imageUri?.let { uri ->
//                try {
//                    val imageStream: InputStream? =
//                        requireActivity().contentResolver.openInputStream(uri)
//                    val imageBitmap = BitmapFactory.decodeStream(imageStream)
//                    setUserImageBitmap(imageBitmap)
//                } catch (ex: IOException) {
//
//                }
//            }
//        }

        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            imageUri?.let { uri ->
                try {
                    val imageStream: InputStream? =
                        requireActivity().contentResolver.openInputStream(uri)
                    val imageBitmap = BitmapFactory.decodeStream(imageStream)
                    setUserImageBitmap(imageBitmap)
                } catch (ex: IOException) {
                    Log.e("RegisterFormOne", "exception = ${ex.stackTrace}")
                }
            }
        }

    }

    private fun setUserImageBitmap(imageBitmap: Bitmap?) {
//        if (imageBitmap != null) {
//            try {
//                val imageFile = CompressUtil.compressBitmap(imageBitmap,requireContext())
//
//                val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), imageFile)
//                imageBody = MultipartBody.Part.createFormData("image", imageFile.name, requestFile)
//
//                Glide.with(this).load(imageFile)
//                    .circleCrop()
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(binding!!.imageViewProfileImg)
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }

        if (imageBitmap != null) {
            try {
                val imageFile =
                    File(requireContext().cacheDir, "${System.currentTimeMillis()}_profile")
                imageFile.createNewFile()

                val byteArrayOutputStream = ByteArrayOutputStream()
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream)

                val bitmapByteArray = byteArrayOutputStream.toByteArray()

                val fileOutputStream = FileOutputStream(imageFile)
                fileOutputStream.write(bitmapByteArray)
                fileOutputStream.flush()
                fileOutputStream.close()

                val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), imageFile)
                imageBody = MultipartBody.Part.createFormData("image", imageFile.name, requestFile)

                Glide.with(this).load(imageFile)
                    .circleCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding!!.imageViewProfileImg)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }


    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if ((requestCode == 1) && grantResults.isNotEmpty()) {
            var isAllAccepted = true
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    isAllAccepted = false
                    break
                }
            }
            if (isAllAccepted) {
                if (requestCode == 1)
                    openImageChooserIntent()
            }
        }
    }

    private fun openImageChooserIntent() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        this.startActivityForResult(intent, 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}