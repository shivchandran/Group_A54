function clearScreen() {
  document.getElementById("result").value = "";
}

function backspace() {
  let result = document.getElementById("result").value;
  document.getElementById("result").value = result.substring(0, result.length - 1);
}

function append(value) {
  document.getElementById("result").value += value;
}

function calculate() {
  let result = eval(document.getElementById("result").value);
  document.getElementById("result").value = result;
}
