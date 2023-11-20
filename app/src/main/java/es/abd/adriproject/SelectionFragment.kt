package es.abd.adriproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.abd.adriproject.databinding.FragmentSelectionBinding


class SelectionFragment : Fragment(), View.OnClickListener {

    private var listener : FragmentSelectionListener? = null

    private lateinit var binding: FragmentSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSelectionBinding.inflate(layoutInflater,container,false)

        binding.womanButton.setOnClickListener(this)
        binding.manButton.setOnClickListener(this)
        binding.navigationButton.setOnClickListener(this)

        return binding.root
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentSelectionListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement FragmentSelectionListener")
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.womanButton -> listener?.onWomanButtonClicked()
            R.id.manButton -> listener?.onManButtonClicked()
            R.id.navigationButton -> listener?.onNavigationButtonClicked()
        }
    }
    interface FragmentSelectionListener{
        fun onWomanButtonClicked()
        fun onManButtonClicked()
        fun onNavigationButtonClicked()


    }




}