package net.gotev.swapiclient

import android.app.Application
import net.gotev.swapi.initializeSwapiClient

/**
 * @author Aleksandar Gotev
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeSwapiClient(this)

        //LeakCanary.config = LeakCanary.config.copy(retainedVisibleThreshold = 1)
    }
}
