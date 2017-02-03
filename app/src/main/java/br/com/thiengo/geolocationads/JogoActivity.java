package br.com.thiengo.geolocationads;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.thiengo.geolocationads.domain.Jogo;


public class JogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        ImageView imgCasa = (ImageView) findViewById(R.id.img_home);
        ImageView imgVisitante = (ImageView) findViewById(R.id.img_visitant);
        TextView goalsCasa = (TextView) findViewById(R.id.goals_home);
        TextView goalsVisitante = (TextView) findViewById(R.id.goals_visitan);

        if( getIntent() != null
                && getIntent().getParcelableExtra( Jogo.JOGO_KEY ) != null ){

            Jogo jogo = getIntent().getParcelableExtra( Jogo.JOGO_KEY );

            imgCasa.setImageResource( jogo.getTimeCasa().getImagem() );
            imgCasa.setContentDescription( jogo.getTimeCasa().getNome() );
            imgVisitante.setImageResource( jogo.getTimeVisitante().getImagem() );
            imgVisitante.setContentDescription( jogo.getTimeVisitante().getNome() );
            goalsCasa.setText( String.valueOf( jogo.getTimeCasaGoals() ) );
            goalsVisitante.setText( String.valueOf( jogo.getTimeVisitanteGoals() ) );
        }
        else{
            finish();
        }
    }
}
