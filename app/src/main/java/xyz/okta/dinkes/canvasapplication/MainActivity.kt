package xyz.okta.dinkes.canvasapplication

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)

        val mBitmap = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888)
        imageView.setImageBitmap(mBitmap)
        val canvas = Canvas(mBitmap)

        val mPaint = Paint()
        val mPaint1 = Paint()

        mPaint.color = ResourcesCompat.getColor(resources, R.color.pink_200, null)
        mPaint1.color = ResourcesCompat.getColor(resources, R.color.pink_500, null)

        val mPainText = Paint(Paint.FAKE_BOLD_TEXT_FLAG)
        mPainText.textSize = 20F
        mPainText.color = ResourcesCompat.getColor(resources, R.color.white, null)


        val text = "Selamat Datang"
        val mBounds = Rect()
        mPainText.getTextBounds(text, 0, text.length, mBounds)

        val x: Int = mBitmap.width/2 - mBounds.centerX()
        val y: Int = mBitmap.height/2 - mBounds.centerY()

        canvas.save()

        canvas.drawColor(ResourcesCompat.getColor(resources, R.color.blue_500, null))
        canvas.drawText(text, x.toFloat(), y.toFloat(), mPainText)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas.clipOutRect(
                (mBitmap.width/2 - 100).toFloat(),
                (mBitmap.height/2 - 100).toFloat(),
                (mBitmap.width/2 + 100).toFloat(),
                (mBitmap.height/2 + 100).toFloat()
    //            mPaint1
            )
        }
        else{
            canvas.clipRect(
                (mBitmap.width/2 - 100F).toFloat(),
                (mBitmap.height/2 - 100F).toFloat(),
                (mBitmap.width/2 + 100F).toFloat(),
                (mBitmap.height/2 + 100F).toFloat()
                //            mPaint1
            )
        }

        canvas.drawCircle((mBitmap.width/2).toFloat(), (mBitmap.height/2).toFloat(), 200f, mPaint)
//        canvas.drawRect(
//            (mBitmap.width/2 - 100).toFloat(),
//            (mBitmap.height/2 - 100).toFloat(),
//            (mBitmap.width/2 + 100).toFloat(),
//            (mBitmap.height/2 + 100).toFloat(),
//            mPaint1
//        )



        canvas.restore()

        //clipping
    }
}