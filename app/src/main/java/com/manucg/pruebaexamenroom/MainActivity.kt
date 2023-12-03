package com.manucg.pruebaexamenroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manucg.plantillaroom.conexion.BDRoom
import com.manucg.plantillaroom.entidades.Alumno
import com.manucg.plantillaroom.entidades.Asignatura
import com.manucg.plantillaroom.entidades.Grupo
import com.manucg.plantillaroom.entidades.Matricula
import com.manucg.plantillaroom.interfaces.*
import com.manucg.pruebaexamenroom.entidades.Departamento
import com.manucg.pruebaexamenroom.entidades.Profesor

class MainActivity : AppCompatActivity() {
    lateinit var conexion : BDRoom
    lateinit var daoAlumno : InterfaceDaoAlumno
    lateinit var daoGrupo : InterfaceDaoGrupo
    lateinit var daoAsignatura: InterfaceDaoAsignatura
    lateinit var daoMatricula : InterfaceDaoMatricula
    lateinit var daoProfesor : InterfaceDaoProfesor
    lateinit var daoDepartamento: InterfaceDaoDepartamento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
        borraTablas()
        pruebaGrupo()
        pruebaAlumno()
        pruebaAsignatura()
        pruebaMatricula()
        pruebaDepartamento()
        pruebaProfesor()
        borraTablas()

    }

    fun setup(){
        conexion= BDRoom.getBaseDatos(this)
        daoAlumno=conexion.DaoAlumno()
        daoGrupo=conexion.DaoGrupo()
        daoAsignatura=conexion.DaoAsignatura()
        daoMatricula=conexion.DaoMatricula()
        daoProfesor=conexion.DaoProfesor()
        daoDepartamento=conexion.DaoDepartamento()
    }

    fun pruebaGrupo(){
        /*AÑADIENDO GRUPO*/
        daoGrupo.addGrupo(Grupo("2DAM", "DAM", "G1B"))
        daoGrupo.addGrupo(Grupo("1DAM", "DAM", "G1A"))
        daoGrupo.addGrupo(Grupo("3DAM", "NO EXISTE", "NNN"))


        /*MOSTRANDO UN GRUPO*/
        Log.d("getGrupo()", daoGrupo.getGrupo("2DAM").toString())

        /*MOSTRANDO TODOS LOS GRUPOS*/
        daoGrupo.getGrupos().forEach {
            Log.d("getGrupos()", it.toString())
        }

        /*ACTUALIZANDO UN GRUPO*/
        var grupoActualizado= daoGrupo.getGrupo("3DAM")
        grupoActualizado.nombre="Aunque no exista lo actualizo"
        daoGrupo.updateGrupo(grupoActualizado)
        Log.d("updateGrupo()", daoGrupo.getGrupo("3DAM").toString())

        /*BORRANDO UN GRUPO*/
        daoGrupo.deleteGrupo(daoGrupo.getGrupo("3DAM"))
        daoGrupo.getGrupos().forEach {
            Log.d("deleteGrupo()", it.toString())
        }


    }

    fun pruebaAlumno(){
        /*AÑADIENDO ALUMNOS*/
        daoAlumno.addAlumno(Alumno("Manu", "Casado", "2DAM"))
        daoAlumno.addAlumno(Alumno("Pablo", "Arenas", "2DAM"))
        daoAlumno.addAlumno(Alumno("Ana", "Camacho", "1DAM"))
        daoAlumno.addAlumno(Alumno("Jorge", "Galán", "1DAM"))

        /*MOSTRANDO UN ALUMNO*/
        Log.d("getAlumno()", daoAlumno.getAlumno("Manu").toString())

        /*MOSTRANDO TODOS LOS ALUMNOS*/
        daoAlumno.getAlumnos().forEach {
            Log.d("getAlumnos()", it.toString())
        }

        /*ACTUALIZANDO UN ALUMNO*/
        var alumnoActualizado = daoAlumno.getAlumno("Ana")
        alumnoActualizado.grupo = "2DAM"
        daoAlumno.updateAlumno(alumnoActualizado)

        /*BORRANDO UN ALUMNO*/
        daoAlumno.deleteAlumno(daoAlumno.getAlumno("Jorge"))
    }

    fun pruebaAsignatura(){
        /*AÑADIENDO ASIGANTURAS*/
        daoAsignatura.addAsignatura(Asignatura("Acceso a datos"))
        daoAsignatura.addAsignatura(Asignatura("Moviles"))
        daoAsignatura.addAsignatura(Asignatura("HLC"))
        daoAsignatura.addAsignatura(Asignatura("PSP"))

        /*MOSTRANDO UNA ASIGANTURA*/
        Log.d("getAsignatura()", daoAsignatura.getAsignatura("HLC").toString())

        /*MOSTRANDO TODAS LAS ASIGANTURAS*/
        daoAsignatura.getAsignaturas().forEach {
            Log.d("getAsignaturas()", it.toString())
        }

        /*ACTUALIZANDO UNA ASIGANTURA*/
        var asignaturaActualizada = daoAsignatura.getAsignatura("Moviles")
        asignaturaActualizada.nombre= "PMSM"
        daoAsignatura.updateAsignatura(asignaturaActualizada)
        daoAsignatura.getAsignaturas().forEach {
            Log.d("updateAsignatura()", it.toString())
        }

        /*BORRANDO UNA ASIGANTURA*/
        daoAsignatura.deleteAsignatura(daoAsignatura.getAsignatura("HLC"))
    }

    fun pruebaMatricula(){
        /*AÑADIENDO MATRICULAS*/
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Manu").id, daoAsignatura.getAsignatura("Acceso a datos").id))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Manu").id, daoAsignatura.getAsignatura("PMSM").id))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Pablo").id, daoAsignatura.getAsignatura("Acceso a datos").id))
        daoMatricula.addMatricula(Matricula(daoAlumno.getAlumno("Ana").id, daoAsignatura.getAsignatura("Acceso a datos").id))

        /*MOSTRANDO UNA MATRICULA*/

        Log.d(
            "getMatricula()",
            daoMatricula.getMatricula(daoAlumno.getAlumno("Manu").id, daoAsignatura.getAsignatura("Acceso a datos").id).toString())

        /*MOSTRANDO TODAS LAS MATRICULAS*/
        daoMatricula.getMatriculas().forEach {
            Log.d("getMatriculas()", it.toString())
        }
        /*ACTUALZIANDO UNA MATRICULA*/
        var matriculaActualizada = daoMatricula.getMatricula(daoAlumno.getAlumno("Manu").id, daoAsignatura.getAsignatura("Acceso a datos").id)
        matriculaActualizada.asignaturaId= daoAsignatura.getAsignatura("PSP").id
        daoMatricula.updateMatricula(matriculaActualizada)
        daoMatricula.getMatriculas().forEach {
            Log.d("updateMatricula()", it.toString())
        }

        /*BORRANDO UNA MATRICULA*/
        daoMatricula.deleteMatricula(matriculaActualizada)
        daoMatricula.getMatriculas().forEach {
            Log.d("deleteMatricula()", it.toString())
        }
        /*OBTENIENDO USUARIOS QUE ESTÁN MATRICULADOS EN UNA ASIGANTURA*/
        daoMatricula.getAlumnosByAsignatura("Acceso a datos").forEach {
            Log.d("getAlumnosByAsignatura", it.toString())
        }

    }

    fun pruebaDepartamento(){
        /*AÑADIENDO DEPARTAMENTOS*/
        daoDepartamento.addDepartamento(Departamento("Informatica" , "Informatica"))
        daoDepartamento.addDepartamento(Departamento("ESO", "ESO"))
        daoDepartamento.addDepartamento(Departamento("Direccion", "Direccion"))

        /*OBTENIENDO UN DEPARTAMENTO*/
        Log.d("getDepartamento()", daoDepartamento.getDepartamento("Informatica").toString())

        /*OBTENIENDO DEPARTAMENTOS*/
        daoDepartamento.getDepartamentos().forEach{
            Log.d("getDepartamentos()", it.toString())
        }

        /*ACTUALIZANDO DEPARTAMENTO*/
        var departamentoActualizado = daoDepartamento.getDepartamento("ESO")
        departamentoActualizado.nombre="Educación Secundaria Obligatoria"
        daoDepartamento.updateDepartamento(departamentoActualizado)
        daoDepartamento.getDepartamentos().forEach{
            Log.d("updateDepartamento()", it.toString())
        }
        /*BORRANDO DEPARTAMENTO*/
        daoDepartamento.deleteDepartamento(daoDepartamento.getDepartamento("Direccion"))
        daoDepartamento.getDepartamentos().forEach{
            Log.d("updateDepartamento()", it.toString())
        }
    }

    fun pruebaProfesor(){

        /*AÑADIENDO PROFESORES*/
        daoProfesor.addProfesor(Profesor("Enrique" , "Informatica"))
        daoProfesor.addProfesor(Profesor("Dioni" , "Informatica"))
        daoProfesor.addProfesor(Profesor("Bernat" , "ESO"))

        /*MOSTRANDO PROFESOR*/
        Log.d("getProfesor",daoProfesor.getProfesor("Enrique").toString())

        /*MOSTRANDO PROFESORES*/
        daoProfesor.getProfesores().forEach {
            Log.d("getProfesores()", it.toString())
        }

        /*ACTUALIZANDO PROFESOR*/
        var profesorActualizado = daoProfesor.getProfesor("Dioni")
        profesorActualizado.nombre = "Dionisio"
        daoProfesor.updateProfesor(profesorActualizado)
        daoProfesor.getProfesores().forEach {
            Log.d("updateProfesor()", it.toString())
        }

        /*BORRANDO PROFESOR*/
        daoProfesor.deleteProfesor(daoProfesor.getProfesor("Dionisio"))
        daoProfesor.getProfesores().forEach {
            Log.d("deleteProfesor()", it.toString())
        }

    }

    fun borraTablas(){
        daoMatricula.borraTablaMatricula()
        daoAsignatura.borraTablaAsignatura()
        daoAlumno.borraTablaAlumno()
        daoGrupo.borraTablaGrupo()
        daoProfesor.borraTablaProfesor()
        daoDepartamento.borraTablaDepartamento()
    }

}