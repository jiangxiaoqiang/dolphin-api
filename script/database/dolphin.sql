
-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE public.book
(
    id bigint NOT NULL,
    name character varying(512) COLLATE pg_catalog."default" NOT NULL,
    isbn character varying(32) COLLATE pg_catalog."default" NOT NULL,
    author character varying(256)[] COLLATE pg_catalog."default" NOT NULL,
    publisher character varying(256) COLLATE pg_catalog."default" NOT NULL,
    price character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (id),
    CONSTRAINT id_uniq UNIQUE (id),
    CONSTRAINT isbn_uniq UNIQUE (isbn)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.book
    OWNER to postgres;
COMMENT ON TABLE public.book
    IS 'book';

COMMENT ON COLUMN public.book.author
    IS 'author';

COMMENT ON COLUMN public.book.publisher
    IS 'publisher';

COMMENT ON COLUMN public.book.price
    IS 'price';

COMMENT ON CONSTRAINT id_uniq ON public.book
    IS 'id uniq constraint';
COMMENT ON CONSTRAINT isbn_uniq ON public.book
    IS 'isbn uniq constraint';



