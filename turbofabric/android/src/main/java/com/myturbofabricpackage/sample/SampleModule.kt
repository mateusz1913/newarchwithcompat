package com.myturbofabricpackage.sample

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = SampleModule.NAME)
class SampleModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName() = NAME

    @ReactMethod
    fun getAppBuildNumber(promise: Promise) {
        promise.resolve(SampleSingleton.getAppBuildNumber(reactApplicationContext))
    }

    @ReactMethod
    fun getAppBundleId(promise: Promise) {
        promise.resolve(SampleSingleton.getAppBundleId(reactApplicationContext))
    }

    @ReactMethod
    fun getAppVersion(promise: Promise) {
        promise.resolve(SampleSingleton.getAppVersion(reactApplicationContext))
    }

    companion object {
        const val NAME = SampleSingleton.NAME
    }
}
