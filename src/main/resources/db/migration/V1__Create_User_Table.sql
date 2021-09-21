CREATE TABLE IF NOT EXISTS "users" (
    "id"  BIGSERIAL PRIMARY KEY,
    "created_by" varchar(50) NOT NULL,
    "created_date" timestamp,
    "last_modified_by" varchar(50),
    "last_modified_date" timestamp,
    "activated" bool NOT NULL,
    "email" varchar(254),
    "first_name" varchar(50),
    "last_name" varchar(50)
);
