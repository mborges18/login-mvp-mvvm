package com.example.loginmvpmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.loginmvpmvvm.adapters.ViewPagerAdapter
import com.example.loginmvpmvvm.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpWithTabs()

    }

    fun setUpWithTabs(){

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position ->
            when (position){
                0 ->{
                    tab.text = "Login"
                }
                1 ->{
                    tab.text = "Cadastro"
                }
            }
        }.attach()

    }
}
