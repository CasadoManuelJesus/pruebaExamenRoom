package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Grupo

@Dao
interface InterfaceDaoGrupo {
    @Insert
    fun addGrupo(entidad : Grupo)

    @Query("SELECT * FROM grupo")
    fun getGrupos() : MutableList<Grupo>

    @Query("SELECT * FROM grupo WHERE id LIKE :idGrupo")
    fun getGrupo(idGrupo: String) : Grupo

    @Update
    fun updateGrupo(grupo : Grupo)

    @Delete
    fun deleteGrupo(grupo: Grupo)
    @Query("DELETE FROM grupo")
    fun borraTablaGrupo()
}
