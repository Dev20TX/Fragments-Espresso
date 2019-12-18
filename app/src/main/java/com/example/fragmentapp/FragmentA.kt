package com.example.fragmentapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {
    private var listener: FragmentAListener? = null
    private var editText: EditText? = null
    private var buttonAlright: Button? = null

    interface FragmentAListener {
        fun onInputASent(input: CharSequence)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_a, container, false)

        editText = v.findViewById(R.id.edit_text)
        buttonAlright = v.findViewById(R.id.button_alright)
        buttonAlright!!.setOnClickListener {
            val input = editText!!.text
            listener!!.onInputASent(input)
        }

        return v
    }

    fun updateEditText(newText: CharSequence) {
        editText!!.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement FragmentAListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}


