package com.wanted.springtest.section01.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/* hi.
*   @WebMvcTest 란?
*   - Controller 계층은  Web/Was 서버에서 오는 요청을 처리하는 웹 계층이다.
*   - 해당 어노테이션은 웹 계층만 로드하여 가벼운 테스트를 수행할 수 있다.
*  */

@WebMvcTest(CalculatorController.class)
@DisplayName("CalculatorController 웹 계층 테스트")
public class CalculatorControllerTest {

    /* hi.
    *   MockMvc 는 실제 Tomcat 서버를 띄우지 않고, HTTP 요청/응답을
    *   시뮬레이션 할 수 있다 -> Application 실행하지 않아도 가능하다는 의미
    *   해당 객체를 통해 요청 처리, 응답 생성 등을 검증할 수 있다.
    *  */
    @Autowired
    private MockMvc mockMvc;

    // 테스트에서 JSON 응답을 파싱하거나 요청 받을 떄 활용한다.
    @Autowired
    private ObjectMapper objectMapper;


    /* hi.
    *   @MockitoBean : 가짜 객체
    *   - 실제 IoC 컨테이너에 등록된 Service를 사용하는 것이 아닌
    *   - Mock(가짜) 객체를 주입 받는다.
    *   - 이를 통해 컨트롤러 로직만 독립적으로 테스트 할 수 있다.
    *  */
    @MockitoBean
    private CalculatorService calculatorService;

    @Test
    @DisplayName("덧셈 API가 올바른 결과를 반환해야 한다.")
    void 더하기_API_올바른_결과_리턴_테스트() throws Exception {


        // given
        int a = 10, b = 5, expectedSum = 15;
        given(calculatorService.add(a, b)).willReturn(expectedSum);

        // when & then
        mockMvc.perform(
                get("/api/calculator/add")
                        .param("a", String.valueOf(a)) // url은 무조건 string 타입이라서 바꿔줬음
                        .param("b", String.valueOf(b))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print()) // 요청 및 응답 정보를 콘솔에 출력 (상세하게 출력됨)
                .andExpect(status().isOk()) // HTTP 응답 200을 기대
                // $ = JSON 데이터의 최상위(ROOT) 객체
                .andExpect(jsonPath("$.result").value(expectedSum))
                .andExpect(jsonPath("$.operation").value("addition"))
                .andExpect(jsonPath("$.operand1").value(a)) // 피연산자 1
                .andExpect(jsonPath("$.operand2").value(b)); // 피연산자 2
        // andExpect 와 assertNotNull의 차이 (제공 주체가 다름)
        // andExpect 이거는 mockMvc 안에 있는거 가져오는거. assertNotNull 써도 됨. 근데 여기선 굳이 그럴필요가 없다.
    }

    /* hi.
    *   TestCode 는 정상 동작을 하는 것을 테스트 하는 것 보다는
    *   예외(잘못된 값) 을 테스트 하는 것이 더 중요하다.
    *  */
    @Test
    @DisplayName("잘못 된 파라미터 타입 전송 시 Bad Request를 반환한다.")
    void 더하기_잘못_된_파라미터_BadRequest_반환_테스트() throws Exception {

        // when & then
        mockMvc.perform(
                get("/api/calculator/add")
                        .param("a", "not_a_number") // 비정상 데이터
                        .param("b", "5")            // 정상 데이터
                )
                .andDo(print())
                .andExpect(status().isBadRequest());             // 해당 요청을 보내면 400(BadRequest) 기대
    }

}
