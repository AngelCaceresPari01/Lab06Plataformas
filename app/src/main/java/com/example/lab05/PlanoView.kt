package com.example.lab05

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View

class PlanoView(context: Context) : View(context) {

    private val paint = Paint()
    private val ambientes = mutableListOf<Ambiente>()
    var onAmbienteClick: ((Ambiente) -> Unit)? = null

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        cargarDesdeArchivo()
    }

    private fun cargarDesdeArchivo() {
        val inputStream = context.resources.openRawResource(R.raw.ambientes)
        val lineas = inputStream.bufferedReader().readLines()

        for (linea in lineas) {
            val partes = linea.split(",")
            if (partes.size >= 6) {
                val nombre = partes[0]
                val x1 = partes[1].toFloat()
                val y1 = partes[2].toFloat()
                val x2 = partes[3].toFloat()
                val y2 = partes[4].toFloat()
                val color = Color.parseColor(partes[5])
                ambientes.add(Ambiente(nombre, x1, y1, x2, y2, color))
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (a in ambientes) {
            paint.color = a.color
            canvas.drawRect(a.x1, a.y1, a.x2, a.y2, paint)

            paint.color = Color.BLACK
            paint.textSize = 36f
            canvas.drawText(a.nombre, a.x1 + 20, a.y1 + 50, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val x = event.x
            val y = event.y
            for (a in ambientes) {
                if (x in a.x1..a.x2 && y in a.y1..a.y2) {
                    onAmbienteClick?.invoke(a)
                    return true
                }
            }
        }
        return true
    }
}
