create table hotels (
  id            bigserial primary key,
  name          text,
  open_date    date
);

create table floors (
  id            bigserial primary key,
  hotel_id      bigint references hotels(id),
  name          text
);

create table rooms (
  id            bigserial primary key,
  floor_id      bigint references floors(id),
  name          text
);

create table compartments (
  id            bigserial primary key,
  room_id       bigint references rooms(id),
  name          text
);
