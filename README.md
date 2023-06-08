# springBackend
스프링과 리액트 백엔드 입니다!
backend : spring datajpa, jpa, mysql, aws ec2, h2, lombok, spring security, jwt token
frontend : react 
server : ec2

aws backend elastic ip : http://13.124.30.40:8080
aws frontend elastic ip : http://3.39.145.245:3000/

MYSQL RDS 설정 방법
https://velog.io/@dohaeng0/AWS%EC%97%90-Spring-Boot-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EB%B0%B0%ED%8F%AC-1-RDS-MySQL-%EC%84%B8%ED%8C%85

백엔드 ec2 무중단 구성 (https://suyeoniii.tistory.com/52)
nohup java -jar build/libs/demo-0.0.1-SNAPSHOT.jar & > /dev/null

프론트 무중단 구성 ( https://velog.io/@pp2lycee/pm2%EC%99%80-serve%EB%A1%9C-%EB%AC%B4%EC%A4%91%EB%8B%A8-%EC%84%9C%EB%B9%84%EC%8A%A4%ED%95%98%EA%B8%B0)
npm run build
pm2 serve build 3000 --spa

nginx 설정 (https://tobegood.tistory.com/entry/Nginx%EB%A1%9C-React%EB%A5%BC-%EB%B0%B0%ED%8F%AC%ED%95%98%EA%B8%B0-%EC%9A%B0%EB%B6%84%ED%88%AC-%ED%99%98%EA%B2%BD)

백엔드 
전체 URL
GET / : http://13.124.30.40:8080/ (헬스체크 용도)
회원가입 POST auth/signup : http://13.124.30.40:8080/auth/signup
로그인(jwt token 사용) POST auth/signin : http://13.124.30.40:8080/auth/signin 

프론트엔드
전체 URL
로그인 GET /login    : http://3.39.145.245:3000/login
회원가입 GET /signup : http://3.39.145.245:3000/signup
메모페이지 GET /     : http://3.39.145.245:3000/ (유저 로그인 안되어 있는 경우에는 회원로그인 안됨)


백엔드 헬스체크 URL 
healthCheckPage : http://13.124.30.40:8080/ 
![image](https://github.com/sunggun1/springBackend/assets/17981550/68432d77-d6d4-4e75-b895-9377319d5399)

유저 로그인
![image](https://github.com/sunggun1/springBackend/assets/17981550/8a5d5517-c9e1-48a5-831f-0b866569c82d)

계정 생성
![image](https://github.com/sunggun1/springBackend/assets/17981550/2a9e068a-245e-4c82-be3f-91d540dc1735)

로그인이후 메모 페이지
![image](https://github.com/sunggun1/springBackend/assets/17981550/f512f4c9-1bd1-40c1-9814-44bb42de71d8)

















