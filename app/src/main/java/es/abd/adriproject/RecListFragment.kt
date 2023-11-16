package es.abd.adriproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.abd.adriproject.databinding.FragmentRecListBinding


class RecListFragment : Fragment() {

    private lateinit var binding: FragmentRecListBinding
    private lateinit var recyclerViewFragment: RecListFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecListBinding.inflate(layoutInflater, container, false)
        recyclerViewFragment = RecListFragment()


        if ()

        return binding.root
    }

    fun updateRecyclerViewData(data: List<Product>) {
        recyclerViewFragment.updateRecyclerViewData(data)
    }
}