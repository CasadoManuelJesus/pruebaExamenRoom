package com.manucg.pruebaexamenroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "departamento")
data class Departamento(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="id")
    var id : String,

    @ColumnInfo(name="nombre")
    var nombre : String
)  {
}