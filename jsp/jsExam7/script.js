function showTime() {
  let date = new Date();
  let hours = date.getHours();
  let minutes = date.getMinutes();
  let seconds = date.getSeconds();

  let formatHours = convertFormat(hours);
  hours = convertHour(hours);

  hours = addZero(hours);
  minutes = addZero(minutes);
  seconds = addZero(seconds);

  document.getElementById(
    "clock"
  ).innerHTML = `${hours} : ${minutes} : ${seconds} ${formatHours}`;
}

function convertFormat(time) {
  let format = "AM";
  if (time > 12) {
    format = "PM";
  }
  return format;
}

function convertHour(time) {
  let hours = time;
  if (hours > 12) {
    hours -= 12;
  }
  if (hours === 0) {
    hours = 12;
  }
  return hours;
}

function addZero(time) {
  if (time < 10) time = "0" + time;
  return time;
}

showTime();
setInterval(showTime, 1000);
