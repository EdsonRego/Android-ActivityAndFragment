package com.edsonrego.appactivityandfragment

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var buttonFechar: Button
    lateinit var textFilme: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonFechar = findViewById(R.id.button_fechar)
        textFilme = findViewById(R.id.textFilme)

        val bundle = intent.extras //todos os parametros passados
        if(bundle != null) {

//            val filme = bundle.getString("filme")
//            val classificacao = bundle.getInt("classificacao")
//            val avaliacao = bundle.getDouble("avaliacao")
//            val resultado = "filme: $filme - Classeficacao: $classificacao - Avaliacao: $avaliacao"
//            textFilme.text = resultado

//            val filme = bundle.getSerializable("filme") as Filme

            val filme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("filme", Filme::class.java)
            } else {
                bundle.getParcelable("filme") as? Filme
            }

            textFilme.text = "filme: ${filme?.nome} - Classeficacao: ${filme?.descricao} - Avaliacao: ${filme?.avaliacao}"

        }
        buttonFechar.setOnClickListener {
            finish()
        }
    }
}