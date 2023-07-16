package com.project.library.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookRequestUpdateModel {
    private String id;
    private String judul;
    private String pengarang;
    private String penerbit;
    private Date tanggalTerbit;
    private int tebalBuku;
}
