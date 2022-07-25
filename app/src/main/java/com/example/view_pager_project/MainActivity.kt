package com.example.view_pager_project

import android.app.FragmentContainer
import android.app.FragmentTransaction
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.view_pager_project.Fragments.MainFragment
import com.example.view_pager_project.Fragments.PersonalFragment
import com.example.view_pager_project.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_lyt, MainFragment()).commit()
        }
    }
}
