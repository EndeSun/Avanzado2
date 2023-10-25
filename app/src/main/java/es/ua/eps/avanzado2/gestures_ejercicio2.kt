package es.ua.eps.avanzado2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MenuItem
import android.view.MotionEvent
import androidx.core.app.NavUtils
import androidx.core.view.GestureDetectorCompat

class gestures_ejercicio2 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestures_ejercicio2)
        val cajaView = MiComponente2(this)
        setContentView(cajaView)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == android.R.id.home) { // ID especial para botón "home"
            NavUtils.navigateUpTo(this,
                Intent(this, MainActivity::class.java)
            )
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}