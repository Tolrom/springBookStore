package com.tolrom.springlibrary.controller;

import com.tolrom.springlibrary.model.Editor;
import com.tolrom.springlibrary.repository.EditorRepository;
import com.tolrom.springlibrary.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/editors")
public class EditorController {

    @Autowired
    private EditorService editorService;
    @Autowired
    private EditorRepository editorRepository;

    @GetMapping
    public Iterable<Editor> getAllEditors() {
        return editorService.findAllEditors();
    }

    @GetMapping("/{id}")
    public Optional<Editor> getEditorById(@PathVariable Integer id) {
        return editorService.findEditorById(id);
    }

    @PostMapping("/add")
    public Editor addEditor(@RequestBody Editor editor) {
        return editorService.add(editor);
    }
}
