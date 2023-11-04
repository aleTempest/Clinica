CREATE TABLE IF NOT EXISTS "USERS" (
       [user_id] INTEGER PRIMARY KEY,
       [first_name] TEXT NOT NULL,
       [last_name] TEXT NOT NULL,
       [username] TEXT NOT NULL,
       [password] TEXT NOT NULL,
       [zipcode] TEXT,
       [address1] TEXT,
       [address2] TEXT,
       [phone_number] TEXT NOT NULL,
       [user_type] TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS "APPOINTMENTS" (
    [id] INTEGER PRIMARY KEY,
    [user_id] INTEGER,
    FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);

CREATE TABLE IF NOT EXISTS "PATIENTS" (
    [user_id] INTEGER PRIMARY KEY,
    [medical_conditions] TEXT,
    FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);
