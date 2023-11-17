package es.abd.adriproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import es.abd.adriproject.databinding.FragmentManBinding
import es.abd.adriproject.databinding.FragmentWomanBinding

class ManFragment : Fragment(), View.OnClickListener {

    private var listener : FragmentManListener? = null

    private lateinit var binding: FragmentManBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentManListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement YourListenerInterface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManBinding.inflate(layoutInflater,container,false)

        binding.manMenuBottom.setOnClickListener(this)
        binding.manMenuTracksuits.setOnClickListener(this)
        binding.manMenuCoatsJackets.setOnClickListener(this)
        binding.manMenuTops.setOnClickListener(this)
        binding.manMenuSuits.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View) {
        listener?.onManMenuButtonClicked(v.id)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.manMenuBottom.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in1))
        binding.manMenuTracksuits.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in2))
        binding.manMenuCoatsJackets.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in3))
        binding.manMenuTops.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in4))
        binding.manMenuSuits.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_in5))
    }

    interface FragmentManListener{
        fun onManMenuButtonClicked(btn: Int)

    }



}