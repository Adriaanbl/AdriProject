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
            setCustomAnimations(R.anim.slide_in1, 0, 0, 0)
            replace<WomanFragment>(R.id.fragment2)
        }
    }


    override fun onManButtonClicked() {
        val animations = arrayOf(
            R.anim.slide_in1,
            R.anim.slide_in2,
            R.anim.slide_in3,
            R.anim.slide_in4,
            R.anim.slide_in5
        )

        for (i in animations.indices) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                setCustomAnimations(animations[i], 0, 0, 0)
                replace<WomanFragment>(R.id.fragment2)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            }
        }
    }

}