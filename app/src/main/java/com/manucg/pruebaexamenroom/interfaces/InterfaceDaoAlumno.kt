package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Alumno

@Dao
interface InterfaceDaoAlumno {
    @Insert
    fun addAlumno(alumno : Alumno)

    @Query("SELECT * FROM alumno")
    fun getAlumnos() : MutableList<Alumno>

    @Query("SELECT * FROM alumno WHERE nombre LIKE :nombre")
    fun getAlumno(nombre: String) : Alumno

    @Query("SELECT * FROM alumno WHERE grupo LIKE :grupo")
    fun getAlumnoByGrupo(grupo : String) : MutableList<Alumno>

    @Update
    fun updateAlumno(alumno : Alumno)

    @Delete
    fun deleteAlumno(alumno: Alumno)

    @Query("DELETE FROM alumno")
    fun borraTablaAlumno()
}
