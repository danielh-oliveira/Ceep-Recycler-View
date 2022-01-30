package br.com.daniel.ceep.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.daniel.ceep.R;
import br.com.daniel.ceep.model.Nota;
import br.com.daniel.ceep.ui.recyclerview.adapter.listener.OnItemClickListener;


public class ListaNotasRecyclerAdapter extends RecyclerView.Adapter<ListaNotasRecyclerAdapter.NotaViewHolder> {

    private final List<Nota> notas;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public ListaNotasRecyclerAdapter(Context context, List<Nota> notas) {
        this.context = context;
        this.notas = notas;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ListaNotasRecyclerAdapter.NotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCriada = criaView(parent);
        return new NotaViewHolder(viewCriada);
    }

    private View criaView(ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_nota, parent, false);
        return viewCriada;
    }

    @Override
    public void onBindViewHolder(ListaNotasRecyclerAdapter.NotaViewHolder holder, int position) {
        Nota nota = notas.get(position);
        holder.vincula(nota);
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public void adiciona(Nota nota) {
        notas.add(nota);
        notifyDataSetChanged();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder {

        private final TextView titulo;
        private final TextView descricao;
        private Nota nota;

        public NotaViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.item_nota_titulo);
            descricao = itemView.findViewById(R.id.item_nota_descricao);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(nota);
                }
            });
        }

        public void vincula(Nota nota){
            this.nota = nota;
            preencheCampo(nota);
        }

        private void preencheCampo(Nota nota) {
            titulo.setText(nota.getTitulo());
            descricao.setText(nota.getDescricao());
        }
    }
}