package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Alumno
import com.manucg.pruebaexamenroom.entidades.Profesor

@Dao
interface InterfaceDaoProfesor {
    @Insert
    fun addProfesor(profesor : Profesor)

    @Query("SELECT * FROM profesor")
    fun getProfesores() : MutableList<Profesor>

    @Query("SELECT * FROM profesor WHERE nombre LIKE :nombre")
    fun getProfesor(nombre: String) : Profesor

    @Update
    fun updateProfesor(profesor : Profesor)

    @Delete
    fun deleteProfesor(profesor: Profesor)

    @Query("DELETE FROM profesor")
    fun borraTablaProfesor()
}
