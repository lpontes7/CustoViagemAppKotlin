package com.lpontes7.custoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity() : AppCompatActivity(), View.OnClickListener {


    override fun onClick(view: View) {
        val id = view.id
        if (id==R.id.butttonCalcular){
            calcular()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butttonCalcular.setOnClickListener(this)
    }

    private fun validar():Boolean{
        return editDistancia.text.toString()!="" &&
                editPreco.text.toString()!=""&&
                editAutonomia.text.toString()!="0"
    }

    private fun calcular() {
        if (validar()){
            try{
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAutonomia.text.toString().toFloat()

                var resultado = ((distancia*preco)/autonomia)
                textResultado.text = "R$: $resultado"
            }
            catch (e:NumberFormatException){
                mensagemErroValidacao()
            }
        } else
            mensagemErroValidacao()
    }

    private fun mensagemErroValidacao(){
        Toast.makeText(this, getString(R.string.valores_validos),Toast.LENGTH_LONG).show()
    }

}
