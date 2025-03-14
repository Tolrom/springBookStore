package com.tolrom.springlibrary.dto;

import java.sql.Date;

public record BookDTO(Long id, String title, String author, Date publicationDate, String editor) {

}
