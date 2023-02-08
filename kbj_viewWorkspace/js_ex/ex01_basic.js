// println ("test")
console.log("test");

let num = 10;
console.log(num);
console.log(typeof num);
num = "test";
console.log(num);
console.log(typeof num);
num = true;
console.log(num);
console.log(typeof num);

console.log(10 + 3);
console.log("same", Math.pow(10, 3));
console.log(10 ** 3);

/* java랑 다르게 jsp에서는 에러로 인식하지않는 것 */
console.log(2 - "test"); // NaN -> not number
console.log(10 / 0); // Infinity -> 무한대
console.log(0 / 10); // 0

let fruitName = "APPLE";
console.log(fruitName);
fruitName = "KIWI";

/* 값 불러오려면 ` 이거 쓰고 $ 이거 쓴다 */
/* ${} -> 템플릿 리터럴 */
let callName = `name is ${fruitName} .`;
console.log(callName);

/* 문자가 먼저오면 다 문자로 인식한다 , 문자 다음에오는 + 는 연결연산자 */
console.log("3" + 10 + 5); // 3105
console.log("3" + (10 + 5)); // 315

/* boolean :   0, "", null, undefined, NaN -> jsp에서 기본이 false 값 */
console.log(0);
console.log(!0);
console.log(!!0);
console.log(!null);
console.log(!!undefined);
console.log(!NaN);

let animal;
console.log(animal); // undefined -> 변수를 선언만하고 , 아직 무슨값인지 모름
animal = "null";
console.log(animal); // null -> 변수에 null 할당 , 쓸건데 일부러 비워 뒀다는 의미로 쓰임

console.log(typeof null); // object -> null == 빈 객체
console.log(typeof undefined); // undefined

console.log(!10);
console.log(!-19);
console.log(!"test");
console.log(![]);
console.log(!{});
console.log(!Infinity);

console.log(10 == "10"); // true -> 데이터타입 무시하고 자동 형변환이 되는 데이터값이면 자동으로 변환해서 값 비교
console.log(10 === "10"); // false -> 데이터타입, 자료 비교
console.log(true === "true");

/* jsp -> 값은 자료형 존재 , 변수는 자료형 존재 안함 
        배열은 여러 데이터타입이 들어올 수 있다. -> 그러나 권장X 배열은 같은 자료형 타입끼리 사용*/
let arr = [1, 2, 3, 4, 5, "2", "test", true, NaN];
let arr2 = new Array(3);
console.log(arr2); // arr2[empty empty empty]
console.log(arr2[0]); // undefined -> arr2[undefined undefined undefined]
console.log("same ->", typeof arr2[0]);
arr2[0] = 1;
arr2[1] = 2;
arr2[2] = 3;
arr2[3] = 4; /* java -> indexOutOfBound error
                jsp -> 자동으로 길이 추가해서 넣는다 */
console.log(arr);
console.log(arr2);

console.log(arr2.length);
delete arr2[1]; // 순수하게 값만 삭제 -> 빈 공간은 empty -> undefined로 남겨둠
console.log(arr2);

// 리터럴 객체
let kiwi = {
  kind: "fruit",
  name: "키위",
  isEat: true,
};
/* 객체 자료형 접근방법 
1. 마침표 표기법   
2. 대괄호 표기법 [""] */
console.log(kiwi.isEat);
console.log(kiwi["isEat"]);

// 객체에 속성값 추가하는 법
kiwi["recipe"] = ["그냥 먹다", "쥬스"];
console.log(kiwi);

// 객체 얕은 복사
let sport = {
  name: "축구",
};
let otherSport = sport;
console.log(sport);
console.log(otherSport);
sport.name = "야구";
console.log(sport.name);
console.log(otherSport.name);

// 노션 수업에 올라와있음
