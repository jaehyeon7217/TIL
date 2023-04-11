Table_name : mission

column 1 : id(Pk) int

column 2 : complate boolean

column 3 : complate_time timestamp


일 때,

완료 여부와 완료 시간이 있는데 이때 완료 여부는 필요없음

-> 완료 시간이 찍히면 완료, null이면 미완료


Table_name : conference

column 1 : id(Pk) int

column 2 : start_time timstamp

column 3 : end_time timestamp

column 4 : in_progress boolean

column 5 : duration int



일 때,

duration은 회의 진행 시간, in_progress는 회의 진행중인 여부

회의 진행 중일때 start_time은 찍혔고 end_time이 안찍히면 회의중, 그 외의 상황은 회의 중이 아님

end_time - start_time은 duration

따라서 in_progress, duration은 필요없음



Table_name : user

column 1 : email(Pk) varchar

column 2 : name varchar

column 3 : gender boolean



PK를 VARCHAR로 쓸 때 문제점

01. white space 문자가 들어가면 인식하기 어려움
2. 
 -> 오타나 눈에 보이지 않는 문자때문에 오류가 날 수 있다.
 
02. join시 속도가 느리다.
3. 
 -> 정수형 int보다 느리다.
 
03. varchar 수정 가능성이 있다.
4. 
 -> 수정할 가능성이 있기 때문에 위험하다.
 
 
 
 ---
 
 
 변경 후
Table_name : user

column 1 : id(pk) int

column 2 : email varchar

column 3 : name varchar

column 4 : gender boolean

 
 



