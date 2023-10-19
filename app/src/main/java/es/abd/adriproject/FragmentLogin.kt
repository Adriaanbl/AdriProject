package es.abd.adriproject

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.abd.adriproject.databinding.FragmentLoginBinding


class FragmentLogin : Fragment(), View.OnClickListener {

    private var listener : FragmentLogin.fragmentLoginListener? = null

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)


        val videoView = binding.videoView
        videoView.setVideoURI(Uri.parse("android.resource://app/src/main/res/drawable/WADEN.mp4"))
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }


        return binding.root

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    interface fragmentLoginListener{

    }


}