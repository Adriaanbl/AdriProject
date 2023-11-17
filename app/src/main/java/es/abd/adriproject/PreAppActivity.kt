package es.abd.adriproject

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import es.abd.adriproject.databinding.ActivityPreappBinding


class PreAppActivity : AppCompatActivity(), StartPageFragment.startPageFragmentListener {


    private val requestPermissionLauncher =  registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted ->
        val message = if (isGranted) "Permission granted" else "Permission denied"
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }



    private lateinit var binding: ActivityPreappBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreappBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        requestPermissionLauncher.launch(Manifest.permission.ACCESS_MEDIA_LOCATION)

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

}