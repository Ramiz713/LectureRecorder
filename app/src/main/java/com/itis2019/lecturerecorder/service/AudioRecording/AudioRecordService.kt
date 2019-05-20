package com.itis2019.lecturerecorder.service.AudioRecording

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.itis2019.lecturerecorder.App.Companion.RECORDING_CHANNEL_ID
import com.itis2019.lecturerecorder.R
import com.itis2019.lecturerecorder.ui.MainActivity
import io.reactivex.Flowable

class AudioRecordService : Service(), AudioRecorder {

    private val audioRecorder = AudioRecorderImpl()

    private val binder = AudioRecordBinder()

    inner class AudioRecordBinder : Binder() {
        fun getService(): AudioRecordService = this@AudioRecordService
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val intent = Intent(this, MainActivity::class.java)
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, RECORDING_CHANNEL_ID)
            .setContentTitle("Recording...")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun getTime(): Flowable<Long> = audioRecorder.getTime()

    override fun startRecord() {
        audioRecorder.startRecord()
    }

    override fun pauseRecord() = audioRecorder.pauseRecord()

    override fun resumeRecord() = audioRecorder.resumeRecord()

    override fun getRawBytes(): Flowable<ByteArray> = audioRecorder.getRawBytes()

    override fun finishRecordWithSaving(): String =
        audioRecorder.finishRecordWithSaving()

    override fun finishRecordWithoutSaving() =
        audioRecorder.finishRecordWithoutSaving()
}
