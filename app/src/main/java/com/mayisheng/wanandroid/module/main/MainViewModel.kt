package com.mayisheng.wanandroid.module.main

import android.view.MenuItem
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationBarView
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.module.home.HomeFragment
import com.mayisheng.wanandroid.module.mine.MineFragment
import com.mayisheng.wanandroid.module.project.ProjectFragment
import com.mayisheng.wanandroid.module.square.SquareFragment
import com.mayisheng.wanandroid.module.wxaccount.WxAccountFragment

class MainViewModel : ViewModel() {
    val fragments = arrayListOf<Fragment>()
    private val mHomeFragment: HomeFragment by lazy { HomeFragment() }
    private val mProjectFragment: ProjectFragment by lazy { ProjectFragment() }
    private val mSquareFragment: SquareFragment by lazy { SquareFragment() }
    private val mWxAccountFragment: WxAccountFragment by lazy { WxAccountFragment() }
    private val mMineFragment: MineFragment by lazy { MineFragment() }

    init {
        fragments.apply {
            add(mHomeFragment)
            add(mProjectFragment)
            add(mSquareFragment)
            add(mWxAccountFragment)
            add(mMineFragment)
        }
    }

    //ObservableField只有在数据发生改变时UI才会收到通知，而LiveData不同，只要你postValue或者setValue，UI都会收到通知，不管数据有无变化
    //LiveData能感知Activity的生命周期，在Activity不活动的时候不会触发，例如一个Activity不在任务栈顶部
    var currentItem: ObservableField<Int> = ObservableField<Int>(0)
    var onPageChangeCallback: ViewPager2.OnPageChangeCallback =
        object : ViewPager2.OnPageChangeCallback() {
            @Override
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentItem.set(position)
            }
        }
    var onItemSelectedListener: NavigationBarView.OnItemSelectedListener =
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> currentItem.set(0)
                R.id.menu_project -> currentItem.set(1)
                R.id.menu_square -> currentItem.set(2)
                R.id.menu_official_account -> currentItem.set(3)
                R.id.menu_mine -> currentItem.set(4)
            }
            true
        }

}