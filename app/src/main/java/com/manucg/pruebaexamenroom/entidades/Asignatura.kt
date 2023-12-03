package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asignatura")
data class Asignatura(
    @ColumnInfo(name = "nombre")
    var nombre : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0

    override fun toString(): String {
        return "Entidad4 (id= $id, nombre= $nombre)"
    }


}
