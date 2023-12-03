package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Alumno
import com.manucg.plantillaroom.entidades.Matricula

@Dao
interface InterfaceDaoMatricula {
    @Insert
    fun addMatricula(matricula : Matricula)

    @Query("SELECT * FROM matricula")
    fun getMatriculas() : MutableList<Matricula>

    @Query("SELECT * FROM matricula WHERE asignaturaId = :idAsignatura AND alumnoId = :idAlumno")
    fun getMatricula(idAsignatura : Int, idAlumno : Int) : Matricula

    @Query("SELECT alu.* FROM matricula m JOIN alumno alu ON m.alumnoId = alu.id JOIN asignatura asig ON m.asignaturaId = asig.id WHERE asig.nombre = :nombreAsignatura")
    fun getAlumnosByAsignatura(nombreAsignatura:String) : MutableList<Alumno>

    @Update
    fun updateMatricula(matricula : Matricula)

    @Delete
    fun deleteMatricula(matricula: Matricula)

    @Query("DELETE FROM matricula")
    fun borraTablaMatricula()
}
