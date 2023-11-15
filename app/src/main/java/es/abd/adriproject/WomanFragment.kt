package es.abd.adriproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in1))
        binding.button2.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in2))
        binding.button3.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in3))
        binding.button4.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in4))
        binding.button5.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in5))
    }

    interface FragmentWomanListener{

    }


}