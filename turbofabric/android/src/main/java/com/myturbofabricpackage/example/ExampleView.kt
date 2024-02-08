package com.myturbofabricpackage.example

import android.content.Context;
import android.graphics.*
import android.widget.FrameLayout

class ExampleView(context: Context) : FrameLayout(context) {
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mPath = Path()
    private var mRect = RectF()
    private var mColors = listOf(Color.RED, Color.YELLOW)
    private var mLocations = listOf(0f, 1f)
    private var mCenterPointX = 0.5
    private var mCenterPointY = 0.5
    private var mWidth = 0
    private var mHeight = 0

    fun setColors(colors: List<Int>) {
        mColors = colors
        prepareGradient()
    }

    fun setLocations(locations: List<Float>) {
        mLocations = locations
        prepareGradient()
    }

    fun setCenterPoint(x: Double, y: Double) {
        mCenterPointX = x
        mCenterPointY = y
        prepareGradient()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
        preparePath()
        prepareGradient()
    }

    override fun dispatchDraw(canvas: Canvas) {
        canvas.drawPath(mPath, mPaint)
        super.dispatchDraw(canvas)
    }

    private fun preparePath() {
        mPath.reset()
        mRect.set(
            0f,
            0f,
            mWidth.toFloat(),
            mHeight.toFloat()
        )
        mPath.addRect(mRect, Path.Direction.CW)
    }

    private fun prepareGradient() {
        if (mColors.size != mLocations.size) {
            return
        }
        mPaint.shader = SweepGradient(
            (mCenterPointX * mWidth).toFloat(),
            (mCenterPointY * mHeight).toFloat(),
            mColors.toIntArray(),
            mLocations.toFloatArray()
        )
        invalidate()
    }

    companion object {
        const val NAME = "ExampleView"
    }
}
