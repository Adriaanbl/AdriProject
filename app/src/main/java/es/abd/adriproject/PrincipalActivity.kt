package es.abd.adriproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class PrincipalActivity : AppCompatActivity(), SelectionFragment.FragmentSelectionListener, ManFragment.FragmentManListener {

    val li: MutableList<Product> = mutableListOf()

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

    private var productAdapter: ProductAdapter = ProductAdapter(this,li){product ->  }

    override fun onManMenuButtonClicked(btn: Int) {

        li.clear()
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
                li.addAll(
                    listOf(Product("zapas", R.drawable.product3, 69.99f),
                    )
                )
            }
            else -> {

            }
        }
        productAdapter.updateData(li)
        val recListFragment = RecListFragment.newInstance(productAdapter)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment2, recListFragment)
            addToBackStack(null)

        }



    }
}