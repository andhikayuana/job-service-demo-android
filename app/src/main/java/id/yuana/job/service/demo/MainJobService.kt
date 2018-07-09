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

    override fun onStopJob(p0: JobParameters?): Boolean {

        Log.d(TAG, "onStopJob")

        return false
    }

    override fun onStartJob(p0: JobParameters?): Boolean {

        Log.d(TAG, "onStartJob")

        App.scheduleJobService(this)

        return true
    }

}