const message = document.querySelector("#message");
const sendBtn = document.querySelector("#sendBtn");
const lastMessage = document.querySelector("#lastMessage");

sendBtn.addEventListener("click", deliverMessage);

function deliverMessage() {
  let text = message.value;
  if (text === "") {
    alert("입력해주세요");
  } else {
    lastMessage.innerHTML = text;
    message.value = "";
  }
}
