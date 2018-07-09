package id.yuana.job.service.demo

import android.app.Application
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import java.util.concurrent.TimeUnit

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Mon 09 2018 11.52
 **/
class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {

        fun scheduleJobService(context: Context) {

            val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

            val componentName = ComponentName(context, MainJobService::class.java)

            val jobInfo = JobInfo.Builder(1, componentName)
                    .setMinimumLatency(TimeUnit.SECONDS.toMillis(60))
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setPersisted(true)
                    .build()

            jobScheduler.schedule(jobInfo)
        }
    }
}