package com.myturbofabricpackage.sample

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.myturbofabricpackage.NativeSampleModuleSpec

@ReactModule(name = SampleModule.NAME)
class SampleModule(reactContext: ReactApplicationContext) : NativeSampleModuleSpec(reactContext) {
    override fun getName() = NAME

    override fun getAppBuildNumber(promise: Promise) {
        promise.resolve(SampleSingleton.getAppBuildNumber(reactApplicationContext))
    }

    override fun getAppBundleId(promise: Promise) {
        promise.resolve(SampleSingleton.getAppBundleId(reactApplicationContext))
    }

    override fun getAppVersion(promise: Promise) {
        promise.resolve(SampleSingleton.getAppVersion(reactApplicationContext))
    }

    companion object {
        const val NAME = SampleSingleton.NAME
    }
}
