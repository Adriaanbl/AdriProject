package es.abd.adriproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.navigation.NavigationView
import es.abd.adriproject.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity(), SelectionFragment.FragmentSelectionListener, ManFragment.FragmentManListener, WomanFragment.FragmentWomanListener,
    NavigationView.OnNavigationItemSelectedListener {

    val li: MutableList<Product> = mutableListOf()

    private lateinit var binding: ActivityPrincipalBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpNavigationDrawer()
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

    override fun onNavigationButtonClicked() {

        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun setUpNavigationDrawer(){
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        binding.drawerLayout.closeDrawer(GravityCompat.START)

        return when(item.itemId){
            R.id.ic_cart -> {
                Toast.makeText(this, "Information saved correctly", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.ic_helpQuestions -> {
                Toast.makeText(this, "Information saved correctly", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.ic_account -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<AccountFragment>(R.id.actPrincipal)
                }
                true
            }
            R.id.ic_logout -> {
                Toast.makeText(this, "Information saved correctly", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }

    }

    private var productAdapter: ProductAdapter = ProductAdapter(this,li){product ->  }

    override fun onManMenuButtonClicked(btn: Int) {

        li.clear()
        when (btn) {
            R.id.manMenuBottom -> {
                li.addAll(
                    listOf(Product("Bottom 1", R.drawable.product1, 19.99f),
                        Product("Bottom 2", R.drawable.product2, 29.99f),
                        Product("victor", R.drawable.product3, 02.99f)


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
                    listOf(Product("pokemon suit", R.drawable.suit1, 69.99f),
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
            setCustomAnimations(R.anim.complex_animation, 0, 0, 0)
            replace(R.id.fragment2, recListFragment)
            addToBackStack(null)

        }
    }

    override fun onWomanMenuButtonClicked(btn: Int) {
        li.clear()
        when (btn) {
            R.id.womanMenuBottom -> {
                li.addAll(
                    listOf(Product("woman 1", R.drawable.product1, 19.99f),
                        Product("wimenn 2", R.drawable.product2, 29.99f)
                    )
                )
            }
            R.id.womanMenuJumpsuit -> {


            }
            R.id.womanMenuCoatsJackets -> {
                li.addAll(
                    listOf(Product("woman 1", R.drawable.product1, 19.99f)
                    )
                )
            }
            R.id.womanMenuTops -> {

            }
            R.id.womanMenuDresses -> {
                li.addAll(
                    listOf(Product("zapas de wimen", R.drawable.product3, 69.99f),
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
            setCustomAnimations(R.anim.complex_animation, 0, 0, 0)
            addToBackStack(null)

        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}