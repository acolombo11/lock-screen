package eu.acolombo.lockscreen

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.content.getSystemService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponentName<AdminManagerReceiver>().let { name ->
            getSystemService<DevicePolicyManager>()?.let { manager ->
                if (!manager.isAdminActive(name)) {
                    startActivity(getDeviceAdminIntent(name))
                } else {
                    manager.lockNow()
                }
            }
        }
        finish()
    }

    private fun getDeviceAdminIntent(name: ComponentName) =
        Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
            .putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, name)
}
