package eu.acolombo.lockscreen

import android.content.ComponentName
import android.content.Context

inline fun <reified T : Any> Context.getComponentName(): ComponentName =
    ComponentName(this, T::class.java)
