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
import es.abd.adriproject.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment(), View.OnClickListener {

    private var listener : RegisterFragment.fragmentRegisterListener? = null

    private lateinit var binding: FragmentRegisterBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is fragmentRegisterListener){
            listener = context
        }else {
            throw Exception("EXCEPPCION")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)

        val videoView = binding.videoView
        val videoPath = "android.resource://" + requireContext().packageName + "/" + R.raw.backvideoregister
        videoView?.setVideoURI(Uri.parse(videoPath))
        videoView?.setOnPreparedListener { mp ->
            mp.isLooping = true
        }


        videoView?.start()

        binding.btnRegfragment.setOnClickListener(this)

        return binding.root

    }


    override fun onClick(v: View) {
        when(v.id){
            R.id.btnRegfragment -> {

                val name = binding.reguserinput.text.toString()
                val email = binding.reggmailinput.text.toString()
                val password = binding.regpassinput.text.toString()
                val confirmPassword = binding.regrepeatpassinput.text.toString()


                if (password == confirmPassword) {
                    val user = User(name, email, password)
                    addUser(user)

                    listener?.onRegFragmentbtn()

                } else {
                    Snackbar.make(binding.root,R.string.SnackRegisterError, Snackbar.LENGTH_SHORT).show()
                }
                }
        }
    }

    interface fragmentRegisterListener{
        fun onRegFragmentbtn()
    }

    companion object {

        private val registeredUsers: MutableList<User> = mutableListOf()

        fun checkCredentials(emailOrUsername: String, password: String): Boolean {

            return registeredUsers.any { it.email == emailOrUsername || it.name == emailOrUsername && it.password == password }
        }

        fun addUser(user: User) {
            registeredUsers.add(user)
        }

        fun getUser(): User {
            return registeredUsers[0]
        }

        fun removeUser(){
            registeredUsers.removeAt(0)
        }
    }




}