package com.project.library.model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookRequestInsertModel {
    private String judul;
    private String pengarang;
    private String penerbit;
    private Date tanggalTerbit;
    private int tebalBuku;
}
