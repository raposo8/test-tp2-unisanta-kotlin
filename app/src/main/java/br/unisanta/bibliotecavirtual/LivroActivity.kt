package br.unisanta.bibliotecavirtual

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LivroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_livro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvLivro = findViewById<TextView>(R.id.txv_livro);
        val fabVolta= findViewById<FloatingActionButton>(R.id.fab_volta);

        val autor = intent.getStringExtra("autor")
        val titulo = intent.getStringExtra("titulo")
        txvLivro.text = "Livro cadastrado: \n" +
                "Titulo: $titulo\n" +
                "Autor: $autor"

        fabVolta.setOnClickListener {
            finish()
        }
    }
}