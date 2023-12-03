package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Grupo
import com.manucg.pruebaexamenroom.entidades.Departamento

@Dao
interface InterfaceDaoDepartamento {
    @Insert
    fun addDepartamento(departamento : Departamento)

    @Query("SELECT * FROM grupo")
    fun getDepartamentos() : MutableList<Departamento>

    @Query("SELECT * FROM departamento WHERE id LIKE :idDepartamento")
    fun getDepartamento(idDepartamento: String) : Departamento

    @Update
    fun updateDepartamento(departamento : Departamento)

    @Delete
    fun deleteDepartamento(departamento: Departamento)
    @Query("DELETE FROM departamento")
    fun borraTablaDepartamento()
}
