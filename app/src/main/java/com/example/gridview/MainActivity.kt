package com.example.gridview

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var frutas = ArrayList<Fruta>();
        frutas.add(Fruta("manzana",R.drawable.manzana))
        frutas.add(Fruta("Platano",R.drawable.platano))
        frutas.add(Fruta("Durazno",R.drawable.durazno))
        frutas.add(Fruta("Sandia",R.drawable.sandia))
        frutas.add(Fruta("manzana",R.drawable.manzana))
        frutas.add(Fruta("Platano",R.drawable.platano))
        frutas.add(Fruta("Durazno",R.drawable.durazno))


        //Esto es para un grid view normal
       /* frutas.add("Plátano")
        frutas.add("Manzano")
        frutas.add("Guinio")
        frutas.add("Otra frutita")
        frutas.add("Durazno")
        frutas.add("Frutita :D")*/

        var grid: GridView = findViewById(R.id.grid)
        //var adaptador = ArrayAdapter<Fruta>(this, android.R.layout.simple_list_item_1, frutas)
        var adaptor= Adaptador(this,frutas)
        grid.adapter = adaptor

        grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            /*Toast.makeText(this,"El indice es ${index}",Toast.LENGTH_SHORT).show()*/
            when (position) {
                1 -> {
                    val intent = Intent(this, SegundaActividad::class.java)
                    startActivity(intent)
                }

                2 -> {
                    val intent = Intent(this, terceraActividad::class.java)
                    startActivity(intent)
                }
                else ->{
                    Snackbar.make(
                        view, // Parent view
                        "Hi from position $position", // Message to show

                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).setBackgroundTint(Color.parseColor("#FF108714")).show()
                }
            }

        }
    }
}
