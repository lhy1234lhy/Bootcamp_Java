-- 모든 행 모든 컬럼 조회
-- EMPLOYEE테이블에서 모든 정보 조회
select * from employee;

-- 원하는 컬럼 조회
-- EMPLOYEE 테이블의 사번, 이름 조회
select EMP_ID, EMP_NAME from employee;

-- 원하는 행 조회
-- EMPLOYEE 테이블에서 부서코드가 D9인 사원 조회
select * 
from employee
where DEPT_CODE = 'D9';

-- 원하는 행과 컬럼 조회
-- EMPLOYEE 테이블에서 급여가 300만원 이상인 사원의
-- 사번, 이름, 부서코드, 급여를 조회하세요
select EMP_ID, EMP_NAME, DEPT_CODE, SALARY
from employee
where SALARY >= 3000000;

-- 부서코드가 D6이고 급여를 200만원보다 많이 받는 직원의
-- 이름, 부서코드, 급여 조회
select EMP_NAME, DEPT_CODE, SALARY
from employee
where DEPT_CODE = 'D6' and SALARY >= 2000000;

-- NULL값 조회
-- 보너스를 지급받지 않는 사원의
-- 사번, 이름, 급여, 보너스를 조회하세요
select EMP_ID, EMP_NAME, SALARY, BONUS
from employee
where BONUS is null;

-- EMPLOYEE테이블에서 급여를 350만원 이상
-- 550만원 이하를 받는
-- 직원의 사번, 이름, 급여, 부서코드, 직급코드를 조회하세요
select EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
from employee
where 3500000 <= SALARY <= 5500000;

-- EMPLOYEE테이블에서 성이 김씨인 직원의
-- 사번, 이름, 입사일 조회
select EMP_ID, EMP_NAME, HIRE_DATE
from employee
where EMP_NAME like '김%';

-- EMPLOYEE 테이블에서 '하'가 이름에 포함된
-- 직원의 이름, 주민번호, 부서코드 조회
select EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE
from employee
where EMP_NAME like '%하%';

-- EMPLOYEE테이블에서 전화번호 국번이 9로 시작하는
-- 직원의 사번, 이름, 전화번호를 조회하세요
-- 와일드 카드 사용 : _(글자 한자리), %(0개 이상의 글자)
select EMP_ID, EMP_NAME, PHONE
from employee
where PHONE like '___9%';

-- EMPLOYEE테이블에서 전화번호 국번이 4자리 이면서
-- 9로 시작하는 직원의 사번, 이름, 전화번호를 조회하세요
select EMP_ID, EMP_NAME, PHONE
from employee
where PHONE like '___9%';

-- 부서코드가 'D6' 이거나 'D8'인 직원의
-- 이름, 부서, 급여를 조회하세요
-- IN 연산자 : 비교하려는 값 목록에 일치하는 값이 있는지 확인
select EMP_NAME, DEPT_CODE, SALARY
from employee
where DEPT_CODE IN('D6', 'D8');

-- 이씨성이 아닌 직원의 사번, 이름, 이메일주소 조회
select EMP_ID, EMP_NAME, EMAIL
from employee
where EMP_NAME NOT LIKE '이%';

-- J2직급의 급여 200만원 이상 받는 직원이거나
-- J7 직급인 직원의 이름, 급여, 직급코드 조회
select EMP_ID, SALARY, JOB_CODE
from employee
where (JOB_CODE = 'J2' and SALARY >=2000000) or JOB_CODE = 'J7';

-- J7 직급이거나 J2 직급인 직원들 중
-- 급여가 200만원 이상인 직원의
-- 이름, 급여, 직급코드를 조회하세요
select EMP_NAME, SALARY, JOB_CODE
from employee
where (JOB_CODE = 'J7' or JOB_CODE = 'J2') and SALARY >= 2000000;

-- =======================================================================
-- 집계함수, Grouping

select * from employee;

-- EMPLOYEE 테이블에서 직원들의 주민번호를 조회하여
-- 사원명, 생년, 생월, 생일을 각각 분리하여 조회
-- 단, 컬럼의 별칭은 사원명, 생년, 생월, 생일로 한다.
select 
	EMP_NAME as '사원명', 
    SUBSTRING(EMP_NO, 1,2) as '생년',
	SUBSTRING(EMP_NO, 3,2) as '생월',
    SUBSTRING(EMP_NO, 5,2) as '생일'
from employee;
    
-- 날짜 데이터에서 사용할 수 있다.
-- 직원들의 입사일에도 입사년도, 입사월, 입사날짜를 분리 조회
select 
    SUBSTRING(HIRE_DATE, 1,4) as '입사년도',
	SUBSTRING(HIRE_DATE, 6,2) as '입사월',
    SUBSTRING(HIRE_DATE, 9,2) as '일사날짜'
from employee;

-- WHERE 절에서 함수 사용도 가능하다.
-- 여직원들의 모든 컬럼 정보를 조회
select *
from employee
where EMP_NO LIKE '_______2%';

-- 함수 중첩 사용 가능 : 함수안에서 함수를 사용할 수 있음
-- EMPLOYEE 테이블에서 사원명, 주민번호 조회
-- 단, 주민번호는 생년월일만 보이게 하고, '-'다음의 값은
-- '*'로 바꿔서 출력
select EMP_NAME, CONCAT(SUBSTRING(EMP_NO, 1,7),'*******') as 주민번호  
from employee;

-- EMPLOYEE 테이블에서 사원명, 이메일,
-- @이후를 제외한 아이디 조회
select EMP_NAME, SUBSTRING(EMAIL, 1, INSTR(EMAIL, '@')-1)
from employee;

-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 입사후 6개월이
-- 되는 날짜를 조회
select EMP_NAME, HIRE_DATE, DATE_ADD(HIRE_DATE, INTERVAL 6 MONTH) as '입사 후 6개월'
from employee;

-- EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 조회
select *
from employee
where HIRE_DATE <= DATE_SUB(NOW(), INTERVAL 20 year);

-- EMPLOYEE 테이블에서 사원명, 입사일,
-- 입사한 월의 근무일수를 조회하세요
-- select EMP_NAME, HIRE_DATE, HIRE_DATE

-- EMPLOYEE 테이블에서 직원의 이름, 입사일, 근무년수를 조회
-- 단, 근무년수는 현재년도 - 입사년도로 조회
-- select EMP_NAME, HIRE_DATE, DATE_SUHIRE_DATE 

-- EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보 모두 조회 (mod)
select  *
from employee
where EMP_ID %2 =1;


