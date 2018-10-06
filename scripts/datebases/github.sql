SELECT
    *
FROM
(
SELECT 
    t.follower_id, t.following_id, t1.username as follower_username, t2.username as following_username
FROM
    follow_relationship t
    JOIN user t1 ON t1.user_id = t.follower_id
    JOIN user t2 ON t2.user_id = t.following_id
) AS tt
WHERE
    tt.follower_id = 1;


SELECT
    *
FROM
(
SELECT 
    t.follower_id, t.following_id, t1.username as follower_username, t2.username as following_username, t1.avatar as follower_avatar, t2.avatar as following_avatar
FROM
    follow_relationship t
    JOIN user t1 ON t1.user_id = t.follower_id
    JOIN user t2 ON t2.user_id = t.following_id
) AS tt
WHERE
    tt.following_id = 1;
