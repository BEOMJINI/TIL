const animals = ["뱀", "고양이", "강아지", "토끼"];

for (let i = 0; i < animals.length; i++) {
  console.log(animals[i]);
}
animals.forEach((val) => console.log(val));

function myCallback(num) {
  console.log(num);
}
function printAll(arr, callback) {
  for (let i = 0; i < arr.length; i++) {
    callback(arr[i]);
  }
}
printAll([1, 2, 3, 4, 5], myCallback);

animals.some;
animals.every;
animals.find;
animals.findIndex;
animals.filter;
animals.map;
animals.sort;
animals.reduce;

console.log("----------------------------");
let arr = [];
for (let i = 0; i < 10; i++) {
  let a = parseInt(Math.random() * 10) + 1;
  if (!arr.includes(a)) {
    arr[i] = a;
    i++;
  }
  i--;
}
arr.forEach((val) => console.log(val));
let three = arr.filter((val) => val % 2 != 0);
console.log(three);
let four = arr.reduce((sum, val) => (sum += val), 0);
console.log(four);

// function five(arr) {
//   let a = arr.filter((val) => val % 2 == 0);
//   let b = a.reduce((sum, val) => (sum += val));
//   return b;
// }
// console.log(five(arr));

let five = arr
  .filter((val) => val % 2 == 0)
  .reduce((sum, val) => (sum += val), 0);
console.log(five);
let six = arr.sort((a, b) => b - a);
console.log(six);
let cat = { kind: "고양이", age: 5 };
let dog = { kind: "개", age: 4 };
let rabbit = { kind: "토끼", age: 0.5 };
let hamster = { kind: "햄스터", age: 1 };
let pets = [cat, dog, rabbit, hamster, cat];
let seven = pets.sort((a, b) => b.age - a.age);
console.log(seven);
