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

FOLLOWS_USER (
    ***USER.follower_userid*** ,
    ***USER.following_userid*** 
)

FOLLOWS_TOPIC (
    ***USER.userid*** ,
    ***TOPIC.topicid*** 
)

LIKES_POST (
    ***USER.userid*** ,
    ***POST.postid*** 
)

