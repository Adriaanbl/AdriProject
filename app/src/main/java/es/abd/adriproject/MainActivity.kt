package es.abd.adriproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import es.abd.adriproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentStartPage.fragmentStartPageListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onLoginButtonClicked() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<CalculatorFragment>(R.id.)
            addToBackStack(null)
        }
    }


}