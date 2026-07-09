from fastapi import FastAPI

app = FastAPI()

# 여러 자료형을 반환하는 API
# QueryStringParameter : /hello?num1=2#num2
# PathVariable : /hello/1
# RequestBody

# Step 01 . Queryt Parameter 전달 받기
# url 뒤에 ?key=value 형태로 전달되는 값을 의미한다.
# /hello-query?name-raccoon
@app.get("/hello-query")
def hello_query(name : str):
    return{
        "message" : f"Hello~~~~{name} 님!"
    }

# step 02. PathVariable 전달 받기
# /course/1
# /course/{courseId}
@app.get("/course/{courseId}")
def find_by_course_id(course_id : int) :
    return{
        "course_id" : course_id,
        "title" : f"{course_id} 번 강의 제목!"

    }

# step 03. 여러 값을 전달할 때는 POST, RequestBody 를 활용한다.
@app.post("/chat")
def chatbot(request : dict) :
    # dictionary 에 있는 특정 값을 꺼내는 방법?!
    # request["key"]
    question = request["question"]

    return {
        "question" : f"당신의 질문 : {question}",
        "amswer" : f"{question} 에 대한 대답."
    }

# 지금 POST 방식의 요청/응답 은 requestDTO, responseDTO 가 없기 때문에 유지보수성이 좋지 않다.
# Pydantic Schema
# Java에서의 req, res 객체라고 생각하면 된다.