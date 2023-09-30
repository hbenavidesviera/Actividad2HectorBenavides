package com.example.actividad2hectorbenavides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val data = ArrayList<ItemsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSpinner()
    }

    fun llenarCardViewAccion() {

        data.add(ItemsViewModel(R.drawable.sin_novedad_en_el_frente, "Sin novedad en el frente", "Paul, de 17 años, se une al Frente Occidental en la Primera Guerra Mundial, pero su entusiasmo inicial se ve truncado por la sombría realidad de la vida en las trincheras."))
        data.add(ItemsViewModel(R.drawable.soldadoryan, "Rescatando al soldado Ryan", "un clásico del cine belico, un film de culto" ))
        data.add(ItemsViewModel(R.drawable.john, "John Wick 4", "la última entrega de una saga brutal"))
        data.add(ItemsViewModel(R.drawable.rapido, "rapido y furiosos 10", "alabada por la critica, en la latinoamerica"))

    }



    fun llenarCardViewComedia(){
        data.add(ItemsViewModel(R.drawable.littleman, "Little man", "una pequeña gran pelicula"))
        data.add(ItemsViewModel(R.drawable.soncomoninos, "Son como niños 2", "la segunda parte de un clasico"))
        data.add(ItemsViewModel(R.drawable.simpsons,"los simpsons la pelicula", "un clasico para todas las edades"))
        data.add(ItemsViewModel(R.drawable.futurama, "Futurama", "la segunda entrega al cine de una leyenda"))

    }

    fun llenarCardViewSuspenso(){
        data.add(ItemsViewModel(R.drawable.fantasy,"fantasy Island", "un sesión de suspenso"))
        data.add(ItemsViewModel(R.drawable.glass, "Glass house", "una historia para recordar"))
        data.add(ItemsViewModel(R.drawable.exorcista, "el exorcista", "asustando por decadas"))
        data.add(ItemsViewModel(R.drawable.exorcista2, "el exorcista 2", "segunda entrega de una leyenda"))

    }

    fun initSpinner() {

        // accede a los items de la lista | Categoria es nombre de variable | el resorcesgetstrinarray() obtiene los items del archivo string.xml .
        val categoria = resources.getStringArray(R.array.Categorias)

        // accede al spinner ubicado en el layout, activity_main.xml .
        val spinner = findViewById<Spinner>(R.id.categorias)

        //Valida si no es nulo, hace el arrayadapter, toma el objeto seleccionado y lo almacena en la variable adapter.
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this, android.R.layout.simple_spinner_item, categoria
            )
            spinner.adapter = adapter
            //selector de la categoria al darle clic o touch.
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val categoriaSeleccionada = spinner.selectedItem.toString()

                    //seleccion de la categoria y al ser igual al nombre de la categoria, hace las siguientes acciones
                    when (categoriaSeleccionada) {
                        "Acción" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Ha seleccionado: PC",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewAccion()
                            initRecyclerView()

                        }

                        "Suspenso" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Ha seleccionado: Nintendo Switch",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewSuspenso()
                            initRecyclerView()
                        }

                        "Comedia" -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Ha seleccionado: PlayStation 5",
                                Toast.LENGTH_SHORT
                            ).show()
                            data.clear()
                            llenarCardViewComedia()
                            initRecyclerView()

                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
            private fun initRecyclerView() {
                // busca el id del recyclerView y lo guarda en la variable
                val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
                // Crea un layout de forma vertical | this creates a vertical layout Manager
                recyclerview.layoutManager = LinearLayoutManager(this)

                //Esto pasara el array a nuestro adaptador |This will pass the ArrayList to our Adapter
                val adapter = CustomAdapter(data)

                // Configuración del adaptador con el recyclerview | Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter


            }

}