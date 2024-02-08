package com.myturbofabricpackage.example

import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.ExampleViewManagerDelegate
import com.facebook.react.viewmanagers.ExampleViewManagerInterface

@ReactModule(name = ExampleView.NAME)
class ExampleViewManager : ViewGroupManager<ExampleView>(),
    ExampleViewManagerInterface<ExampleView> {
    private var mDelegate = ExampleViewManagerDelegate(this);

    override fun getDelegate() = mDelegate

    override fun getName() = ExampleView.NAME

    override fun createViewInstance(reactContext: ThemedReactContext): ExampleView {
        return ExampleView(reactContext)
    }

    @ReactProp(name = "colors")
    override fun setColors(view: ExampleView, colors: ReadableArray?) {
        if (colors == null) {
            return
        }
        view.setColors(colors.toArrayList().toList().map { (it as Double).toInt() })
    }

    @ReactProp(name = "locations")
    override fun setLocations(view: ExampleView, locations: ReadableArray?) {
        if (locations == null) {
            return
        }
        view.setLocations(locations.toArrayList().toList().map { (it as Double).toFloat() })
    }

    @ReactProp(name = "centerPoint")
    override fun setCenterPoint(view: ExampleView, centerPoint: ReadableMap?) {
        if (centerPoint == null) {
            return
        }
        val x = if (centerPoint.hasKey("x") && !centerPoint.isNull("x")) {
            centerPoint.getDouble("x")
        } else {
            0.5
        }
        val y = if (centerPoint.hasKey("y") && !centerPoint.isNull("y")) {
            centerPoint.getDouble("y")
        } else {
            0.5
        }
        view.setCenterPoint(x, y)
    }
}
