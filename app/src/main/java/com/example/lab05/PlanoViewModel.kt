package com.example.lab05

import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.ViewModel

class PlanoViewModel : ViewModel() {

    fun mostrarInfoAmbiente(ambiente: Ambiente, context: Context) {
        val mensaje = """
            Nombre: ${ambiente.nombre}
            Área: ${ambiente.area()} m²
            Color: ${ambiente.colorHex}
        """.trimIndent()

        AlertDialog.Builder(context)
            .setTitle("Información del ambiente")
            .setMessage(mensaje)
            .setPositiveButton("Cerrar", null)
            .show()
    }
}
