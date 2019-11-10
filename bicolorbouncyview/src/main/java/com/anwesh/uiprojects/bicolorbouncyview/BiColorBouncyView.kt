package com.anwesh.uiprojects.bicolorbouncyview

/**
 * Created by anweshmishra on 10/11/19.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val nodes : Int = 5
val scGap : Float = 0.01f
val sizeFactor : Float = 2.9f
val delay : Long = 20
val color1 : Int = Color.parseColor("#673AB7")
val color2 : Int = Color.parseColor("#f44336")
val backColor : Int = Color.parseColor("#BDBDBD")
val doneMessage : String = "DONE"
val fontSizeFactor : Float = 4f
val textColor : Int = Color.WHITE

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawFadeOutBox(size : Float, sf : Float, paint : Paint) {
    paint.color = color2
    for (j in 0..1) {
        save()
        translate(1f, 1f - 2 * j)
        drawRect(RectF(-size, size * sf, size, size), paint)
        restore()
    }
}

fun Canvas.drawFadeInBox(size : Float, sf : Float, paint : Paint) {
    paint.color = color1
    drawRect(RectF(-size * sf, -size, size * sf, size), paint)
}

fun Canvas.drawDoneText(size : Float, scale : Float, paint : Paint) {
    paint.color = textColor
    val tw : Float = paint.measureText(doneMessage)
    save()
    scale(scale, scale)
    drawText(doneMessage, -tw / 2, -paint.textSize / 4, paint)
    restore()
}

fun Canvas.drawBCBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.textSize = size / fontSizeFactor
    save()
    translate(w / 2, gap * (i + 1))
    drawFadeOutBox(size, scale.divideScale(0, 2).sinify(), paint)
    drawDoneText(size, scale.divideScale(1, 2), paint)
    restore()
}
