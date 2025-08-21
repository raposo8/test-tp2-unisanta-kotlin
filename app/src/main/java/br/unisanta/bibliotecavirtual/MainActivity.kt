package br.unisanta.bibliotecavirtual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.bibliotecavirtual.model.Livro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtTitle = findViewById<EditText>(R.id.edt_book_title)
        val edtAuthor = findViewById<EditText>(R.id.edt_book_author)
        val btnCadastrar = findViewById<Button>(R.id.btn_register)
        val fabMostra = findViewById<FloatingActionButton>(R.id.fab_switch_activity)

        var livro = Livro("", "")

        btnCadastrar.setOnClickListener {
            val titulo = edtTitle.text.toString()
            val autor = edtAuthor.text.toString()
            livro = Livro(titulo, autor)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Cadastro OK!")
            val dialog = builder.create()
            dialog.show()

            edtTitle.text.clear()
            edtAuthor.text.clear()
        }

        fabMostra.setOnClickListener {
            val intent = Intent(this, LivroActivity::class.java)
            intent.putExtra("autor", livro.autorLivro.toString())
            intent.putExtra("titulo", livro.tituloLivro.toString())
            startActivity(intent)
        }
    }
}