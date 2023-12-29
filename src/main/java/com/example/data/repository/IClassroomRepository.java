package com.example.data.repository;

import com.example.data.model.Classroom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IClassroomRepository extends PagingAndSortingRepository<Classroom, Long> {
    //cung cấp annotation là @Query để cho phép viết SQL trong JPA
    // @Param: dùng để truyền tham số cho câu native
    @Query(value = "select * from classroom", nativeQuery = true)
    List<Classroom> demo();

    @Query(value = "select * from classroom where name = :a", nativeQuery = true)
    List<Classroom> demo1(@Param("a") String name);

    @Modifying
    @Query(value = "select c from Classroom c")
    List<Classroom> demo2();
}
