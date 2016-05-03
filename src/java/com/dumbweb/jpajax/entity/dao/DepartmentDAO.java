 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumbweb.jpajax.entity.dao;

import com.dumbweb.jpajax.entity.Department;
import java.util.List;

/**
 *
 * @author user
 */
public interface DepartmentDAO {
    
    List<Department> getAll();
    int insert(Department d);
    Department getById(int id);
    
}
