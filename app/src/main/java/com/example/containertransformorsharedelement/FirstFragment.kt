package com.example.containertransformorsharedelement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.Hold

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Transition 1
        val hold = Hold()
        hold.duration = 3000
        exitTransition = hold

        //Transition 2
        //Do nothing
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.cardView).setOnClickListener { card ->
            //Animation style 1
//            val extras = FragmentNavigatorExtras(card to "shared_element_container")
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, null, null, extras)

            //Animation style 2
            val extras = FragmentNavigatorExtras(
                view.findViewById<ImageView>(R.id.imageView) to "sharedImage",
                view.findViewById<TextView>(R.id.textView1) to "sharedText1",
                view.findViewById<TextView>(R.id.cardView) to "shared_element_container", //optional
                view.findViewById<TextView>(R.id.textView2) to "sharedText2")
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, null, null, extras)

        }
    }
}