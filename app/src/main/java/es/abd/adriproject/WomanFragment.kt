package es.abd.adriproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import es.abd.adriproject.databinding.FragmentSelectionBinding
import es.abd.adriproject.databinding.FragmentWomanBinding

class WomanFragment : Fragment(), View.OnClickListener {

    private var listener : FragmentWomanListener? = null

    private lateinit var binding: FragmentWomanBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentWomanListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement YourListenerInterface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWomanBinding.inflate(layoutInflater,container,false)

        binding.womanMenuBottom.setOnClickListener(this)
        binding.womanMenuJumpsuit.setOnClickListener(this)
        binding.womanMenuCoatsJackets.setOnClickListener(this)
        binding.womanMenuTops.setOnClickListener(this)
        binding.womanMenuDresses.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View) {
        listener?.onWomanMenuButtonClicked(v.id)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.womanMenuBottom.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in1))
        binding.womanMenuJumpsuit.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in2))
        binding.womanMenuCoatsJackets.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in3))
        binding.womanMenuTops.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in4))
        binding.womanMenuDresses.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in5))
    }

    interface FragmentWomanListener{
        fun onWomanMenuButtonClicked(btn: Int)


    }



}