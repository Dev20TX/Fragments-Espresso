package com.example.fragmentapp


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {
    private var listener: FragmentBListener? = null
    private var editText: EditText? = null
    private var buttonAlright: Button? = null

    interface FragmentBListener {
        fun onInputBSent(input: CharSequence)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_b, container, false)

        editText = v.findViewById(R.id.edit_text)
        buttonAlright = v.findViewById(R.id.button_alright)
        buttonAlright!!.setOnClickListener {
            val input = editText!!.text
            listener!!.onInputBSent(input)
        }

        return v
    }

    fun updateEditText(newText: CharSequence) {
        editText!!.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentBListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement FragmentBListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}

