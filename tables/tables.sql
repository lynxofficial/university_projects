create table css."City"
(
    name varchar,
    code varchar not null
        constraint city_pk
            primary key
);

alter table css."City"
    owner to postgres;

create table css."CarServiceCenter"
(
    name      varchar not null
        constraint carservicecenter_pk
            primary key,
    phone     varchar,
    city      varchar
        constraint carservicecenter_city_code_fk
            references css."City",
    address   varchar,
    employees date,
    repair    varchar
);

alter table css."CarServiceCenter"
    owner to postgres;

create table css."Employee"
(
    "firstName" varchar,
    "lastName"  varchar,
    "birthDate" date not null
        constraint employee_pk
            primary key,
    email       varchar,
    salary      numeric,
    center      varchar
        constraint employee_carservicecenter_name_fk
            references css."CarServiceCenter"
);

alter table css."Employee"
    owner to postgres;

create table css."Repair"
(
    description varchar,
    center      varchar
        constraint repair_carservicecenter_name_fk
            references css."CarServiceCenter",
    employee    date
        constraint repair_employee_birthdate_fk
            references css."Employee"
);

alter table css."Repair"
    owner to postgres;

create unique index repair_employee_uindex
    on css."Repair" (employee);

create table css."Individual"
(
    "passportNo" varchar not null
        constraint individual_pk
            primary key
);

alter table css."Individual"
    owner to postgres;

create table css."Company"
(
    inn varchar not null
        constraint company_pk
            primary key
);

alter table css."Company"
    owner to postgres;

create table css."Customer"
(
    name         varchar,
    phone        varchar,
    email        varchar,
    center_name  varchar
        constraint customer_carservicecenter_name_fk
            references css."CarServiceCenter",
    "passportNo" varchar not null
        constraint customer_individual_passportno_fk
            references css."Individual",
    inn          varchar
        constraint customer_company_inn_fk
            references css."Company"
);

alter table css."Customer"
    owner to postgres;


