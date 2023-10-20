package es.abd.adriproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import android.text.TextUtils.replace
import es.abd.adriproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), FragmentStartPage.fragmentStartPageListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onLoginButtonClicked() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FragmentLogin>(R.id.fragment_start_page)
            addToBackStack(null)
        }
    }

}