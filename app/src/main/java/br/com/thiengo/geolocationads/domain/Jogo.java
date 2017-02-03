package br.com.thiengo.geolocationads.domain;

import android.os.Parcel;
import android.os.Parcelable;


public class Jogo implements Parcelable {
    public static final String JOGO_KEY = "jogo_key";

    private Time timeCasa;
    private Time timeVisitante;
    private int timeCasaGoals;
    private int timeVisitanteGoals;


    public Jogo(Time timeCasa,
                Time timeVisitante,
                int timeCasaGoals,
                int timeVisitanteGoals){
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.timeCasaGoals = timeCasaGoals;
        this.timeVisitanteGoals = timeVisitanteGoals;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public int getTimeCasaGoals() {
        return timeCasaGoals;
    }

    public int getTimeVisitanteGoals() {
        return timeVisitanteGoals;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.timeCasa, flags);
        dest.writeParcelable(this.timeVisitante, flags);
        dest.writeInt(this.timeCasaGoals);
        dest.writeInt(this.timeVisitanteGoals);
    }

    protected Jogo(Parcel in) {
        this.timeCasa = in.readParcelable(Time.class.getClassLoader());
        this.timeVisitante = in.readParcelable(Time.class.getClassLoader());
        this.timeCasaGoals = in.readInt();
        this.timeVisitanteGoals = in.readInt();
    }

    public static final Parcelable.Creator<Jogo> CREATOR = new Parcelable.Creator<Jogo>() {
        @Override
        public Jogo createFromParcel(Parcel source) {
            return new Jogo(source);
        }

        @Override
        public Jogo[] newArray(int size) {
            return new Jogo[size];
        }
    };
}
