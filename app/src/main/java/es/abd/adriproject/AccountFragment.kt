package es.abd.adriproject

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import es.abd.adriproject.databinding.FragmentAccountBinding
import es.abd.adriproject.databinding.FragmentLoginBinding


class AccountFragment : Fragment(), CompoundButton.OnCheckedChangeListener {


    private val PERMISSION_REQUEST_CODE = 123

    private var listener : fragmentAccountListener? = null

    private lateinit var binding: FragmentAccountBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(layoutInflater,container,false)



        RegisterFragment.getUser()?.let { user ->

            val name = user.name
            val email = user.email
            val pass = user.password

            binding.AccUsername.text = name
            binding.AccEmail.text = email
            binding.AccPassword.text = pass
        }

        binding.notiSwitch.setOnCheckedChangeListener(this)


        return binding.root

    }


    interface fragmentAccountListener{

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (isChecked) {

            if (checkNotificationPermission()) {

            } else {

                requestPermissionLauncher.launch(Manifest.permission.VIBRATE)
                requestNotificationPermission()
            }
        } else {

        }


    }

    private val requestPermissionLauncher =  registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            isGranted ->
        val message = if (isGranted) "Permission granted" else "Permission denied"
        Toast.makeText(context,message, Toast.LENGTH_LONG).show()
    }

    private fun checkNotificationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.VIBRATE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.VIBRATE),
                PERMISSION_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {

            }
        }
    }


}