package es.abd.adriproject

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import es.abd.adriproject.databinding.ActivityPrincipalBinding
import org.w3c.dom.Text

class PrincipalActivity : AppCompatActivity(), SelectionFragment.FragmentSelectionListener, ManFragment.FragmentManListener, WomanFragment.FragmentWomanListener,
    NavigationView.OnNavigationItemSelectedListener,DialogFragment.dialogFragmentListener {

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
                Toast.makeText(this, "Shopping cart", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.ic_helpQuestions -> {
                Toast.makeText(this, "Help & Questions", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
                RegisterFragment.removeUser()
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> false
        }

    }


    private var productAdapter: ProductAdapter = ProductAdapter(this,li){product ->

        val dialog = DialogFragment(product)
        dialog.view?.findViewById<TextView>(R.id.dialogTitle)?.text = product.productName

        dialog.show(supportFragmentManager,"my_dialog")

    }

    override fun onManMenuButtonClicked(btn: Int) {

        li.clear()
        when (btn) {
            R.id.manMenuBottom -> {
                li.addAll(
                    listOf(Product("black pants", R.drawable.bot1, 69.99f),
                        Product("polo blue pants", R.drawable.bot2, 149.99f),
                        Product("nike pants", R.drawable.bot3, 57.99f),
                        Product("comfort gray pants", R.drawable.bot4, 45.55f),
                        Product("nike too pants", R.drawable.bot5, 99.99f),
                        Product("sleeper pants", R.drawable.bot6, 29.19f),

                        )
                )
            }
            R.id.manMenuTracksuits -> {
                li.addAll(
                    listOf(Product("JJ tracksuit", R.drawable.track1, 69.99f),
                        Product("stripes tracksuit", R.drawable.track2, 149.99f),
                        Product("puma tracksuit", R.drawable.track3, 57.99f),
                        Product("jordan tracksuit", R.drawable.track4, 45.55f),
                        Product("hummus tracksuit", R.drawable.track5, 99.99f),
                        Product("arias tracksuit", R.drawable.track6, 29.19f),

                        )
                )
            }
            R.id.manMenuCoatsJackets -> {
                li.addAll(
                    listOf(Product("dirt suit", R.drawable.coat1, 69.99f),
                        Product("CalvinKeen suit", R.drawable.jacket1, 149.99f),
                        Product("shadow suit", R.drawable.coat2, 57.99f),
                        Product("black vaquera", R.drawable.jacket2, 45.55f),
                        Product("white coat", R.drawable.coat3, 99.99f),
                        Product("black jacket", R.drawable.jacket3, 29.19f),

                        )
                )
            }
            R.id.manMenuTops -> {
                li.addAll(
                    listOf(Product("75 shirt", R.drawable.top1, 69.99f),
                        Product("green forest top", R.drawable.top2, 149.99f),
                        Product("square shirt", R.drawable.top3, 57.99f),
                        Product("CreamKill shirt", R.drawable.top4, 45.55f),
                        Product("whitesquare shirt", R.drawable.top5, 99.99f),
                        Product("graphic shirt", R.drawable.top6, 29.19f),

                        )
                )
            }
            R.id.manMenuSuits -> {
                li.addAll(
                    listOf(Product("pokemon suit", R.drawable.suit1, 69.99f),
                        Product("christmas suit", R.drawable.suit2, 149.99f),
                        Product("black suit", R.drawable.suit3, 57.99f),
                        Product("gray suit", R.drawable.suit4, 45.55f),
                        Product("blue suit", R.drawable.suit5, 99.99f),
                        Product("red suit", R.drawable.suit6, 29.19f),

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
                    listOf(Product("greenD jeans", R.drawable.wbot1, 69.99f),
                        Product("blueSnow jeans", R.drawable.wbot2, 149.99f),
                        Product("redSnow jeans", R.drawable.wbot3, 57.99f),
                        Product("bell jeans", R.drawable.wbot4, 45.55f),
                        Product("damaged jeans", R.drawable.wbot5, 99.99f),
                        Product("white jeans", R.drawable.wbot6, 29.19f),

                        )
                )
            }
            R.id.womanMenuJumpsuit -> {
                li.addAll(
                    listOf(Product("dark jumpsuit", R.drawable.jump1, 69.99f),
                        Product("bluewater jumpsuit", R.drawable.jump2, 149.99f),
                        Product("metal jumpsuit", R.drawable.jump3, 57.99f),
                        Product("whitness jumpsuit", R.drawable.jump4, 45.55f),
                        Product("red jumpsuit", R.drawable.jump5, 99.99f),
                        Product("noir jumpsuit", R.drawable.jump6, 29.19f),

                        )
                )

            }
            R.id.womanMenuCoatsJackets -> {
                li.addAll(
                    listOf(Product("black coat", R.drawable.wcoat1, 69.99f),
                        Product("vainilla jacket", R.drawable.wjack1, 149.99f),
                        Product("fresh gray coat", R.drawable.wcoat2, 57.99f),
                        Product("red jacket", R.drawable.wjack2, 45.55f),
                        Product("noir coat", R.drawable.wcoat3, 99.99f),
                        Product("big black jack", R.drawable.wjack3, 29.19f),

                        )
                )
            }
            R.id.womanMenuTops -> {
                li.addAll(
                    listOf(Product("basic top", R.drawable.wtop1, 69.99f),
                        Product("galaxy top", R.drawable.wtop2, 149.99f),
                        Product("red top", R.drawable.wtop3, 57.99f),
                        Product("greenwave top", R.drawable.wtop4, 45.55f),
                        Product("shadow top", R.drawable.wtop5, 99.99f),
                        Product("levis top", R.drawable.wtop6, 29.19f),

                        )
                )
            }
            R.id.womanMenuDresses -> {
                li.addAll(
                    listOf(Product("whiteLong dress", R.drawable.dres1, 69.99f),
                        Product("point dress", R.drawable.dres2, 149.99f),
                        Product("blackblue dress", R.drawable.dres3, 57.99f),
                        Product("black dress", R.drawable.dres4, 45.55f),
                        Product("flower dress", R.drawable.dres5, 99.99f),
                        Product("red dress", R.drawable.dres6, 29.19f),

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

    override fun onDialogPositiveClick() {
        Snackbar.make(binding.root, getString(R.string.buyButton),Snackbar.LENGTH_LONG).show()
    }

    override fun onDialogNegativeClick() {
        onBackPressedDispatcher.onBackPressed()
    }

}