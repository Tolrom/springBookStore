package com.tolrom.springlibrary.repository;

import com.tolrom.springlibrary.model.Editor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends CrudRepository<Editor, Integer> {
    Editor getEditorById(int id);
}
