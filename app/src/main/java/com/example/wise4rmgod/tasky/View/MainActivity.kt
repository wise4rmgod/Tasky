package com.example.wise4rmgod.tasky.View

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.wise4rmgod.tasky.MainMvp
import com.example.wise4rmgod.tasky.Presenter.presenter
import com.example.wise4rmgod.tasky.R
import com.example.wise4rmgod.tasky.AlarmBroadcastReceiver
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),MainMvp.view {

    private var animation1: AnimationUtils?= null
    lateinit var mainpresenter : presenter
    var notificationId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainpresenter = presenter(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        time_picker.setIs24HourView(true)



        closesidemenu.setOnClickListener {
            val rightout = AnimationUtils.loadAnimation(applicationContext,
                R.anim.left_in)
            val fade = AnimationUtils.loadAnimation(applicationContext,
                R.anim.abc_fade_out)
            bottomlayout.visibility=View.VISIBLE
            sidemenulayout.visibility=View.GONE
            sidemenulayout.startAnimation(fade)
        }

        menubutton.setOnClickListener {


        }

        floatingActionButtonsave.setOnClickListener {
            val fade = AnimationUtils.loadAnimation(applicationContext,
                R.anim.abc_fade_out)
            bottomlayout.startAnimation(fade)
            bottomlayout.visibility=View.GONE
            bottommenuwithedittext.visibility=View.VISIBLE

        }

        savebtn.setOnClickListener {
            mainpresenter.savebtnclicked()

        }
    }

    override fun showsavebtn() {
        var alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val fade = AnimationUtils.loadAnimation(applicationContext,
            R.anim.abc_fade_out)
        bottommenuwithedittext.visibility=View.GONE
        bottomlayout.visibility=View.VISIBLE

        if (editextsave.text.isBlank()) {
            Toast.makeText(applicationContext, "Task Title is Required!!", Toast.LENGTH_SHORT).show()

        }
        else {
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, time_picker.hour)
                    set(Calendar.MINUTE, time_picker.minute)
                    set(Calendar.SECOND, 0)

                }.timeInMillis,
                PendingIntent.getBroadcast(
                    applicationContext,
                    0,
                    Intent(applicationContext, AlarmBroadcastReceiver::class.java).apply {
                        putExtra("notificationId", ++notificationId)
                        putExtra("reminder", editextsave.text)
                    },
                    PendingIntent.FLAG_CANCEL_CURRENT
                )
            )
            Toast.makeText(applicationContext, "SET!! ${editextsave.text}", Toast.LENGTH_SHORT).show()
            //  reset()
        }

    }

    override fun sidemenushow() {
        val rightout = AnimationUtils.loadAnimation(applicationContext,
            R.anim.left_in)
        val fade = AnimationUtils.loadAnimation(applicationContext,
            R.anim.abc_fade_out)
        bottomlayout.startAnimation(fade)
        bottomlayout.visibility=View.GONE
        sidemenulayout.visibility=View.VISIBLE
        sidemenulayout.startAnimation(rightout)

    }

    override fun closemenushow() {

    }

    override fun onResume() {
        super.onResume()
        reset()
    }

    private fun reset() {
        time_picker.apply {
            val now = Calendar.getInstance()
            hour = now.get(Calendar.HOUR_OF_DAY)
            minute = now.get(Calendar.MINUTE)
        }
        editextsave.setText("")
    }
}
