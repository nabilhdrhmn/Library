create table book_status
(
    id_buku         varchar not null
        constraint book_status_pk
            primary key,
    status          varchar not null,
    peminjam        varchar,
    tanggal_pinjam  date,
    tanggal_kembali date
);