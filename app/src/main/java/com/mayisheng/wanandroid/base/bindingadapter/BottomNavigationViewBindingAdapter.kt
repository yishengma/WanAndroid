package com.mayisheng.wanandroid.base.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

object BottomNavigationViewBindingAdapter {
    @BindingAdapter(value = ["itemSelected"], requireAll = false)
    @JvmStatic
    fun setItemSelected(navigationView: BottomNavigationView, position: Int) {
        navigationView.menu.getItem(position).isChecked = true
    }


    @BindingAdapter(value = ["selectedListener"], requireAll = false)
    @JvmStatic
    fun setOnItemSelectedListener(
        navigationView: BottomNavigationView,
        selectedListener: NavigationBarView.OnItemSelectedListener
    ) {
        navigationView.setOnItemSelectedListener(selectedListener)
    }

}