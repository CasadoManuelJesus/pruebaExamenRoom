package com.manucg.pruebaexamenroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(tableName = "profesor",
        foreignKeys = [
            ForeignKey(
                entity = Departamento::class,
                parentColumns = ["id"],
                childColumns = ["idDepartamento"]
            )
        ])
data class Profesor(
    @ColumnInfo(name = "nombre")
    var nombre: String,
    @ColumnInfo(name = "idDepartamento")
    var idDepartamento: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0
}