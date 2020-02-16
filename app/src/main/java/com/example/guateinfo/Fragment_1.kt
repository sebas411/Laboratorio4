package com.example.guateinfo


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.guateinfo.databinding.Fragment1Binding
import kotlinx.android.synthetic.main.fragment_1.*


/**
 * A simple [Fragment] subclass.
 */
class Fragment_1 : Fragment() {
    lateinit var editNombre: EditText
    lateinit var textNombre: TextView
    lateinit var showNombre: TextView
    private var set=true
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<Fragment1Binding>(
            inflater,
            R.layout.fragment_1, container, false
        )
        val title=""
        val phrase=""
        val description=""

        editNombre = binding.textoEditar
        textNombre = binding.textoNombre
        showNombre = binding.textoMostrar
        showNombre.visibility = View.INVISIBLE
        val starButton: ImageButton = binding.starButton
        starButton.setOnClickListener {
            setText()
        }

        binding.buttonAntigua.setOnClickListener{view:View ->

            view.findNavController().navigate(R.id.action_fragment_1_to_antiguaFragment)
        }
        binding.buttonPanajachel.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_fragment_1_to_panaFragment)
        }
        binding.buttonFlores.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_fragment_1_to_floresFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun setText() {
        if (set) {
            showNombre.setText(editNombre.getText())
            editNombre.visibility = View.INVISIBLE
            textNombre.visibility = View.INVISIBLE
            showNombre.visibility = View.VISIBLE
        }else{
            editNombre.visibility = View.VISIBLE
            textNombre.visibility = View.VISIBLE
            showNombre.visibility = View.INVISIBLE
        }
        set=!set
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }


}
