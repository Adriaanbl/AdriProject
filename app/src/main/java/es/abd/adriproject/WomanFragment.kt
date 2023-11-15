package es.abd.adriproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.abd.adriproject.databinding.FragmentSelectionBinding
import es.abd.adriproject.databinding.FragmentWomanBinding

class WomanFragment : Fragment() {

    private var listener : FragmentWomanListener? = null

    private lateinit var binding: FragmentWomanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWomanBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    interface FragmentWomanListener{

    }


}