package com.example.view_pager_project.Fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.view_pager_project.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var mBinding: FragmentMainBinding
    var titles = listOf("Personal", "Address")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentMainBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        mBinding.subBtn.setOnClickListener {
            if (ValidateDetails(mBinding.viewPage.currentItem)) {
                mBinding.viewPage.currentItem = mBinding.viewPage.currentItem + 1
            }
        }
    }

    private fun ValidateDetails(currentPage: Int): Boolean {
        when (currentPage) {
            0 -> {
                val frag = fragmentManager?.fragments?.filterIsInstance<PersonalFragment>() as PersonalFragment
//                val frag = mBinding.viewPage.adapter?.instantiateItem(mBinding.viewPage, 0) as PersonalFragment
//                val frag = mBinding.viewPage.adapter?.getItemId(0) as PersonalFragment
                return frag?.ValidatePersonal()
            }
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init() {
        mBinding.viewPage.adapter = ViewPagerFragmentAdapter(this, titles)
        TabLayoutMediator(mBinding.tabLyt, mBinding.viewPage,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = titles[position]
            }
        ).attach()
        mBinding.viewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        mBinding.subBtn.setText("Next")
                        PersonalFragment()
                    }
                    else -> {
                        AddressFragment()
                        mBinding.subBtn.setText("Submit")
                    }
                }
            }
        })
    }
}

class ViewPagerFragmentAdapter(frag: Fragment, var titles: List<String>) :
    FragmentStateAdapter(frag) {
    override fun getItemCount(): Int {
        return titles.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                PersonalFragment()
            }
            else -> {
                AddressFragment()
            }
        }
    }
}