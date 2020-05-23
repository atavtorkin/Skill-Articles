package ru.skillbranch.skillarticles.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import androidx.navigation.NavDestination
import com.google.android.material.bottomnavigation.BottomNavigationView

fun View.setMarginOptionally(
    left: Int = marginLeft,
    top: Int = marginTop,
    right: Int = marginRight,
    bottom: Int = marginBottom
) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val params = layoutParams as ViewGroup.MarginLayoutParams
        params.leftMargin = left
        params.topMargin = top
        params.rightMargin = right
        params.bottomMargin = bottom
        requestLayout()
    }
}

fun View.setPaddingOptionally(
    left: Int = paddingLeft,
    right: Int = paddingRight,
    top: Int = paddingTop,
    bottom: Int = paddingBottom
) {
    setPadding(left, top, right, bottom)
}

fun BottomNavigationView.selectedDestination(destination: NavDestination) {
    menu.findItem(destination.id)?.let {
        it.isChecked = true
    }
}