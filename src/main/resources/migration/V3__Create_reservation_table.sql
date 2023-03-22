create table "reservation"
(
    reservation_id bigint not null
        primary key ,
    hall integer,
    "row" integer,
    place integer,
    session_id bigint
        constraint fkl862l546id056y21rt6q6
            references "session"
);