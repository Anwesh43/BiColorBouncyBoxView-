package com.anwesh.uiprojects.linkedbicolorbouncyboxview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.bicolorbouncyview.BiColorBouncyView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BiColorBouncyView.create(this)
    }
}
