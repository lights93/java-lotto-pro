# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 2단계: 문자열 덧셈 계산기
#### 기능 요구사항
- 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
- 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
- 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
- 숫자가 아닌 값을 전달한 경우 RuntimeException 예외가 발생해야 한다. (예 : “-”)

## 3단계: 로또(자동)
#### 기능 요구사항
- [X] 구입금액 입력
- [X] 구입금액 메시지 출력
- [X] 입력받은 구입 금액으로 구입 개수를 반환
- [X] 구입 개수 메시지 출력
- [X] 로또 번호 생성
- [X] 로또 번호 묶음 생성
- [X] 로또 번호 출력
- [X] 지난주 당첨 번호 입력
- [X] 당첨 결과 계산
- [X] 당첨금 계산
- [X] 수익률 계산
- [X] 당첨 통계 출력
- [X] 로또 시작
- [X] 금액 입력 validation
- [X] 당첨 번호 입력 validation
#### 코드리뷰 수정사항 반영
- [X] 도메인에서 값만 제대로 전달하도록 수정
- [X] 로또 결과 계산 수정
- [X] 로또 카운터 validation
- [X] 변수명 수정(text, list)
- [X] 생성자 위치 수정
- [X] 로또 번호를 관리하는 도메인 객체 추가
- [X] 로또 번호 text 생성자 제거
- [X] 프린트 인터페이스 제거

## 4단계: 로또(2등)
#### 기능 요구사항
- [X] 2등을 위해 추가 번호 하나 더 추첨
- [X] 당첨 통계에 2등도 추가
- [X] 로또 결과에 2등 추가
- [X] 당첨티켓 추가
- [X] 당첨티켓으로 결과계산 이동
- [X] 당첨티켓 결과계산 로직 변경
- [X] 보너스 번호 입력 validation 추가
#### 코드리뷰 수정사항
- [X] 랭크의 MISS만 제와한 값들을 return 하는 메서드 생성
- [X] 랭크의 isSecond 메서드 생성
- [X] 입출력 관련 로직 뷰로 이동
- [X] static만 있는 클래스 기본 생성자 private
- [X] 한 줄에 쓰면 보기 어려운 것들 어려 줄로 수정
- [X] ::을 이용하여 간편하게 수정