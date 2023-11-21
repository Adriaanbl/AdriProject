package es.abd.adriproject

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View

import androidx.fragment.app.DialogFragment
import es.abd.adriproject.databinding.FragmentDialogBinding
import es.abd.adriproject.databinding.FragmentLoginBinding


class DialogFragment(product: Product) : DialogFragment(){
    private lateinit var mListener: DialogFragmentListener
    private lateinit var binding: FragmentDialogBinding
    private val prod = product

    interface DialogFragmentListener{
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is DialogFragmentListener){
            mListener = context
        }else{
            throw Exception("Your fragment or activity must implement the interface FirstDialogListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.priceDialog.text = prod.price.toString()
        binding.dialogTitle.text = "prod.productName"
        binding.prdImgDialog.setImageResource(prod.image)

    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            builder
                .setView(inflater.inflate(R.layout.fragment_dialog,null))
                .setPositiveButton(getString(R.string.buyButton)) { dialog, id ->
                    mListener.onDialogPositiveClick()

                }
                .setNegativeButton(getString(R.string.cancelBuyBtn)) {dialog, id ->
                    mListener.onDialogNegativeClick()
                }
            builder.create()
        } ?: throw java.lang.IllegalStateException("Activity cant be null")
    }
}