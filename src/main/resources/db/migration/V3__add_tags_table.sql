-- Tags table
CREATE TABLE tags
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- User_Tags join table
CREATE TABLE user_tags
(
    user_id BIGINT NOT NULL,
    tag_id  INT    NOT NULL,
    PRIMARY KEY (user_id, tag_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_tag FOREIGN KEY (tag_id) REFERENCES tags (id) ON DELETE CASCADE
);
