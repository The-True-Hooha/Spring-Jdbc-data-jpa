CREATE TABLE movie (

    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    producer TEXT NOT NULL,
    studio TEXT NOT NULL,
    release_date DATE NOT NULL,
    unique (name, producer)


);