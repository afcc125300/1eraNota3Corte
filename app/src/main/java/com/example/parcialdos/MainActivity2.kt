package com.example.parcialdos

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.round

class MainActivity2 : AppCompatActivity() {
    private var textView1:TextView?=null
    private var editText1:EditText?=null
    private var editText2:EditText?=null
    private var editText3:EditText?=null
    private var editText4:TextView?=null

    private var contador=0
    private var listaProductos=ArrayList<Double>()

    private var total=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView1=findViewById(R.id.textView1)
        editText1=findViewById(R.id.editText1)
        editText2=findViewById(R.id.editText2)
        editText3=findViewById(R.id.editText3)
        editText4=findViewById(R.id.editText4)
    }
    fun agregar(view: View){
        var precio=textView1?.text.toString().toDouble()
        listaProductos.add(precio)

        contador++
        textView1?.setText("")
        var total=0.0
        listaProductos.forEach{
            total=total+it
        }

    }
    fun pagar(view: View){
        var pago=editText3?.text.toString().toDouble()
        var cambio=pago-total
        var centavos=cambio-cambio.toInt()
        if(centavos>0.0){
            val dialogo:AlertDialog.Builder=AlertDialog.Builder(this)
            dialogo.setTitle("¿Deseas donar tus centavos?")
            dialogo.setMessage("Haz click para donar %.2f".format(centavos)+" centavos")
            dialogo.setPositiveButton("Si"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"Gracias por donar %.2f".format(centavos)+" centavos",Toast.LENGTH_LONG).show()
                editText4?.text="Su cambio es de %.2f".format(cambio-centavos)
            }
            dialogo.setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"Gracias por nada por favor no regreses",Toast.LENGTH_LONG).show()
                editText4?.text="Su cambio es de %.2f".format(cambio)
            }
            val alerta:AlertDialog=dialogo.create()
            alerta.setCanceledOnTouchOutside(false)
            alerta.show()
        }else{
            editText4?.text="Su cambio es de %.2f".format(cambio)
        }
    }

}


