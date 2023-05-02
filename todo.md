### 요구사항 1: HomeController
- HomeController 생성 및 home.jsp 로 매핑

### 요구사항 2: 중복된 코드 제거

- 모든 html 파일을 jsp 파일로 변경하기
- html 내 header, navigation 중복된 부분을 제거하기 -> header.jspf, navigation.jspf 생성 이후 import

### MVC 패턴 적용


- Controller interface : service
- DispatcherServlet : 클라이언트의 요청 URL 를 받음(사용자의 최초 진입 지점 -> 뷰에 대한 직접 접근을 방지)
: 모든 요청 url 에 대하여 DispatcherServlet 이 적절한 Controller 을 통해 처리.

- RequestMapping : 요청 URL 에 따라서 적절한 Controller 에게 작업을 위임
