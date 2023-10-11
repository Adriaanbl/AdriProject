package es.abd.adriproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.abd.adriproject.databinding.FragmentStartPageBinding

class fragmentStartPage : Fragment(), View.OnClickListener  {

    private var listener : fragmentStartPageListener? = null

    private lateinit var binding: FragmentStartPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartPageBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        return view

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    interface fragmentStartPageListener{

    }



}