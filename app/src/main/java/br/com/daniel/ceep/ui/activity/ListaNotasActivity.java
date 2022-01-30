package br.com.daniel.ceep.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.daniel.ceep.R;
import br.com.daniel.ceep.dao.NotaDAO;
import br.com.daniel.ceep.model.Nota;
import br.com.daniel.ceep.ui.recyclerview.adapter.ListaNotasRecyclerAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recycler_view);

        NotaDAO dao = new NotaDAO();

        for (int i = 0; i < 10000; i++){
            dao.insere(new Nota("Primeira nota" + i, "Primeira descrição" + i));
        }
        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasRecyclerAdapter(this, todasNotas));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);
    }
}