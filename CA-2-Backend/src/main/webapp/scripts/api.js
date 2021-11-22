/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const fetchDataBtn = document.querySelector("#fetchdata");
const result = document.querySelector("#result");

// gets data from API and sets the content of #result div
const getData = function () {
  result.innerText = "Loading....";
  fetch("https://api.chucknorris.io/jokes/random")
    .then((res) => res.json())
    .then((data) => {
      result.innerText = JSON.stringify(data, null, 2);
    })
    .catch((error) => console.log(error));
};

// add event listener for #fetchdata button
fetchDataBtn.addEventListener("click", getData);
