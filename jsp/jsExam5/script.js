const img = document.querySelector("#img");
const prev = document.querySelector("#prev");
const next = document.querySelector("#next");

const imgSource = ["img/1.png", "img/2.png", "img/3.png", "img/4.png"];

let imgNum = imgSource.indexOf(img.getAttribute("src"));

prev.addEventListener("click", prevImage);
next.addEventListener("click", nextImage);

function prevImage() {
  if (imgNum > 0) {
    imgNum--;
    img.src = imgSource[imgNum];
  }
}
function nextImage() {
  if (imgNum < 3) {
    imgNum++;
    img.src = imgSource[imgNum];
  }
}
