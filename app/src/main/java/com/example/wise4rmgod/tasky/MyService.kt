package com.example.wise4rmgod.tasky

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MyService : Service() {
    private val TAG = "ServiceExample"
    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "Service onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"started.....")
        val currenttime= Calendar.getInstance().time

        var sdf =  SimpleDateFormat("yyyy-MM-dd HH:mm")
        var fortim=  sdf.format(currenttime)
        var wayo= "2018-11-01 14:27"
        if (fortim.equals(wayo)){
            Toast.makeText(this,"its  working wella", Toast.LENGTH_SHORT).show()
        }
        Log.d(TAG,"its working")
        Thread.sleep(1000)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        Log.d(TAG,"oncreate")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(TAG,"On Destroy")
        super.onDestroy()
    }
}
