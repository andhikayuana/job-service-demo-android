package id.yuana.job.service.demo

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Mon 09 2018 13.53
 **/
class MainJobService : JobService() {

    companion object {
        val TAG: String = MainJobService::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "onCreate")
    }

    override fun onStartJob(jobParameters: JobParameters?): Boolean {

        Log.d(TAG, "onStartJob : " + jobParameters.toString())

        doTask()

        App.scheduleJobService(this)

        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {

        Log.d(TAG, "onStopJob")

        return true
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy")
    }

    private fun doTask() {
        Log.d(TAG, "doTask")
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

}