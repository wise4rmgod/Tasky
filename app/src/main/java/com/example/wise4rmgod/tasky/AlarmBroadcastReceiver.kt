package com.example.wise4rmgod.tasky

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import com.example.wise4rmgod.tasky.View.MainActivity

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        (context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(
            intent!!.getIntExtra("notificationId", 0),
            Notification.Builder(context).apply {
                setSmallIcon(android.R.drawable.ic_popup_reminder)
                setContentTitle("Today's Task")
                setContentText(intent.getCharSequenceExtra("reminder"))
                setWhen(System.currentTimeMillis())
                setPriority(Notification.PRIORITY_DEFAULT)
                setAutoCancel(true)
                setSound(notification)
                setDefaults(Notification.DEFAULT_SOUND)
                setDefaults(Notification.DEFAULT_VIBRATE)
                setDefaults(Notification.DEFAULT_LIGHTS)
                setContentIntent(PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), 0))
            }.build()
        )
    }
}