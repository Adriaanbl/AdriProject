package es.abd.adriproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.abd.adriproject.databinding.FragmentStartPageBinding

class StartPageFragment : Fragment(), View.OnClickListener {

    private var listener : startPageFragmentListener? = null

    private lateinit var binding: FragmentStartPageBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is startPageFragmentListener){
            listener = context
        }else {
            throw Exception("EXCEPPCION")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartPageBinding.inflate(layoutInflater,container,false)

        binding.LoginButton.setOnClickListener(this)
        binding.NotLoggedButton.setOnClickListener(this)

        return binding.root

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.LoginButton -> listener?.onLoginButtonClicked()
            R.id.NotLoggedButton -> listener?.onNotLoggedButtonClicked()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface startPageFragmentListener{
        fun onLoginButtonClicked()
        fun onNotLoggedButtonClicked()
    }



}