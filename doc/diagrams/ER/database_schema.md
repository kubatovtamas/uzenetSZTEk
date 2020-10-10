***
### Notation:

bold == underline `¯\_(ツ)_/¯`

`  * => italic     ` , *foreign key*
 
` ** => bold       ` , **primary key**

`*** => italic bold` , ***foreign primary key***

***

USER (
    **userid**,
    email, 
    first_name, 
    last_name,
    password,
    date_of_birth,
    last_login,
    profile_pic
)

ADMIN (
     ***USER.userid***,
     admin_since 
)

FOLLOWS (
    ***USER.follower_userid*** ,
    ***USER.following_userid*** 
)

TOPIC (
    **topicid** ,
    name,
    *TOPIC.parent_topicid* ,
    *USER.userid* 
    timestamp
)

POST (
    **postid**,
    *POST.parent_postid*
    *USER.userid*, 
    *TOPIC.topicid*, 
    file,
    timestamp,
    text_content [not called this way in ER]
)

