package com.uzenetesztek;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.repository.PostRepository;
import com.uzenetesztek.repository.TopicRepository;
import com.uzenetesztek.repository.UserRepository;
import com.uzenetesztek.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"dev"})
@TestPropertySource("classpath:application.properties")
@Transactional
public class AuthControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Test
    @DisplayName("User without access redirected to login page")
    public void userWithoutAccessRedirectedToLoginPage() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/topics"))
                .andExpect(status().isFound());
    }

    @Test
    @DisplayName("Accessing non-existent page shows error page")
    public void accessingNonExistentPageShowsErrorPage() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/thisRandomThingDoesntExist"))
                .andExpect(status().isNotFound());
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "two"})
    public void paramaterizedTestsRun(String msg) {
        assertNotNull(msg);
    }

//    @Test
    @ParameterizedTest
    @WithMockUser(username = "testingmail", roles={"USER"})
    @ValueSource(strings = {"/", "/topics", "/profile", "/user/1","/topics/1"})
    public void loggedInWithCorrectCredentialsCorrectPath(String url) throws Exception {

        userRepository.save(getUser("testingmail", "password"));
        UserDetails userDetails = userDetailsService.loadUserByUsername("testingmail");

//        Topic topic = topicRepository.save(createTopic("new topicthing", user));
//
//        List<Post> postList = getPostCollection(topic, user);
//        for (Post p : postList) {
//            postRepository.save(p);
//        }

        mvc.perform(MockMvcRequestBuilders.get(url).with(user(userDetails)))
                .andExpect(status().isOk());

    }


//    @Test
////    @ParameterizedTest
//    @WithMockUser(username = "testingmail", roles={"USER"})
////    @ValueSource(strings = {"/", "/topics", "/profile", "/user/1","/topics/1"})
//    public void loggedInWithInCorrectCredentialsCorrectPath() throws Exception {
//
//        String userEmail = "nonexistantuser";
//        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
//
//        Assertions.assertThrows(RecordNotFoundException.class , () -> {
//            mvc.perform(MockMvcRequestBuilders.get("/").with(user(userDetails)));
//        });
//
////        Assertions.assertThrows(RecordNotFoundException)
////                .andExpect(result -> assertEquals("User with email: " + userEmail + " not found", result.getResolvedException().getMessage()));
//
//    }

    private User getUser(String email, String password) {
        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");
        user.setEmail(email);
        user.setAuthority("ROLE_USER");
        user.setPassword(password);
        user.setDateOfBirth(new Date());
        user.setEnabled(true);
        user.setFollowers(new HashSet<User>());
        user.setFollows(new HashSet<User>());
        user.setPosts(new HashSet<Post>());
        user.setLastLogin(new Date());
        return user;
    }

    private List<Post> getPostCollection(Topic topic, User user) {
        return Collections.singletonList(Post.builder()
                .textContent("")
                .timestamp(new Date())
                .user(user)
                .parentTopic(topic)
                .userLikes(new HashSet<>())
                .build());
    }

    private Topic createTopic(String topicName, User user) {
        Topic topic = new Topic(topicName, new Date(), "description", user);
        topic.setFollowers(new HashSet<>());
        return topic;
    }

}
