const number = document.querySelector("#number");
const lower = document.querySelector("#lower");
const add = document.querySelector("#add");

lower.addEventListener("click", lowerCount);
add.addEventListener("click", addCount);

let count = 0;

function lowerCount() {
  count--;
  number.innerHTML = count;
  if (number.innerHTML < "0") {
    number.style.color = "red";
  } else if (number.innerHTML === "0") {
    number.style.color = "black";
  }
  number.animate([{ opacity: "0.2" }, { opacity: "1.0" }], {
    duration: 500,
    fill: "forwards",
  });
}

function addCount() {
  count++;
  number.innerHTML = count;
  if (number.innerHTML > "0") {
    number.style.color = "#4caf50";
  } else if (number.innerHTML === "0") {
    number.style.color = "black";
  }
  number.animate([{ opacity: "0.2" }, { opacity: "1.0" }], {
    duration: 500,
    fill: "forwards",
  });
}
