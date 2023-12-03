package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Asignatura

@Dao
interface InterfaceDaoAsignatura {
    @Insert
    fun addAsignatura(alumno : Asignatura)

    @Query("SELECT * FROM asignatura")
    fun getAsignaturas() : MutableList<Asignatura>

    @Query("SELECT * FROM asignatura WHERE nombre LIKE :nombre")
    fun getAsignatura(nombre: String) : Asignatura

    @Update
    fun updateAsignatura(alumno : Asignatura)

    @Delete
    fun deleteAsignatura(alumno: Asignatura)

    @Query("DELETE FROM asignatura")
    fun borraTablaAsignatura()
}
