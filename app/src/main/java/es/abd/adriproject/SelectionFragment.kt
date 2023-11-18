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

        return binding.root
    }

    fun openDrawer(view: View) {
        // Obtener la actividad y abrir el Navigation Drawer
        if (activity is PrincipalActivity) {
            (activity as PrincipalActivity).openDrawer()
        }
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
        }
    }
    interface FragmentSelectionListener{
        fun onWomanButtonClicked()
        fun onManButtonClicked()

    }




}