# 2023-04-10
```
Table_name : mission   
column 1 : id(Pk) int   
column 2 : complate boolean   
column 3 : complate_time timestamp
```

일 때,   
완료 여부와 완료 시간이 있는데 이때 완료 여부는 필요없음   
-> 완료 시간이 찍히면 완료, null이면 미완료   
```
Table_name : conference   
column 1 : id(Pk) int   
column 2 : start_time timstamp
column 3 : end_time timestamp
column 4 : in_progress boolean
column 5 : duration int
```


일 때,

duration은 회의 진행 시간, in_progress는 회의 진행중인 여부

회의 진행 중일때 start_time은 찍혔고 end_time이 안찍히면 회의중, 그 외의 상황은 회의 중이 아님

end_time - start_time은 duration

따라서 in_progress, duration은 필요없음

# 2023-04-11 AM
```
Table_name : user
column 1 : email(Pk) varchar
column 2 : name varchar
column 3 : gender boolean
```


PK를 VARCHAR로 쓸 때 문제점

01. white space 문자가 들어가면 인식하기 어려움

 -> 오타나 눈에 보이지 않는 문자때문에 오류가 날 수 있다.
 
02. join시 속도가 느리다.

 -> 정수형 int보다 느리다.
 
03. varchar 수정 가능성이 있다.

 -> 수정할 가능성이 있기 때문에 위험하다.
 
 
 
 ---
 
 
 변경 후
 ```
Table_name : user
column 1 : id(pk) int
column 2 : email varchar
column 3 : name varchar
column 4 : gender boolean
```
 
 ---
 # 2023-04-11 PM
 ```
Table_name : user
column 1 : id(pk) bigint
column 2 : email varchar
column 3 : name varchar
column 4 : password varchar
```

-> unsigned int 를 사용한다면 42억개까지 id로 사용가능한데 굳이 bigint를 쓰면 속도도 느리고 불필요하다.

---
# 2023-04-12 AM
```
Table_name : user
column 1 : id(pk) int
column 2 : email varchar
column 3 : name varchar
column 4 : nickname varchar
column 5 : password varchar
column 6 : birth date
column 7 : gender boolean
column 8 : role int
column 9 : thumb varchar
column 10 : subscribe int
column 11 : email_notify boolean
column 12 : sms_notify boolean
column 13 : push_alarm boolean
```
-> 너무 많음 보통 7~8개?

-

변경 후
```
Table_name : user
column 1 : id(pk) int
column 2 : email varchar
column 3 : name varchar
column 4 : nickname varchar
column 5 : password varchar
column 6 : birth date
column 7 : gender boolean
column 8 : role int
column 9 : thumb varchar
```
-
```
Table_name : config
column 1 : id(pk) int
column 2 : subscribe int
column 3 : email_notify boolean
column 4 : sms_notify boolean
column 5 : push_alarm boolean
column 6  : user_id(FK) int
```

#### 기능별로 나누어서 관리

---

# 2023-04-12 PM

Response를 반환할 때
```
200 OK

body{

\t "status" : "success",

 "data" : {
 
   "title" : "sample",
 
   "content" : "Hello World"
 
  }
 
 }
 ```
 ```
 401 Unauthorized
 
 body{
 
  "status" : "failed",
 
  "msg" : "no Authentication"
 
 }
 ```
 으로 준다면, 상태(200, 401)와 status가 2번씩 전송되어 어느 기준으로 해야하는지 애매할 수 있음
 
 따라서 상태(200, 401)만 주는 것이 바람직.
 ```
 200 OK

body{
 
  "title" : "sample",
 
  "content" : "Hello World"
 
 }
 ```
 ```
 401 Unauthorized
 
 body{
 
  "msg" : "no Authentication"
 
 }
```
---
 # 2023-04-13 AM
 
 - 게시판 댓글을 가져올 때 아무것도 없다면 
```
 - Bad : 404 Not Found => 데이터가 없을 뿐 비 정상적인 상황은 아니기 때문에 에러를 반환하면 안된다. 
 - Good : 200 OK Body []
```
