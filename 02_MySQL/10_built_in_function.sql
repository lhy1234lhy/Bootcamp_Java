-- 문자열, 숫자, 날짜, 조건 함수 등
-- 가장 많이 쓰이는 내장 함수를 학습한다.

-- 문자열 관련 내장 함수
-- concat : 여러 문자열을 하나로 합치기
-- users 테이블에서 사용자의 이름, 이메일, 이름(이메일)을 조회하라.
select
	name,
    email,
    concat(name, '(', email, ')') as '이름(이메일)'
from users;

-- substring : 문자열의 일부를 잘라낸다.
-- substring(문자열, 시작위치, 길이)
-- locate : 특정 문자열이 다른 문자열 내부에서 처음으로 나타나는 위치 변환
-- raccoon@helloworldlabs.kr
-- raccoon
select
	email,
    substring(email, 1, locate('@', email)-1) -- @ 전까지 나오게 함
from users;

-- length / char_length
-- 바이트 단위 / 글자 수 단위
select
	name,
    length(name) as '이름(byte)', -- 한글은 1자에 3바이트. 
    char_length(name) as '이름 글자 수'
from users;

-- replace : 문자열의 일부를 다른 문자열로 바꾼다.
select
	email,
    replace(email, 'example.com', 'wanted.co.kr') as '변경 후'
from users;

-- 숫자 관련 내장 함수
-- round, ceil, floor
-- 반올림, 올림, 내림
select
	score,
    round(score),
    round(score, 1), -- (소수점 첫번째 자리에서 반올림) 오버로딩
    ceil(score),
    floor(score)
from grades
where grade_id = 7;

-- 날짜/시간 관련 내장 함수

-- now, curdate, curtime
select now(), curdate(), curtime() ;
    
select
	created_at as 원본날짜, -- 띄어쓰기 안 할려면 글자 붙여써야됨. 띄어쓰기 ㄴ
    year(created_at),
    month(created_at),
    day(created_at)
from users;

-- date_format : 날짜 데이터를 원하는 문자열 형식으로 변환
-- (포멧팅 형식 : %Y(4자리년도), %m 월, %d 일, %H 24시, %i 분, %s 초)
-- 저런 포멧 향식 실제 정규표현식에 기반한다. 정규표현식은 절대 외우지 말고
-- 우리가 날짜를 변환해야 할 때 정규표현식을 쓰면 어떨까? 라는 생각만 가지면 된다.
select
	created_at,
    date_format(created_at, '%Y년 %m월 %d일') as 가입일
from users;

-- 조건 함수 (빈도 높을 수 있음)
-- if-else

-- user_profiles 테이블에서bio(자기소개) null인 경우,
-- null 대신 '자기소개서 미작성' 이라고 표시해보자.
select
	user_id,
    ifnull(bio, '자기소개서 미작성') as '자기소개'
from user_profiles;

-- case : 복잡한 조건부 로직을 작성한다.
-- courses 테이블의 status 값에 따라 '게시됨', '초안' 으로 알아보기 쉽게 조회
select
	title,
    status,
    case
		when status ='published' then '게시됨'
        when status = 'draft' then '초안'
        else '기타'
	end as '과정 상태'
from courses;

-- grades 테이블의 점수에 따라서 95점 이상 A+ 90 / A 85 / B+ 80/ B 75 / 70 C /그 밑 D
select 
	u.name,
    g.score,
    case
		when g.score >=90 then 'A'
		when g.score >=80 then 'B'
		when g.score >=70 then 'C'
		else 'D'
	end as '등급'
from grades as g
join users as u on g.user_id = u.user_id;
	
select * from grades;


