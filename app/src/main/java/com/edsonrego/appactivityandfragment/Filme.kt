package com.edsonrego.appactivityandfragment

import android.os.Parcel
import android.os.Parcelable

data class Filme(
    val nome: String,
    val descricao: String,
    val avaliacao: Double,
    val diretor: String,
    val distribuidora: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(descricao)
        parcel.writeDouble(avaliacao)
        parcel.writeString(diretor)
        parcel.writeString(distribuidora)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Filme> {
        override fun createFromParcel(parcel: Parcel): Filme {
            return Filme(parcel)
        }

        override fun newArray(size: Int): Array<Filme?> {
            return arrayOfNulls(size)
        }
    }
}