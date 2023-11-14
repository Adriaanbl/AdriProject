package es.abd.adriproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import es.abd.adriproject.databinding.ActivityPreappBinding


class PreAppActivity : AppCompatActivity(), StartPageFragment.startPageFragmentListener {

    private lateinit var binding: ActivityPreappBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreappBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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