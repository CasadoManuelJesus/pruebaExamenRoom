package com.manucg.plantillaroom.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.manucg.plantillaroom.entidades.Alumno
import com.manucg.plantillaroom.entidades.Asignatura
import com.manucg.plantillaroom.entidades.Grupo
import com.manucg.plantillaroom.entidades.Matricula
import com.manucg.plantillaroom.interfaces.*
import com.manucg.pruebaexamenroom.entidades.Departamento
import com.manucg.pruebaexamenroom.entidades.Profesor


//Definir las entidades
@Database(
    entities = [Grupo::class, Alumno::class, Matricula::class, Asignatura::class, Departamento::class, Profesor::class],
    version = 2
)
abstract class BDRoom : RoomDatabase() {

    // Definición de los daos
    abstract fun DaoGrupo(): InterfaceDaoGrupo
    abstract fun DaoAlumno(): InterfaceDaoAlumno
    abstract fun DaoMatricula(): InterfaceDaoMatricula
    abstract fun DaoAsignatura(): InterfaceDaoAsignatura
    abstract fun DaoProfesor() : InterfaceDaoProfesor
    abstract fun DaoDepartamento() : InterfaceDaoDepartamento

    companion object {
        private var INSTANCE: BDRoom? = null

        fun getBaseDatos(context: Context): BDRoom {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, BDRoom::class.java,
                    // Especificamos el nombre de la base de datos.
                    "baseDeDatosBD"
                )
                    .allowMainThreadQueries()
                    //Debajo de esta linea incluiremos las migraciones
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return INSTANCE as BDRoom
        }

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS departamento (" +
                            "id TEXT PRIMARY KEY NOT NULL," +
                            "nombre TEXT NOT NULL)"
                )
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS profesor (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "nombre TEXT NOT NULL," +
                            "idDepartamento TEXT NOT NULL," +
                            "FOREIGN KEY(idDepartamento) REFERENCES departamento(id)" +
                            ")"
                )
            }
        }

/*      DEFINIMOS LAS MIGRACIONES (CAMBIA EL NUMERO DE VERSION A LA ULTIMA MIGRACIÓN)

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE usuario ADD COLUMN descripcion TEXT")
            }
        }

        val MIGRATION_1_2: Migration = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS libro (" +
                        "idLibro INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "titulo TEXT NOT NULL," +
                        "genero TEXT NOT NULL," +
                        "usuario INTEGER NOT NULL," +
                        "FOREIGN KEY(usuario) REFERENCES usuario(id_usuario)" +
                        ")")
            }
        }
*/

    }
}
