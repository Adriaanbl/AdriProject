package es.abd.adriproject

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import es.abd.adriproject.databinding.ActivityPreappBinding


class PreAppActivity : AppCompatActivity(), StartPageFragment.startPageFragmentListener, LoginFragment.fragmentLoginListener, RegisterFragment.fragmentRegisterListener {

    private lateinit var binding: ActivityPreappBinding


    private val requestPermissionLauncher =  registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted ->
        val message = if (isGranted) "Permission granted" else "Permission denied"
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestPermissionLauncher.launch(Manifest.permission.ACCESS_MEDIA_LOCATION)

    }

    override fun onRegisterButtonClicked() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<RegisterFragment>(R.id.fragment_start_page)
            addToBackStack(null)
        }
    }

    override fun onLoginButtonClicked() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<LoginFragment>(R.id.fragment_start_page)
            addToBackStack(null)
        }
    }

    override fun onNotLoggedButtonClicked() {

        val intent = Intent(this, PrincipalActivity::class.java)
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == REQUEST_CODE) {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startActivity(
                    Intent(this, PreAppActivity::class.java).apply {
                        putExtra("GRANTED", true)
                    }
                )
            }else {
                startActivity(Intent(this, PreAppActivity::class.java))
            }
        }else{
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    override fun onLogFragmentBtnClicked() {
        val intent = Intent(this, PrincipalActivity::class.java)
        startActivity(intent)
    }

    override fun onRegFragmentbtn() {
        val intent = Intent(this, PreAppActivity::class.java)
        startActivity(intent)
    }


    companion object {
        private const val REQUEST_CODE = 123
    }

}