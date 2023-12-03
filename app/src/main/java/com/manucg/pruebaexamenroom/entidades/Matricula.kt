package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "matricula",
    primaryKeys = ["alumnoId", "asignaturaId"],
    foreignKeys = [
        ForeignKey(
            entity = Alumno::class,
            parentColumns = ["id"],
            childColumns = ["alumnoId"]
        ),
        ForeignKey(
            entity = Asignatura::class,
            parentColumns = ["id"],
            childColumns = ["asignaturaId"]
        )
    ]
)
data class Matricula(
    @ColumnInfo(name = "alumnoId")
    var alumnoId : Int,

    @ColumnInfo(name = "asignaturaId")
    var asignaturaId : Int
) {

    override fun toString(): String {
        return "Matricula (alumnoId= $alumnoId, asignaturaId= $asignaturaId)"
    }


}
