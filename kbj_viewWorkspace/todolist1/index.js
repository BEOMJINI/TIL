const input = document.querySelector(".footer_input");
let data = "";
const addBtn = document.querySelector(".footer_btn");

const items = document.querySelector(".items");
const item = document.querySelector("item");

const deleteBtn = document.querySelector(".item_delete");

addBtn.addEventListener("click", () => {
  addItem();
});

input.addEventListener("keypress", (event) => {
  if (event.key === "Enter") {
    data = input.value;
    input.value = null;
  }
  console.log(data);
});
function addItem() {
  if (data.trim() == "") {
    alert("입력하지 않았음");
    return;
  }
  const li = document.createElement("li");
  li.classList.add("item_row");
  items.appendChild(li);
  const div = document.createElement("div");
  div.classList.add("item");
  li.appendChild(div);
  const span = document.createElement("span");
  span.classList.add("item_name");
  span.innerHTML = `${data}`;
  div.appendChild(span);
  const button = document.createElement("button");
  button.classList.add("item_delete");
  button.innerHTML = '<i class="fa-regular fa-trash-can"></i>';
  div.appendChild(button);
  data = "";
}

deleteBtn.addEventListener("click", () => {});
