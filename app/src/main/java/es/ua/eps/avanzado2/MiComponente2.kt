package es.ua.eps.avanzado2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class MiComponente2(context: Context) : View(context) {
    private val paint = Paint()
    private var boxX = 100
    private var boxY = 100
    private var isBoxTouched = false
    private var isBoxBlue = false
    private val gestureDetector = GestureDetector(context, MyGestureListener())

    init {
        paint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = if (isBoxBlue) Color.BLUE else Color.RED
        canvas.drawRect(boxX.toFloat(), boxY.toFloat(), (boxX + 50).toFloat(), (boxY + 50).toFloat(), paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
        //Cuando presiona
        override fun onDown(e: MotionEvent): Boolean {
            val x = e.x.toInt()
            val y = e.y.toInt()
            //Para comprobar si el ratón pulsado está dentro de la caja.
            if (x >= boxX && x <= boxX + 50 && y >= boxY && y <= boxY + 50) {
                isBoxTouched = true
                return true
            }
            return false
        }

        //Para controlar el movimiento
        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            if (isBoxTouched) {
                boxX += distanceX.toInt()
                boxY += distanceY.toInt()
                invalidate()
            }
            return true
        }

        //Para cambiar el color cuando toca la caja
        override fun onSingleTapUp(e: MotionEvent): Boolean {
            if (isBoxTouched) {
                isBoxBlue = !isBoxBlue
                invalidate()
            }
            return true
        }

        //Para el movimiento onFling
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (isBoxTouched) {
                // Calcular la nueva posición basada en la velocidad del fling
                boxX = (e2?.x?.toInt() ?: 0) - 25
                boxY = (e2?.y?.toInt() ?: 0) - 25
                invalidate()
            }
            return true
        }
    }
}