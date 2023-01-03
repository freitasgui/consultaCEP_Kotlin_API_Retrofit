package com.example.consultacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.jsonurl.Utils
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cepconsultar = Utils.getInstance().create(ApiInterface::class.java)

        // elementos visuais

        val cep : EditText = findViewById(R.id.cepInserido)
        val logradouro : EditText = findViewById(R.id.rua_edit)
        val bairro : EditText = findViewById(R.id.bairro_edit)
        val estado : EditText = findViewById(R.id.localidade_edit)
        val uf : EditText = findViewById(R.id.uf)
        val btn : Button = findViewById(R.id.btn)

        btn.setOnClickListener(){

            GlobalScope.launch (Dispatchers.Main, CoroutineStart.DEFAULT) {
                val results = cepconsultar.getCep(cep.text.toString())

                if (results.isSuccessful && results.body() != null) {
                    Log.d("Tag", "${results.body()}")
                    logradouro.setText(results.body()!!.logradouro.toString())
                    bairro.setText(results.body()!!.bairro.toString())
                    estado.setText(results.body()!!.localidade.toString())
                    uf.setText(results.body()!!.uf.toString())
                    // texto.setText("${results.body()!![4-1].login}" + "${results.body()!![4-1].id}") // Aqui estou exibindo os dados do indice 4, lembrando que o array começa em zero. Seguido do ID conforme a JSON https://api.github.com/users
                }

            }
        }


    }
}