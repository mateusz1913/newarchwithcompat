package com.myturbofabricpackage

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.ReactApplicationContext
import com.myturbofabricpackage.example.ExampleViewManager
import com.myturbofabricpackage.sample.SampleModule

class MyTurboFabricReactPackage : ReactPackage {
    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ) = listOf(SampleModule(reactContext))

    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ) = listOf(ExampleViewManager())
}
