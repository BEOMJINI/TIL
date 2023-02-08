function sayhi(name) {
  console.log(`hi ${name} !`);
}
sayhi("cat");

function saybye(name) {
  console.log(`bye ${name} !`);
}
saybye("cat");

function intro(a, b, c) {
  let d = a + b;
  c(d);
}
intro("black", "cat", intro(sayhi));
