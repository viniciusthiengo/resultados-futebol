package br.com.thiengo.geolocationads.domain;

import android.os.Parcel;
import android.os.Parcelable;


public class Time implements Parcelable {
    private int imagem;
    private String nome;

    public Time(int imagem, String nome){
        this.imagem = imagem;
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imagem);
        dest.writeString(this.nome);
    }

    protected Time(Parcel in) {
        this.imagem = in.readInt();
        this.nome = in.readString();
    }

    public static final Parcelable.Creator<Time> CREATOR = new Parcelable.Creator<Time>() {
        @Override
        public Time createFromParcel(Parcel source) {
            return new Time(source);
        }

        @Override
        public Time[] newArray(int size) {
            return new Time[size];
        }
    };
}
