/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.Declaration;
import Triangle.AbstractSyntaxTrees.PackageDeclaration;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class PackagesIdentificationTable {
    private HashMap<String,IdentificationTable> packagesIdTable;
    private IdentificationTable currentIdTable;
    private boolean packageDeclarationPhase;
    private IdentificationTable privateIdentificationTable;
    private boolean privateScope;
    
    public PackagesIdentificationTable() {
        packagesIdTable = new HashMap<>();
        currentIdTable = new IdentificationTable();
        packagesIdTable.put(null, currentIdTable);
        packageDeclarationPhase = false;
        privateScope = false;
    }
    
    
    //Se crea una nueva tabla de id solo para las declaraciones privadas
    public void openPrivateDeclaration(){
        privateIdentificationTable = new IdentificationTable();
        privateScope = true;
    }
    
    //Se cierra el scope de las declaraciones privadas
    //esto es para que no se agreguen mas declaraciones privadas
    //pero se mantenga la visibilidad de ellas
    public void closePrivateScope(){
        privateScope = false;
    }
    
    //se eliminan las declaraciones privadas para mantener solo las que se deben exportar 
    public void closePrivateDeclaration(){
        privateIdentificationTable = null;
    }
    
    //se abre la fase de declaraciones de paquetes, esto es para que si hay
    //un id no declarado, que luego lo busque en la tabla donde estan las definiciones de
    //las del entorno: false, true, boolean, integer, record ...
    //posiblemente el id no declarado fuera uno de estos del entorno
    //esta fase se abre para solo hacer este proceso de revisar en dos tablas cuando
    //se estan declarando los paquetes
    public void openPackageDeclarationPhase(){
        packageDeclarationPhase = true;
    }
    
    //se cierra la etapa de declaraciones de paquetes, en caso de una consulta
    //de un paquete especifico, solo se buscara en la tabla de ese paquete
    public void closePackageDeclarationPhase(){
        packageDeclarationPhase = false;
    }
    
    //se agrega una declaracion de paquete
    public void declarePackage(PackageDeclaration packageDeclaration){
        if(packagesIdTable.get(packageDeclaration.I.spelling) != null)
            packageDeclaration.duplicated = true;
        packagesIdTable.put(packageDeclaration.I.spelling, new IdentificationTable());
    }
    
    //se abre un paquete tanto para meter declaraciones como para buscarlas
    public void openPackage(String id){
        currentIdTable = packagesIdTable.get(id);
    }
    
    //se cierra el paquete, se vuelve a la tabla default
    public void closePackage(){
        currentIdTable = packagesIdTable.get(null);
    }
    
    //en caso de que se este en private scope, las declaraciones ingresadas son privadas
    //caso contrario son del scope normal
    public void enter (String id, Declaration attr) {
        if(privateScope)
            privateIdentificationTable.enter(id, attr);
        else
            currentIdTable.enter(id, attr);
    }
    
    //en caso de que exista la tabla de declaraciones privadas, significa que se estan haciendo
    //las declaraciones que se exportan, por tanto se busca primero en esa tabla
    //en caso de que no se encuentre, se busca en la tabla actual
    //si nuevamente no se encuentra, y se esta en la etapa de declaracion de paquetes, se busca en la tabla default
    public Declaration retrieve (String id) {
        Declaration value = null;
        if(privateIdentificationTable != null)
            value = privateIdentificationTable.retrieve(id);
        if(value == null)
            value = currentIdTable.retrieve(id);
        if(value == null && packageDeclarationPhase)
            return packagesIdTable.get(null).retrieve(id);
        return value;
    }
    
    public void openScope () {
        currentIdTable.openScope();
    }

    public void closeScope () {
        currentIdTable.closeScope();
    }
}
