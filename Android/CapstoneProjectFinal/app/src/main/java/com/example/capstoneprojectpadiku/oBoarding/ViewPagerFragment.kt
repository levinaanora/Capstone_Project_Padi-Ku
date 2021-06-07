package com.example.introductionpages.oBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capstoneprojectpadiku.R
import com.example.introductionpages.oBoarding.screens.FirstFragment
import com.example.introductionpages.oBoarding.screens.SecondFragment
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

import org.tensorflow.lite.examples.classification.oBoarding.screens.ThridFragment


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentlist = arrayListOf<Fragment>(
                FirstFragment(),
                SecondFragment(),
                ThridFragment()
        )

        val adapter = ViewPagerAdapter(
                fragmentlist,
                requireActivity().supportFragmentManager,
                lifecycle
        )

    view.viewPager.adapter = adapter

        return view
    }

}