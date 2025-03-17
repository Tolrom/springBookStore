package com.tolrom.springlibrary.dto;

import java.sql.Date;
import java.util.Set;

public record BookDTO(Integer id, String title, String author, Date publicationDate, String editor, Set<String> genres) {

}
