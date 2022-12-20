package com.repository.book;

import com.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from books where name like %:searchName% and author like %:searchAuthor% and is_delete = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from books where name like %:searchName% and author like %:searchAuthor% and is_delete = 0) books")
    Page<Book> findBooksByAll(Pageable pageable,
                              @Param("searchName") String searchName,
                              @Param("searchAuthor") String searchAuthor);

    @Modifying
    @Transactional
    @Query(value = "update books set is_detele = 1 where is_delete =:id", nativeQuery = true)
    void deleteBookById (int id);
}
