package es.abd.adriproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import es.abd.adriproject.databinding.FragmentStartPageBinding

class fragmentStartPage : Fragment(), View.OnClickListener, View.OnFocusChangeListener  {

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

        binding.button.onFocusChangeListener = this

        return view

    }

    override fun onClick(v: View?) {

    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {

        val hoverAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.button_hover_anim)


        if (hasFocus) {
            binding.button.startAnimation(hoverAnim)
        } else {
            binding.button.clearAnimation()
        }
    }

    interface fragmentStartPageListener{

    }



}