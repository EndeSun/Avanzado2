package es.ua.eps.avanzado2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.core.app.NavUtils

class PantallaTactil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_tactil)

        val btTC = findViewById<Button>(R.id.btTactil)
        val btGestos = findViewById<Button>(R.id.btGestos)

        btTC.setOnClickListener{
            val touchIntent = Intent(this@PantallaTactil, touchScreen_ejercicio1::class.java)
            startActivity(touchIntent)
        }

        btGestos.setOnClickListener{
            val gestosIntent = Intent(this@PantallaTactil, gestures_ejercicio2::class.java)
            startActivity(gestosIntent)
        }
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