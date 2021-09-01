package com.mayisheng.wanandroid.base.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

object ViewPagerBindingAdapter {

    @BindingAdapter(value = ["currentItem"], requireAll = false)
    @JvmStatic
    fun setCurrentItem(viewPager: ViewPager2, index: Int) {
        viewPager.setCurrentItem(index, false)
    }


    @BindingAdapter(value = ["pageChangeCallback"], requireAll = false)
    @JvmStatic
    fun addOnPageChangeListener(
        viewPager: ViewPager2,
        onPageChangeCallback: ViewPager2.OnPageChangeCallback
    ) {
        viewPager.registerOnPageChangeCallback(onPageChangeCallback)
    }

    @BindingAdapter(value = ["fragmentActivity", "fragments"], requireAll = true)
    @JvmStatic
    fun setAdapter(
        viewPager: ViewPager2,
        fragmentActivity: FragmentActivity,
        fragments: List<Fragment>
    ) {
        viewPager.adapter = object : FragmentStateAdapter(fragmentActivity) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }
    }

    @BindingAdapter(value = ["userInputEnable"])
    @JvmStatic
    fun setIsUserInputEnable(viewPager: ViewPager2, enable: Boolean) {
        viewPager.isUserInputEnabled = enable
    }


}