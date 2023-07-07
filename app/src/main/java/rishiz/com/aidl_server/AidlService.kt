package rishiz.com.aidl_server

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.util.Log
import kotlin.random.Random

class AidlService : Service() {
    companion object {
        private val TAG = AidlService::class.java.canonicalName
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.d(TAG, "onStartCommand")

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "onBind")
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    private val binder: IColorAidl.Stub = object : IColorAidl.Stub() {
        override fun isServiceSatarted(): Boolean {
            return true
        }

        override fun getColor(): Int {
            val rnd = Random.Default //kotlin.random
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        }
    }
}