/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumbweb.jpajax.api;

import com.dumbweb.jpajax.entity.Department;
import com.dumbweb.jpajax.entity.da.impl.DepartmentDAOImpl;
import com.dumbweb.jpajax.entity.dao.DepartmentDAO;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author user
 */

@Path("/departmentapi")
public class DepartmentAPI {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();
     
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Department> index(){
        
        departmentDAO.insert(new Department(0, "Food and Bed", "F&B", null, (short)1));
        return departmentDAO.getAll();
       
    }
    
    @Path("/{id}")
    @GET 
    public Department getById(@PathParam("id") int id){
        
        return departmentDAO.getById(id);
    }
    
   @Path("/save")
   @POST
   public String save(@FormParam("name")String name, @FormParam("status")short status){
       Department d = new Department(0, name, name, null, (short)status);
       departmentDAO.insert(d);
       return "save";
   }
}
