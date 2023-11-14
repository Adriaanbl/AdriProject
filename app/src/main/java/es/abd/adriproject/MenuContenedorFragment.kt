package es.abd.adriproject

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import es.abd.adriproject.databinding.FragmentLoginBinding
import es.abd.adriproject.databinding.FragmentMenuContenedorBinding
import es.abd.adriproject.databinding.FragmentStartPageBinding


class MenuContenedorFragment : Fragment() {

    private var listener : fragmentMenuContenedorListener? = null

    private lateinit var binding: FragmentMenuContenedorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuContenedorBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager = childFragmentManager
        val transaction = fragmentManager.beginTransaction()

        // Primer fragmento
        val fragment1 = SelectionFragment()
        transaction.replace(R.id.container, fragment1)
        transaction.addToBackStack(null)

        // Segundo fragmento
        val fragment2 = ContentFragment()
        val layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutParams.gravity = Gravity.BOTTOM  // Ajusta la gravedad para que comience desde la mitad de la pantalla hacia abajo
        fragment2.view?.layoutParams = layoutParams

        transaction.add(R.id.container, fragment2)
        transaction.addToBackStack(null)

        transaction.commit()
    }


    interface fragmentMenuContenedorListener{

    }

}