package br.com.thiengo.geolocationads.domain;

import android.widget.AbsListView;

import br.com.thiengo.geolocationads.MainActivity;


public class ListViewScrollListener implements AbsListView.OnScrollListener {
    private MainActivity activity;
    private int limiteVisivel = 1; // APENAS UM OFFSET
    private int totalItensAnterior = 0;
    private boolean loading = true;


    public ListViewScrollListener( MainActivity activity ){
        this.activity = activity;
    }

    @Override
    public void onScroll(
            AbsListView absListView,
            int indexPrimeiroItemVisivel,
            int numeroItensVisiveis,
            int numeroItensLista) {

        if (loading) {
            /* VERIFICA SE JÁ PODE MUDAR O ESTADO DO OBJETO
             * PARA UM NOVO CARREGAMENTO */
            if (numeroItensLista > totalItensAnterior) {
                loading = false;
                totalItensAnterior = numeroItensLista;
            }
        }

        int condicaoLadoEsquerdo = numeroItensLista - numeroItensVisiveis;
        int condicaoLadoDireito = indexPrimeiroItemVisivel + limiteVisivel;

        if ( !loading && condicaoLadoEsquerdo <= condicaoLadoDireito ) {

            activity.loadProgressBar(true);
            new LoadDataAsyncTask().execute( activity );
            loading = true;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {}
}
