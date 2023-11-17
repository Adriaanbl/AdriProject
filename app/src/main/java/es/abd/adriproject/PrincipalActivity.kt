package es.abd.adriproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class PrincipalActivity : AppCompatActivity(), SelectionFragment.FragmentSelectionListener, ManFragment.FragmentManListener {
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

    private var productAdapter: ProductAdapter? = null

    override fun onManMenuButtonClicked(btn: Int) {


        val li: MutableList<Product> = mutableListOf()

        when (btn) {
            R.id.manMenuBottom -> {
                li.addAll(
                    listOf(Product("Bottom 1", R.drawable.product1, 19.99f),
                        Product("Bottom 2", R.drawable.product2, 29.99f)
                    )
                )
            }
            R.id.manMenuTracksuits -> {


            }
            R.id.manMenuCoatsJackets -> {

            }
            R.id.manMenuTops -> {

            }
            R.id.manMenuSuits -> {

            }
            else -> {
                // Acciones por defecto o manejo de casos no especificados
            }
        }
        productAdapter?.updateData(li)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<RecListFragment>(R.id.fragment1)

        }

    }
}