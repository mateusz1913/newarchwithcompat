package com.myturbofabricpackage.sample

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build

object SampleSingleton {
    fun getAppBuildNumber(context: Context): String {
        var buildNumber = "unknown"
        try {
            buildNumber = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                getPackageInfo(context).longVersionCode.toString()
            } else {
                @Suppress("DEPRECATION")
                getPackageInfo(context).versionCode.toString()
            }
        } catch (_: Exception) {}
        return buildNumber
    }

    fun getAppBundleId(context: Context) = context.packageName as String

    fun getAppVersion(context: Context): String {
        var appVersion = "unknown"
        try {
            appVersion = getPackageInfo(context).versionName
        } catch (_: Exception) {}
        return appVersion
    }

    private fun getPackageInfo(context: Context): PackageInfo {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context
                .packageManager
                .getPackageInfo(
                    context.packageName,
                    PackageManager.PackageInfoFlags.of(0L)
                )
        } else {
            @Suppress("DEPRECATION")
            context
                .packageManager
                .getPackageInfo(context.packageName, 0)
        }
    }

    const val NAME = "SampleModule"
}
