bold == underline ¯\\_(ツ)_/¯

'*'     => italic,      foreign key

'**'    => bold,        primary key

'***'   => italic bold, foreign primary key

USER (
    **email** [why no userid for key?], 
    first_name, last_name
    password,
    date_of_birth,
    last_login,
    profile_pic,
)

ADMIN (
     ***USER.email***
     admin_since [not in ER dia]
)

FOLLOWS (
    ***USER.follower_email***,
    ***USER.following_email***
)

TOPIC (
    **name** [why no topicid?],
    *TOPIC.parent_name*,
    *USER.email*
    timestamp
)

POST (
    **postid**,
    *POST.parent_postid*
    *USER.email*,
    *TOPIC.name*
    file,
    timestamp
    text_content,
)

