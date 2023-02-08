function mySort(arr) {
  for (let i = 0; i < 5; i++) {
    for (let j = i; j < 5; j++) {
      if (arr[i] > arr[j]) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
  }
  return arr;
}

function myReverse(arr) {
  for (let i = 0; i < 5; i++) {
    for (let j = i; j < 5; j++) {
      if (arr[i] < arr[j]) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
  }
  return arr;
}
let numArr = [1001, 3423, 23, 32123, 123];

mySort(numArr);
console.log(numArr); // [23,123,1001,3423,32123]
myReverse(numArr);
console.log(numArr);
