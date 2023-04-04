create table session
(
    session_id      bigint not null
        primary key,
    session_date    timestamp without time zone ,
    movie_id      bigint
        constraint fkl4gbym62l738id056y12rt6q6
            references "cinema"
);