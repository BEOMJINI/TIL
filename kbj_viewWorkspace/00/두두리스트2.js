const btn = document.querySelector("button");
const input = document.querySelector("input");
const textarea = document.querySelector("textarea");
const list = document.querySelector("#list");
const garbage = document.querySelector("#garbage");

let id = 1;
let textList = [];

garbage.addEventListener("dragover", (e) => e.preventDefault());
garbage.addEventListener("drop", (e) => {
  let items = [...document.querySelectorAll(".item")];
  console.log(e.dataTransfer.getData("num"));
  console.log(items);
  let foundText = items.find(
    (item) => item.getAttribute("data-id") == e.dataTransfer.getData("num")
  );
  console.log(foundText);
  list.removeChild(foundText);
});

btn.addEventListener("click", () => {
  addText();
});

function addText() {
  let t = String(input.value);
  let c = String(textarea.value);

  if (t.trim().length == 0 || c.trim().length == 0) {
    alert("미입력");
    input.value = "";
    textarea.value = "";
    input.focus();
    return;
  }
  trans();
  textList[id - 1] = t + c;
  // textList[id - 1].b = c;

  const div = document.createElement("div");
  div.classList.add("item");
  div.setAttribute("data-id", String(id));
  div.draggable = "true";
  div.innerHTML = `<h4 class="title">${t}</h4>
  <span class="msg">${c}</span>`;
  list.appendChild(div);
  id += 1;
  input.value = "";
  textarea.value = "";
  input.focus();

  div.addEventListener("dragstart", (e) => {
    e.dataTransfer.setData("num", e.target.getAttribute("data-id"));
  });
}

// p.style.display = "none";
let toggle = false;
function trans() {
  let p = document.querySelector("p");
  if (!toggle) {
    p.classList.add("active");
    setTimeout(() => {
      p.classList.remove("active");
    }, 1000);
  }
  //   } else {
  //     p.classList.remove("active");
  //   }
  toggle = !toggle;
}
