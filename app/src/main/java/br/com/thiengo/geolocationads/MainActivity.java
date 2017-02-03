package br.com.thiengo.geolocationads;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.thiengo.geolocationads.domain.Jogo;
import br.com.thiengo.geolocationads.domain.JogosAdapter;
import br.com.thiengo.geolocationads.domain.ListViewScrollListener;
import br.com.thiengo.geolocationads.extras.Mock;


public class MainActivity extends AppCompatActivity {

    private List<Jogo> jogos;
    private JogosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initResultados();
    }

    private void initResultados(){

        ListView listView = (ListView) findViewById(R.id.list_view);
        jogos = Mock.resultadosJogos();

        adapter = new JogosAdapter(this, jogos);
        listView.setAdapter( adapter );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, JogoActivity.class);
                intent.putExtra( Jogo.JOGO_KEY, jogos.get(position) );
                startActivity(intent);
            }
        });

        /* SCROLL PARA CARREGAR MAIS ITENS NO LISTVIEW */
        ListViewScrollListener scrollListener = new ListViewScrollListener( this );
        listView.setOnScrollListener( scrollListener );
    }

    public void updateListView( List<Jogo> gamesAnteriores ){
        this.jogos.addAll( gamesAnteriores );
        adapter.notifyDataSetChanged();
    }

    public void loadProgressBar(boolean status){
        try{
            int visibility = status ? View.VISIBLE : View.GONE;
            findViewById(R.id.progress_bar).setVisibility(visibility);
        }
        catch(Exception e){
            ((ViewStub) findViewById(R.id.vs_progress_bar)).inflate();
        }
    }
}

