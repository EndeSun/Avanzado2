package es.ua.eps.avanzado2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btPantalla = findViewById<Button>(R.id.btPantalla)
        val btEstilos = findViewById<Button>(R.id.btEstilos)
        val btHilos = findViewById<Button>(R.id.btHilos)

        btPantalla.setOnClickListener{
            val pantallaIntent = Intent(this@MainActivity, PantallaTactil::class.java)
            startActivity(pantallaIntent)
        }

        btEstilos.setOnClickListener{
            val estilosIntent = Intent(this@MainActivity, EstilosTemas::class.java)
            startActivity(estilosIntent)
        }

        btHilos.setOnClickListener{
            val HilosIntent = Intent(this@MainActivity, PantallaTactil::class.java)
            startActivity(HilosIntent)
        }


    }
}