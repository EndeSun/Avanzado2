package es.ua.eps.avanzado2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class MiComponente(context: Context, isBlue: Boolean = false) : View(context) {
    private val cajaPaint = Paint()
    private var cajaX = 20f
    private var cajaY = 20f


    init {
        if(isBlue){
            cajaPaint.color = Color.BLUE
        }else{
            cajaPaint.color = Color.RED
        }
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(cajaX, cajaY, cajaX + 50, cajaY + 50, cajaPaint)
    }

    var lastX = 0f
    var lastY = 0f
    var isMoving = false
    var isBlue: Boolean = false
        set(value) {
            field = value
            invalidate() // Redibujar la vista cuando se cambia el color
        }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        //Cogemos los valores de la posición donde pulsa el mouse
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // Comenzamos el movimiento si toca la caja
                if (x >= cajaX && x <= cajaX + 50 && y >= cajaY && y <= cajaY + 50) {
                    isMoving = true
                    lastX = x
                    lastY = y
                }
            }
            MotionEvent.ACTION_MOVE -> {
                // Si estamos en modo movimiento, actualizamos la posición de la caja
                if (isMoving) {
                    val dx = x - lastX
                    val dy = y - lastY
                    cajaX += dx
                    cajaY += dy
                    lastX = x
                    lastY = y
                    invalidate() // Redibujar la vista
                }
            }
            MotionEvent.ACTION_UP -> {
                // Dejamos de mover la caja cuando se levanta el dedo
                isMoving = false
            }
        }
        return true
    }
}