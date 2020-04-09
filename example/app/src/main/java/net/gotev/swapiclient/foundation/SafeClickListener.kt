package net.gotev.swapiclient.foundation

import android.os.SystemClock
import android.view.View

/**
 * Implements the "throttle first" mechanism for click listeners, to prevent double taps.
 *
 * How it works:
 * - Define a sampling window time (default: 500ms)
 * - when you click at time T0, the first click gets dispatched and the subsequent ones happening
 *   between T0 and T0 + WindowTime gets ignored
 */
inline fun View.onSafeClick(throttleTime: Int = 500, crossinline listener: (View) -> Unit) {
    var clickTime = 0L

    setOnClickListener {
        if (SystemClock.uptimeMillis() <= (clickTime + throttleTime)) return@setOnClickListener
        clickTime = SystemClock.uptimeMillis()
        listener(it)
    }
}
