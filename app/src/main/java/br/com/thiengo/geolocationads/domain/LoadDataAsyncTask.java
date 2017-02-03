package br.com.thiengo.geolocationads.domain;

import android.os.AsyncTask;
import android.os.SystemClock;

import java.lang.ref.WeakReference;
import java.util.List;

import br.com.thiengo.geolocationads.MainActivity;
import br.com.thiengo.geolocationads.extras.Mock;


public class LoadDataAsyncTask extends AsyncTask<MainActivity, Void, List> {
    private WeakReference<MainActivity> activity;

    @Override
    protected List doInBackground(MainActivity... activities) {
        activity = new WeakReference<>( activities[0] );

        /* DELAY PARA SIMULAR LATÊNCIA DE REDE
         * NO CARREGAMENTO DE NOVOS ITENS */
        SystemClock.sleep(3000);
        return Mock.resultadosJogos();
    }

    @Override
    protected void onPostExecute(List games) {
        super.onPostExecute(games);

        if( activity.get() != null ){
            activity.get().loadProgressBar(false);
            activity.get().updateListView( games );
        }
    }
}
