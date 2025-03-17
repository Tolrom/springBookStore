package com.tolrom.springlibrary.service;

import com.tolrom.springlibrary.model.Editor;
import com.tolrom.springlibrary.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository;

    // Fetches every editor
    public Iterable<Editor> findAllEditors() {
        if(editorRepository.count() == 0) {
            return null;
        }
        return editorRepository.findAll();
    }

    // Fetches an editor by its ID
    public Optional<Editor> findEditorById(Integer id) {
        return Optional.of(editorRepository.findById(id).orElse(new Editor()));
    }

    public Editor add(Editor editor) {
        return editorRepository.save(editor);
    }
}
