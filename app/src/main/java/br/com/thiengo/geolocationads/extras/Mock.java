package br.com.thiengo.geolocationads.extras;

import java.util.ArrayList;
import java.util.List;
import br.com.thiengo.geolocationads.R;
import br.com.thiengo.geolocationads.domain.Jogo;
import br.com.thiengo.geolocationads.domain.Time;


public class Mock {
    public static List<Jogo> resultadosJogos(){
        List<Jogo> jogos = new ArrayList<>();
        jogos.add( new Jogo(
                new Time(R.drawable.ec_flamengo, "Flamengo"),
                new Time(R.drawable.ec_santa_cruz, "Santa Cruz"), 3, 0) );
        jogos.add( new Jogo(
                new Time(R.drawable.ec_cruzeiro, "Cruzeiro"),
                new Time(R.drawable.ec_ponte_preta, "Ponte Preta"), 2, 0) );
        jogos.add( new Jogo(
                new Time(R.drawable.ec_figueirense, "Figuerense"),
                new Time(R.drawable.ec_botafogo, "Botafogo"), 0, 1) );
        jogos.add( new Jogo(
                new Time(R.drawable.ec_corinthians, "Corinthians"),
                new Time(R.drawable.ec_atletico_mg, "Atlético MG"), 0, 0) );
        jogos.add( new Jogo(
                new Time(R.drawable.ec_sport_recife, "Sport Recife"),
                new Time(R.drawable.ec_sao_paulo, "São Paulo"), 0, 0) );
        jogos.add( new Jogo(
                new Time(R.drawable.ec_santos, "Santos"),
                new Time(R.drawable.ec_fluminense, "Fluminense"), 2, 1) );
        jogos.add( new Jogo(
                new Time(R.drawable.ec_internacional, "Internacional"),
                new Time(R.drawable.ec_coritiba, "Coritiba"), 1, 0) );
        jogos.add( new Jogo(
                new Time(R.drawable.ec_america_mg, "América MG"),
                new Time(R.drawable.ec_palmeiras, "Palmeiras"), 0, 2) );
        return jogos;
    }
}
