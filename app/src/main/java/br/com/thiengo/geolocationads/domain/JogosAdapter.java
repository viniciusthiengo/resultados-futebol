package br.com.thiengo.geolocationads.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import br.com.thiengo.geolocationads.R;


public class JogosAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Jogo> list;

    public JogosAdapter(Context context, List<Jogo> list){
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Jogo jogo = list.get(position);

        if( convertView == null ){
            convertView = layoutInflater.inflate(R.layout.jogo, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
            holder.setViewHolder( convertView );
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fillLayout( jogo );

        return convertView;
    }


    private class ViewHolder{
        ImageView imgCasa;
        ImageView imgVisitante;
        TextView goalsCasa;
        TextView goalsVisitante;

        private void setViewHolder( View convertView ){
            imgCasa = (ImageView) convertView.findViewById(R.id.img_home);
            imgVisitante = (ImageView) convertView.findViewById(R.id.img_visitant);
            goalsCasa = (TextView) convertView.findViewById(R.id.goals_home);
            goalsVisitante = (TextView) convertView.findViewById(R.id.goals_visitan);
        }

        private void fillLayout( Jogo jogo){
            imgCasa.setImageResource( jogo.getTimeCasa().getImagem() );
            imgCasa.setContentDescription( jogo.getTimeCasa().getNome() );
            imgVisitante.setImageResource( jogo.getTimeVisitante().getImagem() );
            imgVisitante.setContentDescription( jogo.getTimeVisitante().getNome() );
            goalsCasa.setText( String.valueOf( jogo.getTimeCasaGoals() ) );
            goalsVisitante.setText( String.valueOf( jogo.getTimeVisitanteGoals() ) );
        }
    }
}
