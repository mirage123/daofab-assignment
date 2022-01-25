package com.daofab.assignment.repositories;

import com.daofab.assignment.dtos.ChildResponse;
import com.daofab.assignment.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */
public interface ChildRepository extends JpaRepository<Child, Integer> {

    @Query("SELECT new com.daofab.assignment.dtos.ChildResponse(c.id,  p.receiver, p.sender, p.totalAmount, c.paidAmount)" +
            " FROM Child c left join Parent p on c.parentId  = p.id " +
            "where c.parentId = ?1 group by c.id, p.receiver, p.sender , p.totalAmount")
    List<ChildResponse> findChildByParentId(int parentId);

}
