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
    
    public PackagesIdentificationTable() {
        packagesIdTable = new HashMap<>();
        currentIdTable = new IdentificationTable();
        packagesIdTable.put(null, currentIdTable);
        packageDeclarationPhase = false;
    }
    
    public void openPackageDeclarationPhase(){
        packageDeclarationPhase = true;
    }
    
    public void closePackageDeclarationPhase(){
        packageDeclarationPhase = false;
    }
    
    public void declarePackage(PackageDeclaration packageDeclaration){
        if(packagesIdTable.get(packageDeclaration.I.spelling) != null)
            packageDeclaration.duplicated = true;
        packagesIdTable.put(packageDeclaration.I.spelling, new IdentificationTable());
    }
    
    public void openPackage(String id){
        currentIdTable = packagesIdTable.get(id);
    }
    
    public void closePackage(){
        currentIdTable = packagesIdTable.get(null);
    }
    
    public void enter (String id, Declaration attr) {
        currentIdTable.enter(id, attr);
    }
    
    public Declaration retrieve (String id) {
        Declaration value = currentIdTable.retrieve(id);
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
