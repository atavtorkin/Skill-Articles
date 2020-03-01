package ru.skillbranch.skillarticles.extensions

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

fun Context.dpToPx(dp: Int): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        this.resources.displayMetrics

    )
}

fun Context.dpToIntPx(dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        this.resources.displayMetrics
    ).toInt()
}

fun Context.attrValue(attr: Int): Int {
    var value: Int? = null
    if (value == null) {
        val tv = TypedValue()
        if (this.theme.resolveAttribute(attr, tv, true)) value = tv.data
        else throw Resources.NotFoundException("Resource with id $attr not found")
    }
    return value
}
