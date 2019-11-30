package loc.aliar.monitoringsystemserver.controller;

import loc.aliar.monitoringsystemserver.domain.Department;
import loc.aliar.monitoringsystemserver.domain.Role;
import loc.aliar.monitoringsystemserver.model.request.AuthLoginRequest;
import loc.aliar.monitoringsystemserver.util.RequestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class AuthControllerDocumentation {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext,
               RestDocumentationContextProvider restDocumentation) {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation).operationPreprocessors()
                        .withRequestDefaults(prettyPrint())
                        .withResponseDefaults(prettyPrint()))
                .build();
    }

    @Test
    void loginExample() throws Exception {
        AuthLoginRequest authLoginRequest = AuthLoginRequest.builder()
                .username("doctor")
                .password("1111")
                .build();
        String request = RequestUtils.toJsonRequest(authLoginRequest);

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andDo(document("login-example",
                        requestFields(
                                fieldWithPath("username").description("User system name"),
                                fieldWithPath("password").description("User system password")
                        ), responseFields(
                                fieldWithPath("token").description("JWT token used in Authentication header"),
                                fieldWithPath("user").description("Information about authenticated user"),
                                fieldWithPath("user.id").description("User system id"),
                                fieldWithPath("user.username").description("User system name"),
                                fieldWithPath("user.role").description(
                                        "User role in system (" + Arrays.toString(Role.values()) + ")"),
                                fieldWithPath("user.departments").description(
                                        "Departments linked to user (" + Arrays.toString(Department.values()) + ")"),
                                fieldWithPath("user.firstName").description("User's given name"),
                                fieldWithPath("user.lastName").description("User's surname"),
                                fieldWithPath("user.middleName").optional().description("User's patronymic")
                        )));
    }
}