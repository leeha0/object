# Chapter4 설계 품질과 트레이드 오프
* 객체지향 설계의 핵심 요소
    * 객체지향 설계의 핵심은 `역할, 책임, 협력`이며, 객체 지향 설계 관점에서 `책임`이 가장 중요하다
    * 협력: 애플리케이션의 기능을 구현하기 위해 메시지를 주고받는 객체들 사이의 상호작용
    * 책임: 객체가 다른 객체와 협력하기 위해 수행하는 행동
    * 역할: 대체 가능한 책임의 집합
    → `책임의 분배가 잘못되면 원활한 협력도 이루어지지 못한다`
* 객체지향 설계?
    * 올바른 객체에게 올바른 `책임을 할당`하면서 `낮은 결합도`와 `높은 응집도`를 가진 구조를 창조하는 활동
    → `객체의 책임에 초점을 맞추면 결합도와 응집도를 합리적인 수준으로 유지할 수 있다`

### 01 데이터 중심의 영화 예매 시스템
* 시스템을 객체로 분할하는 방법
    * 상태를 분활의 중심축으로 삼는 방법
    * 책임을 분할의 중심축으로 삼는 방법
* 데이터 중심 관점
    * 자신을 포함하고 있는 데이터를 조작하는데 필요한 오퍼레이션을 정의
    * 객체의 상태에 초점
    * 독립된 데이터 덩어리 
    * 구현
    * 불안정하며 변경의 여지가 있어 변경에 취약
    * 캡슐화의 원칙이 무너짐
* 객체 중심 관점
    * 다른 객체가 요청할 수 있는 오퍼레이션을 위해 필요한 상태를 보관
    * 객체의 행동에 초점
    * 협력하는 공동체의 일원
    * 인퍼테이스
    * 안정적이며 변경에 의한 파장이 외부로 퍼지는 것을 방지 
    * 캡슐화의 원칙을 지킴
→ `책임에 초점을 맞추어 설계해야 한다.`
#### 데이터를 준비하자
* 데이터 중심의 설계란 객체 내부에 저장되는 데이터를 기반으로 시스템을 분할하는 방법이다
→ `Movie의 데이터 결정 - title, runningTime, fee, discountConditions, movieType, discountAmount, discountPercent`
* 내부 데이터를 반환하는 접근자와 데이터를 변경하는 수정자 추가
→ `DiscountConditions 설계 - DiscountConditionType, sequence, dayOfWeek, startTime, endTime`
* 상호 배제되는 데이터를 같은 클래스에 위차하는 경우 대부분 데이터 중심의 설계이다
    * discountAmount vs discountPercent
    * sequence vs dayOfWeek, startTime, endTime

### 02 설계 트레이드오프
* 품질 척도: `캡슐화, 응집도, 결합도`

#### 캡슐화
* 캡슐화는 외부에서 알 필요가 없는 부분을 감춤으로써 대상을 단순화하는 추상화의 한 종류다
→ `어떠한 변경사항에 대한 전체 시스템의 영향을 끼치지 않도록 적절하게 조절하는 장치 제공`
* 구현: 변경될 가능성잉 높은 부분
* 인터페이스: 상대적이로 안정적인 부분 
→ `변경의 정도에 따라 인터페이스로 분리하고 인터페이스에만 의존하도록 설계하는 것이 중요`
→ `유지보수성이 목표`

#### 응집도와 결합도
* 응집도: 모듈에 포함된 내부 요소들이 연관돼 있는 정보를 나타낸다
* 결합도: 의존성의 정보를 나타내며 다른 모듈에 대해 얼마나 많은 지식을 갖고 있는지를 나타내는 정도다
* 좋은 설계란 높은 응집도와 낮은 결합도를 가진 모듈로 구성된 설계
* 클래스의 구현이 아닌 인터페이스에 의존하도록 코드를 작성해야 낮은 결합도를 얻을 수 있다
→ `인터페이스에 대해 프로그래밍하라`

### 03 데이터 중심의 영화 예매 시스템의 문제점
* 캡슐화 위반
* 높은 결합도
* 납은 응집도

#### 캡슐화 위반
* 객체 내부의 상태에 대한 어떤 정보도 캡슐화하지 못한다
* 접근자와 수정자에 과도하게 의존하는 설계방식은 추측에 의한 설계 전략이라고 부른다

#### 높은 결합도 
* 데이터 중심 설계는 객체의 캡슐화를 약화시키고 클라이언트가 객체의 구현에 강하게 결합된다
* 제어 로직이 특정 객체에 집중되어 데이터가 객체에 강하게 결합된다

#### 낮은 응집도
* 변경의 이유가 서로 다른 코드들이 하나의 모듈에 있어 변경과 아무 상관이 없는 코드들이 영향
* 하나의 요구사항을 반영하기 위해 동시에 여러 모듈을 수정

> 단일 책임 원칙(Single Responsibility Principle, SRP)  
> : 클래스는 단 한 가지의 변경 이슈만 가져야 한다는 것이다. 클래스의 응집도를 높일 수 있는 설계 원칙이다.
    