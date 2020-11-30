package com.uzenetesztek;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.PostRepository;
import com.uzenetesztek.repository.TopicRepository;
import com.uzenetesztek.repository.UserRepository;
import com.uzenetesztek.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.runner.RunWith;
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

    @ParameterizedTest
    @ValueSource(strings = {"/", "/topics", "/profile", "/user/1","/topics/1"})
    @DisplayName("User without access redirected to login page")
    public void userWithoutAccessRedirectedToLoginPage(String url) throws Exception {

        mvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isFound());
    }

    @ParameterizedTest
    @DisplayName("Accessing non-existent page shows error page")
    @ValueSource(strings = {"/thisRandomPageDoesntExist", "/page/within", "/how/deep/should/i/go"})
    public void accessingNonExistentPageShowsErrorPage(String url) throws Exception {

        mvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isNotFound());
    }

    @ParameterizedTest
    @DisplayName("Correct credentials wrong path should still show error page")
    @WithMockUser(username = "testingmail", roles={"USER"})
    @ValueSource(strings = {"/thisRandomPageDoesntExist", "/page/within", "/how/deep/should/i/go"})
    public void correctCredentialsWrongPathShowsErrorPage(String url) throws Exception {

        userRepository.save(getUser("testingmail", "password"));
        UserDetails userDetails = userDetailsService.loadUserByUsername("testingmail");

        mvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isNotFound());
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"one", "two"})
//    public void paramaterizedTestsRun(String msg) {
//        assertNotNull(msg);
//    }

//    @Test
    @ParameterizedTest
    @WithMockUser(username = "testingmail", roles={"USER"})
    @ValueSource(strings = {"/", "/topics", "/profile", "/user/1","/topics/1"})
    @DisplayName("Logged in with correct credentials and correct path returns requested page")
    public void loggedInWithCorrectCredentialsCorrectPathReturnsRequestedPage(String url) throws Exception {

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


    @ParameterizedTest
    @WithMockUser(username = "testingmail", roles={"USER"})
    @ValueSource(strings = {"/", "/topics", "/profile", "/user/1","/topics/1"})
    @DisplayName("Correct path but incorrect credentials should return RecordNotFound")
    public void correctPathButIncorrectCredentialsShouldReturnRecordNotFound(String url) throws Exception {

        String userEmail = "nonexistentuser";

        Assertions.assertThrows(RecordNotFoundException.class , () -> {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
            mvc.perform(MockMvcRequestBuilders.get(url).with(user(userDetails)));
        });

    }

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
