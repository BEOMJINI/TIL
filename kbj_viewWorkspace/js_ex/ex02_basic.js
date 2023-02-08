{
  let name = "APPLE";
  const name1 = "BANANA";
  var name3 = "KIWI";
}

/* {} 블럭 스코프 -> 블럭 안에서만 사용가능 -> scope : 수업에 자바스크립트2주차 01.pdf 에 있음
    const -> 상수: 고정된 값 ,변경 불가
    var -> 블럭 무시, 권장되지 않음 */

function sayHi() {
  var name = "Santa";
  console.log("Hi", name, "!");
}
sayHi();

// 안쓰면 var 로 자동
fruitName = "MANGO";
console.log(fruitName);

// 함수
function addNum(a, b) {
  return console.log(a + b);
}
addNum(1, 1);
let a = 2;
let b = 2;
`${addNum(a, b)}`;

// 무명함수 -> 함수에 이름이 없는 함수
let callName = function printName(name) {
  console.log(name, "!");
};
callName("APPLE");

// ✨ 화살표함수 -> 보통 사용하는 함수 표현식
let minus = (a, b) => console.log(a - b);
minus(2, 1);

/* jsp 랜덤값 
  math.random() -> 0 이하 무작위 실수값
  parseInt(실수값) -> 정수값으로 변경
  */
let randomNum = parseInt(Math.random() * 10) + 1; // (0~9)+1 -> 1~10
console.log(randomNum);

let d = parseInt(Math.random() * 100) + 1;
let c = (d) => {
  if (d % 2 == 0) {
    console.log(d, "짝수");
  }
  if (d % 2 == 1) {
    console.log(d, "홀수");
  }
};
c(d);
let f = (d) => (d % 2 == 0 ? console.log(d, "짝수") : console.log(d, "홀수"));
f(d);

let e = parseInt(Math.random() * -200);
console.log(e);

let g = parseInt(
  Math.random() * (Math.floor(100) - Math.ceil(-100) + 1) + Math.ceil(-100)
);
console.log(g);

let arr1 = new Array(4);

console.log(arr1);

for (let i = 0; i < arr1.length; i++) {
  let h = parseInt(Math.random() * 201) - 100;
  arr1[i] = h;
  if (arr1[i] % 2 == 0) {
    check = false;
    break;
  }
}

console.log(arr1);

if (check) {
  console.log("전부 짝수");
} else {
  console.log("전부 홀수");
}
