package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grupo")
data class Grupo (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    var id : String,
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name="aula")
    var aula: String
    ){

    override fun toString(): String {
        return "Grupo (id= $id, nombre=$nombre, aula=$aula)"
    }

}
