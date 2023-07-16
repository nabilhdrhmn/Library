create table book
(
    id             varchar not null
        constraint book_pk
            primary key,
    judul          varchar not null,
    pengarang      varchar not null,
    penerbit       varchar not null,
    tanggal_terbit date    not null,
    tebal_buku     integer not null
);