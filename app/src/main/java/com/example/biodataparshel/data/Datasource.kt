package com.example.biodataparshel.data

import com.example.biodataparshel.R
import com.example.biodataparshel.model.Biodataparshel


class Datasource {
    fun Loadbiodataparshel(): List<Biodataparshel> {
        return listOf<Biodataparshel>(
            Biodataparshel(R.string.name),
            Biodataparshel(R.string.nim),
            Biodataparshel(R.string.address)
        )

    }
}