package com.example.wise4rmgod.tasky.View

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.wise4rmgod.tasky.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var animation1: AnimationUtils?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val rightout = AnimationUtils.loadAnimation(applicationContext,
            R.anim.left_in)
        val fade = AnimationUtils.loadAnimation(applicationContext,
            R.anim.abc_fade_out)

        closesidemenu.setOnClickListener {

            bottomlayout.visibility=View.VISIBLE
            sidemenulayout.visibility=View.GONE
            sidemenulayout.startAnimation(fade)
        }

        menubutton.setOnClickListener {
            bottomlayout.startAnimation(fade)
            bottomlayout.visibility=View.GONE
            sidemenulayout.visibility=View.VISIBLE
            sidemenulayout.startAnimation(rightout)

        }

        floatingActionButtonsave.setOnClickListener {

            bottomlayout.startAnimation(fade)
            bottomlayout.visibility=View.GONE
            bottommenuwithedittext.visibility=View.VISIBLE
        }

        savebtn.setOnClickListener {
            bottommenuwithedittext.visibility=View.GONE
            bottomlayout.visibility=View.VISIBLE
        }
    }
}
