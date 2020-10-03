***
### Notation:

bold == underline `¯\_(ツ)_/¯`

`  * => italic     ` , *foreign key*
 
` ** => bold       ` , **primary key**

`*** => italic bold` , ***foreign primary key***

***

### Add to ER:

    - [ ] user.userid
    
    - [ ] admin.admin_since
    
    - [ ] topic.topicid
    
    - [ ] change: post.content
    
    
***

USER (
    **userid** [not in ER],
    email, 
    first_name, 
    last_name,
    password,
    date_of_birth,
    last_login,
    profile_pic
)

ADMIN (
     ***USER.userid*** [not in ER],
     admin_since [not in ER]
)

FOLLOWS (
    ***USER.follower_userid*** [not in ER],
    ***USER.following_userid*** [not in ER]
)

TOPIC (
    **topicid** [not in ER],
    name,
    *TOPIC.parent_topicid* [not in ER],
    *USER.userid* [not in ER]
    timestamp
)

POST (
    **postid**,
    *POST.parent_postid*
    *USER.userid*, [not in ER]
    *TOPIC.topicid*, [not in ER]
    file,
    timestamp,
    text_content [not called this way in ER]
)

