/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Folder;
import entities.Libro;
import entities.Usuarios;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.model.file.UploadedFile;
import sessions.Local.LibroFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanLibrito")
@ViewScoped
public class BeanLibrito implements Serializable{

    /**
     * Creates a new instance of BeanLibrito
     */

     @EJB
    private LibroFacadeLocal libroFacade;
    
    private Libro libro;
    
    private UploadedFile uploaded_file;
    private Usuarios usuario;
    private int leido;
    
   // private static int cont=0;
    
    private static int paginas=0;
    
    private ArrayList<Libro>array_libros;
    
    public BeanLibrito() {
        usuario = (Usuarios)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        libro=new Libro();
        leido=0;
        array_libros=this.listar();
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

  

    public UploadedFile getUploaded_file() {
        return uploaded_file;
    }

    public void setUploaded_file(UploadedFile uploaded_file) {
        this.uploaded_file = uploaded_file;
    }

    public int getLeido() {
        return leido;
    }

    public void setLeido(int leido) {
        this.leido = leido;
    }

    public ArrayList<Libro> getArray_libros() {
        return array_libros;
    }

    public void setArray_libros(ArrayList<Libro> array_libros) {
        this.array_libros = array_libros;
    }


   
 
    public void insertar() throws IOException {
        Folder f=new Folder();
        InputStream input_stream = this.uploaded_file.getInputStream();
        String nombre=f.asignarNombreAleatorio();
        byte[] bytes = new byte[(int)this.uploaded_file.getSize()];
        int readers = input_stream.read(bytes);
        this.libro.setDireccion("img/"+nombre+".png");
        this.libro.setPagina(0);
        this.libro.setLeido(0);
        this.libro.setId(1+libroFacade.getMaxId());
        //cont++;
        Libro l=new Libro();
        l.setAutor(libro.getAutor());
        l.setDireccion(libro.getDireccion());
        l.setId(libro.getId());
        l.setPagina(0);
        l.setTitulo(libro.getTitulo()); 
        l.setLeido(0);
        
        this.array_libros.add(l); 
        
        f.escribirBytes(bytes,FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/image")+"/"+nombre+".png");
       //this.libroFacade.create(this.libro);
        //System.out.println("Metodo insertar: comprobar funcionalidad"); 
          
        //System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/img"));
    }
    
    private String rootArchivos() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        return (String) servletContext.getRealPath("/img") + "/";
    }

 
  /*  public void actualizarPaginas(Libro e) {
            e.setPagina(BigInteger.valueOf(this.paginas));
            System.out.println("ID: " + e.getId());
            System.out.println("AUTOR: " + e.getAutor());
            System.out.println("DIRECCION: " + e.getDireccion());
            System.out.println("PAGINA: " + e.getPagina());
            System.out.println("LEIDO: " + e.getLeido());
            //this.libroFacade.edit(e);
            for(int i=0; i<2; i++){
               // PrimeFaces.current().ajax().update("form-ciclo");
            }  
    }*/
    
    public void guardarDatos() {
       //this.eliminar();
       for (int i = 0; i < this.array_libros.size(); i++) {
            try {
                this.libroFacade.create(this.array_libros.get(i));
                                                                              
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    
   

        


    

    
   public void updateData(ActionEvent en) throws InterruptedException {
       System.out.println("hijos: " + en.getComponent().getChildCount());
       InputText input = (InputText) en.getComponent().findComponent("input");
       CommandButton boton = (CommandButton) en.getComponent().findComponent("boton_hijo");
       OutputLabel label = (OutputLabel) en.getComponent().findComponent("labelpagina");
       System.out.println("valor del input" + input.getValue());
       System.out.println("valor del boton" + boton.getValue());
       Libro e = (Libro) boton.getValue();
       System.out.println("ID: " + e.getId());
       System.out.println("AUTOR: " + e.getAutor());
       System.out.println("DIRECCION: " + e.getDireccion());
       System.out.println("PAGINA: " + e.getPagina());
       System.out.println("LEIDO: " + e.getLeido());
       Integer pag = Integer.valueOf(String.valueOf(input.getValue()));
       for(int i=0; i<this.array_libros.size(); i++){
           if(e.getId()==this.array_libros.get(i).getId()){
               this.array_libros.get(i).setPagina(pag);
           }
       }
       
        for(int i=0; i<this.array_libros.size(); i++){
            System.out.println("Paginas en array: "+this.array_libros.get(i).getPagina());
              
       }
       
       
       //this.libroFacade.edit(e);
   /*   for(int i=0; i<3; i++){
              Thread.sleep(500);
               PrimeFaces.current().ajax().update("form-ciclo");
        }  */
      
      
}
    
    public ArrayList<Libro> listarLibrosEnGrid() throws InterruptedException{
        Thread.sleep(2000);
         //List<Libro>lista= this.libroFacade.findAll();
        //ArrayList<Libro>array_imagenes=this.listar();
        return this.array_libros;
    }
   
        
    public void cambioLeido(ValueChangeEvent e){
        //System.out.println("Numero de hijos. metodo CAMBIO LEIDO"+e.getComponent().getChildCount()); 
        CommandButton boton=(CommandButton) e.getComponent().findComponent("idLibro");
        //System.out.println( "id del libro correspondiente: "+boton.getLabel());  
        //Libro li=this.libroFacade.find(new BigDecimal(boton.getLabel()));
        
        for(int i=0; i<this.array_libros.size(); i++){
            System.out.println("VALOR DEL LABEL"+new BigDecimal(Integer.parseInt(boton.getLabel())));
            System.out.println("VALOR DEL ID DEL ARRAY"+this.array_libros.get(i).getId());
            Integer valor1= Integer.parseInt(boton.getLabel());
            Integer valor2= this.array_libros.get(i).getId();
            if(valor1.equals(valor2)){
                System.out.println("BIENNNNN");
                this.array_libros.get(i).setLeido(Integer.parseInt(String.valueOf(e.getNewValue())));

            }
             
        }
        
         for(int i=0; i<this.array_libros.size(); i++){
             System.out.println("NUEVO LEIDO: "+this.array_libros.get(i).getLeido());
        }
     /*   System.out.println("leido de imagen: "+li.getLeido());
        System.out.println("Nuevo valor:"+e.getNewValue());
        System.out.println(li.getId());
        li.setLeido(BigInteger.valueOf(Long.valueOf(String.valueOf(e.getNewValue())))); */
        //this.libroFacade.edit(li);
        //this.imagenesFacade.edit(imagen);
        
    }
    
   /* private Imagenes encontrarLibroPorId(List<Libro>array_imagenes, int id){
        for(Imagenes e: array_imagenes){
            if(id==Integer.parseInt(String.valueOf(e.getId()))){
                return e;
            }
        }
        return null;
    }*/
  
    
  
   public ArrayList<Libro> listar() {
       array_libros = new ArrayList<>();
       array_libros = (ArrayList<Libro>) libroFacade.getTodoActivo(usuario);
        ArrayList<Libro> arreglo = new ArrayList<>();
        return arreglo;
    }
  
//
//    public void eliminar() {
//
//        PreparedStatement ps;
//
//        try {
//            Connection cn = this.conectar();
//            ps = cn.prepareStatement("delete from libro");
//            ps.executeQuery();
//            cn.commit();
//            cn.close();
//        } catch (Exception e) {
//            System.out.println("error: " + e);
//        }
//
//    }

}
