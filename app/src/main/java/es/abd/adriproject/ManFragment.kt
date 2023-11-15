package es.abd.adriproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.abd.adriproject.databinding.FragmentManBinding
import es.abd.adriproject.databinding.FragmentWomanBinding

class ManFragment : Fragment() {

    private var listener : FragmentManListener? = null

    private lateinit var binding: FragmentManBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    interface FragmentManListener{

    }


}