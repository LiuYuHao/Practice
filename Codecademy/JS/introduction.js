console.log("Hello0");  // a statement must end with semic, consoel is a object, this is print
/* mutil line comments */
// 7 Data type : number, string, boolean, null, undefine(represrnt absent of value not null), symbol and object.
// Arithmetic Operator : + - * / %
// + is work on string
console.log("Hello".length); // print the length of stirng
console.log("  Hello  ".trim()) // to remove the space between front and back
console.log(Math.floor(Math.random() * 100));// Math is another object, random return number from 0 - 1, and floor round the number to whole
console.log(Math.ceil(43.8)); // ceil return the smallest whole number near the arguemnt - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math
console.log(Number.isInteger(2017)); // check if integer, number is a object -https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number
var numOfSlice = 'pizza'; // using var to declare a variable, let and const in es6
// let a = 'a'; // different is var for global var, let is limited in a scope
const my = 'my' // const for constant, cannot be reassigned
// let levelUp = 10;
// let powerLevel = 9001;
// let multiplyMe = 32;
// let quarterMe = 1152;
// levelUp += 5;
// powerLevel -= 100;
// multiplyMe *= 11;
// quarterMe /= 4;
// there is mathematical Assignment Operator;
//levelUp++;
//powerLevel--;
// there has increasement and decreasemnt
console.log("hello" + " world"); // string concatenation
// es6 for varaible and string together
var myCity = "godland";
var myName = "Yu Hao"
console.log(`My name is ${myName}. My favorite city is ${myCity}.`); // instead of "", it used ``
var newVariable = 'Playing around with typeof.';
console.log(typeof newVariable);
newVariable = 1;
console.log(typeof newVariable);// using typeof to know the type of variable
// conditional
if (false) {
  console.log("here");
}
else if (false) {
  console.log("there");
}
else {
  console.log('done');
}
// comparison operator < > <= >= === !==
// logical operator || && !
// truthy value = when a var has a value, falsy value = 0, null, undefine, empty string, not a number(NaN, 1/0)
var tool = '';
var writingUtensil = tool || "pen";
// short-circuit evaluation, if tool is falsy then it will be pen otherwise it takes value of tool
// ternary opertor condition ? first output : second output
// swtich(condition) {case target: body break;}
// funtion/method
greetworld(); // JavaScript allowed to call the function before it define
function greetworld() {
  let text = "hello world";
  console.log(text);
}
greetworld();
// es6 there has defualt parameter, give value to parameter if it is not assigne in the function.
// helper fucntion = the function inside another function
// another way to deine function is using function expression, make a variable as the name of function then set = function
var sad = function(arg) { console.log("body")};
// es6 introduces arrow function, instead of function, we just add -> toward the body = (arg) => {body}
// function can be short, if the fucntion only one line, we can remove the {} therefore, the evalution of the line will auto return
// if arg is single, the () is not needed.
// array declartion
const array = ["elment"]; // any type
// the difference between let and const of array is the element in the elemnt still changable but the array cannot assign to a new array
console.log(array.length);
array.push("3"); // push = add item in array (last position)
console.log(array);
array.pop(); // no arugment, remove the last item;
array.shift(); // remove the first item
array.unshift("here"); // add to first item
console.log(array);
array.slice(0); // only the element from that range (2 is not included)
array.indexOf("here"); // find the index of input in this array
const nestArray = [[1,2],[2,3]]; // array in side of array using [][] to access
// loop
for (let x = 3; x < 4; x++) {
  console.log("for loop");
} // same structure as c++ and java
while(false) {
  console.log("nop");
} // while loop structure
do {
  console.log("run once");
} while(false); // do while sturture
// we can reasign the function to another new name
const newName = greetworld;
newName();
console.log(newName.name); // we are able to check the name of original function
const callGreetWorld = func => func();
callGreetWorld(greetworld); // use function as agrugment and call.
// for each method for array, the argument is the call back function
array.forEach(element => {console.log(element)}); // return undefined
// map for create a new array with some add-on
const mapArray = array.map(element => element + "change"); // second arugment is index
console.log(mapArray);
// filter is creating new array with some condition, like filter out something you don't want
const filterArray = array.filter(element => element === "herechange");
console.log(filterArray);
// findIndex() a method to find the index where element is match to your condition
const findIndexArray = array.findIndex(element => element === "here");
console.log(findIndexArray);
// reduce function, return a single value after iterating throught the element in array (add them together),
// the second arguemnt of reduce is going to replace accumulator, otherwise accumulator is first element and
// currentValue is second element
const newNumbers = [1, 3, 5, 7];

const newSum = newNumbers.reduce((accumulator,currentValue) => {
  console.log('The value of accumulator: ', accumulator);
  console.log('The value of currentValue: ', currentValue);
  return accumulator + currentValue;
},10);

console.log(newSum);
//some method, it will iterating and return true if there is a element match to the condition otherwise it return false
const words = ['unique', 'uncanny', 'pique', 'oxymoron', 'guise'];

// Something is missing in the method call below

console.log(words.some(word => {
  return word.length < 6;
}));
// every method, it iwll check if every element pass or not


///////////////////
// obejct
// an unoffical way to declare object, below are property
// comma to seperate from each property
let fasterShip = {
  'color' : 'silver',
  'Fuel Type' : 'Turbo Fuel'
}
// access to object dot and []
// u can add and delete by dot and delete with []
fasterShip.color = 'test';
delete fasterShip['color'];
console.log(fasterShip);
// to create a method in object, name () {} (no semico, we use comma if there is second element)
// obejct is pass by reference therefore, once u make the change it stay there.we can use obj as arugment to change the real Global_Objects
let change = obj => obj.color = "red";
change(fasterShip);
console.log(fasterShip);
// looping in obect for .. in ..
for (let element in fasterShip) {
  console.log(element);
}

for (let i in array) {
  console.log(array[i]);
}
// same as python
// inside of object, we don't have access to other property when in property of the Global_Objects
// therefore, this is where it coming from
// note: arrow function and this cannot together, name: () => {}
// there doens't have private, but people like to use _ to tell other peopel how to
// getter - to get the internal information, get name () {}, when we call it we don't need () of the name. obj.name
// setter - to change the internal of object, set name (arg) {}, when we call it we don't need () too , obj.setter = argu
// create a general object
const robotFactory = (model, mobile) => {
  return {
    model : model, // es6 just model,
    mobile : mobile, // es6 just mobile,
    beep () {
      console.log('Beep Boop');
    }
  }
}
const tinCan = robotFactory('P-500',true);
// destructured assignment const {name} = obj, get the value of that name with that name as var,
// it can get the nest value
const {model} = tinCan;
console.log(model);
// built-in object method .hasOwnProperty() and .valueOf()
// Object.keys(obj) return all the key of obj
// Object.entriess(obj) return a array deplays all the key and value as array of array
// Object.assign({},obj) return a obj with all property of obj and additional elment of {}
//////////////////
//class
class dog {
  constructor(name,age) {
    this._name = name;
    this._age = age;
  }
  get name() {
    return this._name;
  }
  set name() {

  }
}
const dog1 = new dog("Haowen",22);
// Inheritance , extend - able to use method from parent class and super(name) - constructor of parent class to set this.name = name
class HospitalEmployee {
  constructor(name) {
    this._name = name;
    this._remainingVacationDays = 20;
  }

  get name() {
    return this._name;
  }

  get remainingVacationDays() {
    return this._remainingVacationDays;
  }

  takeVacationDays(daysOff) {
    this._remainingVacationDays -= daysOff;
  }
}

class Nurse extends HospitalEmployee  { // extends parent class
  constructor(name, certifications) {
    super(name); // construct name from parent
    this._certifications = certifications;
  }
  get certifications() {
    return this._certifications;
  }
  addCertification (newCertification) {
    this._certifications.push(newCertification);
  }
}

const nurseOlynyk = new Nurse('Olynyk', ['Trauma','Pediatrics']);
nurseOlynyk.takeVacationDays(5);
console.log(nurseOlynyk.remainingVacationDays);
nurseOlynyk.addCertification('Genetics');
console.log(nurseOlynyk.certifications);

// Static Mehods - the method can call from class, not instance requre, u don't need to make a instance in order to use method
// static name() {}
/////////////
// module
// the step is create a object to present the module, do anything u want to the object, then last exports the object
/*
let Airplane = {};
Airplane.myAirplane = "StarJet";
module.exports = Airplane;
//////
// another way
const airplane = {};
module.exports = {
  myAirplane : "CloudJet",
  displayAirplane: function() {
    return this.myAirplane;
  }
};
///// es6 way
const Airplane = {};
// add property to Airplane
export default Airplane; // equal to module.exports

*/
// when we want to use the module from another file or anything, using require
// const Menu = require('./menu.js'); // we need the object to represent the module
// es6 import Airplane from './airplane';
// export {object and methods that you create} on another file import {the thing u want} from the file, this prevent of calling from object
// export prefix of function or object can be use as soon as possible when they declared export object = {}
// when we export we can export as to change the name. then import them as same name
////////////////////
///////////////////
// request - send
// setTimeout(function,x) it set the x mmillsecond to display the function - even loop
// Using xhr object to get request,
const xhr = new XMLHttpRequest(); // create xhr request Object
xhr.responseType = 'json'; // the type of response
// get, get data from source
xhr.onreadystatechange = () => {
  if (xhr.readyState === XMLHttpRequest.DONE) {
    renderResponse(xhr.response);
  }
}
// this is check if the request is done or not
xhr.open('GET', url); // this create a new request and the method and the arument
xhr.send(); // send to the server
// post difference is when we send it require an argument (data)
// and addtional a arugemnt with data that u want to send with json type(some one)
// es6 request
// example
fetch('https://api-to-call.com/endpoint').then(
	response => {
    if (response.ok) {
      return response.json();
    }
    throw new Error('Request failed!');
	}
, networkError => { // the second arugemnt for check the network error
  console.log(networkError.message);
})
.then( jsonResponse => {
  return jsonResponse;
})
//
