package es.abd.adriproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class PrincipalActivity : AppCompatActivity(), SelectionFragment.FragmentSelectionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

    override fun onWomanButtonClicked() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<WomanFragment>(R.id.fragment2)
        }
    }


    override fun onManButtonClicked() {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ManFragment>(R.id.fragment2)

            }

    }

}