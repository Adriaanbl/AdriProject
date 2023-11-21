package es.abd.adriproject

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import es.abd.adriproject.databinding.FragmentDialogBinding


class DialogFragment : DialogFragment() {


    private var listener : dialogFragmentListener? = null

    private lateinit var binding: FragmentDialogBinding



    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is dialogFragmentListener){
            listener = context
        }else {
            throw Exception("Error adrian blasco doria")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDialogBinding.inflate(layoutInflater, container, false)

        DialogFragment().show(requireActivity().supportFragmentManager, "Buying dialog")

        return binding.root

    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_dialog, null)


            builder
                .setView(view)
                .setNegativeButton(getString(R.string.cancelBuyBtn)) { _, _ ->
                    listener?.onDialogNegativeClick()
                }
                .setPositiveButton(getString(R.string.buyButton)) { _, _ ->
                    listener?.onDialogPositiveClick()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity can not be null")
    }

    interface dialogFragmentListener{
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

}