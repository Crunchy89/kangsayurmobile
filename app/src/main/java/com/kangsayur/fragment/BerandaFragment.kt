package com.kangsayur.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.kangsayur.AdapterSlider
import com.kangsayur.R
import java.util.ArrayList


class BerandaFragment : Fragment() {

    private lateinit var slider : ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view :View = inflater.inflate(R.layout.fragment_beranda,container,false)
        slider = view.findViewById(R.id.slider)
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider = AdapterSlider(arrSlider,activity)
        slider.adapter = adapterSlider

        return view
    }
}