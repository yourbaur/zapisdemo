package com.example.zapiskz.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.zapiskz.R
import com.example.zapiskz.ui.single_place.SinglePlace
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        var btnCheck:Button = view.findViewById(R.id.btn_check);
        btnCheck.setOnClickListener {
            val intent = Intent(context, SinglePlace::class.java)
            intent.putExtra("id", 206)
            this.startActivity(intent)
        }

        return view


    }

}
