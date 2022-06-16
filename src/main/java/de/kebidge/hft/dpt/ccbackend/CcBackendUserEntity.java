package de.kebidge.hft.dpt.ccbackend; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CcBackendUserEntity {
    
    @Id
    @GeneratedValue
    long id;
 
    String username;
  
    public CcBackendUserEntity() {

        // Default constructor
    }  
 
    public CcBackendUserEntity(String name){
 
        this.username = name;
    }    
 
    public CcBackendUserEntity(Long id, String name){
 
        this.id = id;
        this.username = name;
    } 

    // Getter

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    // Setter

    public void setId(long id) {
        this.id = id;
    }
    
    public void setUsername(String name) {
        this.username = name;
    }
    
}
