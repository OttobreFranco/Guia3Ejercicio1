/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia3ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author franc
 */
public class Guia3Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps = null;
        Alumno alumno=null;
        Inscripcion inscripcion=null;
        Materia materia=null;
        ResultSet rs = null;
        
        con = Conexion.getConexion();
        
        /*
        
        Insert alumno
        
        String sql = "INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES (41816969,'Arnes','Nicolás','1997-03-25','1')";
        
        */
        /*
        
        Insert materia
        
        String sql = "INSERT INTO `materia`( `nombre` ,`año`,`estado` ) VALUES ('Algoritmos I',2023,1)";
        
        */
        
        /*
        
        Insert inscripcion
        
        String sql = "INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`) VALUES (5,2,5)";
        */
        
        /*
        
        select * alumno cuando la nota sea mayor que 8 (Recordar usar executeQuery y no Update)
        
        String sql = "SELECT a.idAlumno, a.dni, a.nombre, a.apellido, a.fechaNacimiento, a.estado FROM alumno a JOIN inscripcion i ON (a.idAlumno = i.idAlumno) WHERE i.nota > 8";
        
        */
        String sql = "DELETE FROM inscripcion WHERE idInscripto = 4";
        
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            /*
            Insert , delete o update , con execute Update. Select, con Query
            
            ps.executeUpdate();
            ps.executeQuery();
            */
            
            
            /**/
            //Obtención de datos en alumno
            
            /*
            en el select de debajo, obtengo el objeto a iterar... entonces es lo que me va a devolver la consola
            yo antes lo tenia como "SELECT * from alumnos"
            Y me traía los alumnos de la DB sin filtro alguno
            
            */
            
            sql = "SELECT a.idAlumno, a.dni, a.nombre, a.apellido, a.fechaNacimiento, a.estado FROM alumno a JOIN inscripcion i ON (a.idAlumno = i.idAlumno) WHERE i.nota > 8";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
          
            while (rs.next()){
                
            alumno = new Alumno();
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setDni(rs.getInt("dni"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellido(rs.getString("apellido"));
            alumno.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            alumno.setEstado(rs.getBoolean("estado"));
            
            System.out.println(alumno);

                System.out.println();
            
            }
            /*
            Obtención de datos en materia
            
            sql = "SELECT * FROM materia";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
            materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAño(rs.getInt("año"));
            materia.setEstado(rs.getBoolean("estado"));
            
            System.out.println(materia);


            }

            
            
            //Obtención de datos en inscripcion
            
            sql = "SELECT * FROM inscripcion";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
            inscripcion = new Inscripcion();
            inscripcion.setIdInscripto(rs.getInt("idInscripto"));
            inscripcion.setNota(rs.getInt("nota"));
            inscripcion.setIdAlumno(rs.getInt("idAlumno"));
            inscripcion.setIdMateria(rs.getInt("idMateria"));
            
            System.out.println(inscripcion);


            }
            */
        } catch (SQLException ex) {
            System.out.println(" Error "+ex.getMessage());
        }
    }
    
}
