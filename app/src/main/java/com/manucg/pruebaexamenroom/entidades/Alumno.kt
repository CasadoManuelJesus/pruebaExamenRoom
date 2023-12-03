package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "alumno",
    foreignKeys = [
        ForeignKey(
            entity = Grupo::class,
            parentColumns = ["id"],
            childColumns = ["grupo"]
        )
    ]
)
data class Alumno(
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name="apellido")
    var apellido : String,
    @ColumnInfo(name="grupo")
    var grupo: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id : Int = 0

    override fun toString(): String {
        return "Alumno(id= $id, nombre= $nombre, apellidos=$apellido, grupo=$grupo)"
    }

}
