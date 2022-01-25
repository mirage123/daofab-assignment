package com.daofab.assignment.repositories;

import com.daofab.assignment.dtos.ParentResponse;
import com.daofab.assignment.entities.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author prabesh on 25/Jan/2022
 */
public interface ParentRepository extends JpaRepository<Parent, Integer> {
    @Query(value = "SELECT new com.daofab.assignment.dtos.ParentResponse(p.id, p.receiver, p.sender, p.totalAmount, SUM(c.paidAmount)) " +
            "FROM Parent p left join Child c on c.parentId  = p.id group by p.id")
    Page<ParentResponse> findParents(Pageable pageable);
}
