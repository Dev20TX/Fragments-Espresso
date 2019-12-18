package com.example.fragmentapp


import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    private var fragmentA: FragmentA? = null
    private var fragmentB: FragmentB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = FragmentA()
        fragmentB = FragmentB()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_a, fragmentA!!)
            .replace(R.id.container_b, fragmentB!!)
            .commit()
    }

    override fun onInputASent(input: CharSequence) {
        fragmentB!!.updateEditText(input)
    }

    override fun onInputBSent(input: CharSequence) {
        fragmentA!!.updateEditText(input)
    }
}
