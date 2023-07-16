package com.project.library.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookStatusUpdateModel {
    private String id;
    private String peminjam;
    private Date tanggalPinjam;
    private Date tanggalKembali;
}
