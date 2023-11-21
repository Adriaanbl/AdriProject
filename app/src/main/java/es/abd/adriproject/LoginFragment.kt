package es.abd.adriproject

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import es.abd.adriproject.databinding.FragmentLoginBinding


class LoginFragment : Fragment(), View.OnClickListener {

    private var listener : fragmentLoginListener? = null

    private lateinit var binding: FragmentLoginBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is fragmentLoginListener){
            listener = context
        }else {
            throw Exception("EXCEPPCION")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)


        val videoView = binding.videoView
        val videoPath = "android.resource://" + requireContext().packageName + "/" + R.raw.backvideo
        videoView?.setVideoURI(Uri.parse(videoPath))
        videoView?.setOnPreparedListener { mp ->
            mp.isLooping = true
        }


        videoView?.start()

        binding.btnLogfragment.setOnClickListener(this)

        return binding.root

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnLogfragment -> {

                val usernameOrEmail = binding.loguserinput.text.toString()
                val password = binding.logpassinput.text.toString()

                if (RegisterFragment.checkCredentials(usernameOrEmail, password)) {

                    listener?.onLogFragmentBtnClicked()

                } else {

                    Snackbar.make(binding.root,R.string.SnackloginError, Snackbar.LENGTH_SHORT).show()
                }

            }
        }
    }

    interface fragmentLoginListener{
        fun onLogFragmentBtnClicked()
    }


}