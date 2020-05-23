package ru.skillbranch.skillarticles.extensions

/**
 * Created on 2020-01-21.
 *
 * @author Alexander Tavtorkin (av.tavtorkin@gmail.com)
 */

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("en"))
    return dateFormat.format(this)
}