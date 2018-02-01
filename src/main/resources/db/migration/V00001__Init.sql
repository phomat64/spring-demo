create table hotels (
  id            text primary key,
  name          text,
  open_date    date
);

create table floors (
  id            text primary key,
  hotel_id      text references hotels(id),
  name          text
);

create table rooms (
  id            text primary key,
  floor_id      text references floors(id),
  name          text
);

create table compartments (
  id            text primary key,
  room_id       text references rooms(id),
  name          text
);
