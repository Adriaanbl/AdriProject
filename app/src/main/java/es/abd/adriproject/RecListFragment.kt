package es.abd.adriproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import es.abd.adriproject.databinding.FragmentRecListBinding


class RecListFragment : Fragment() {

    private lateinit var binding: FragmentRecListBinding
    private lateinit var recyclerViewFragment: RecListFragment

    private lateinit var adapter: ProductAdapter
    private lateinit var lista: MutableList<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecListBinding.inflate(layoutInflater, container, false)
        recyclerViewFragment = RecListFragment()


        return binding.root
    }

    private fun setUpRecyclerView(){



        binding.recyclerListProduct.adapter = adapter

        binding.recyclerListProduct.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    companion object {
        fun newInstance(adapt: ProductAdapter): RecListFragment {
            val fragment = RecListFragment()
            val args = Bundle()

            fragment.adapter = adapt

            fragment.arguments = args
            return fragment
        }
    }


}