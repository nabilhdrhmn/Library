package com.project.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "judul", nullable = false)
    private String judul;

    @Column(name = "pengarang", nullable = false)
    private String pengarang;

    @Column(name = "penerbit", nullable = false)
    private String penerbit;

    @Column(name = "tanggal_terbit", nullable = false)
    private Date tanggalTerbit;

    @Column(name = "tebal_buku", nullable = false)
    private int tebalBuku;
}
