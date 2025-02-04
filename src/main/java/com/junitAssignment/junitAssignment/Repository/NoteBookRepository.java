package com.junitAssignment.junitAssignment.Repository;

import com.junitAssignment.junitAssignment.Entity.NotebookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteBookRepository extends JpaRepository<NotebookEntity, Integer> {
      public NotebookEntity findById(int id);
}
