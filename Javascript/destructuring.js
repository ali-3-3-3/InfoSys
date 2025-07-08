const person = {
  firstName: "John",
  lastName: "Smith",
  age: 20,
  location: "Singapore",
};

//Q1. Destructure the properties of person object into individual variables
//Complete implementation...

const { firstName } = person;

console.log(firstName); //should print out "John"

//Q2. Destructure the properties of person object into individual variables
//but rename (firstName, lastName, age, location) to be
//(personFirstName, personLastName, personAge, personLocation) respectively

//Complete implementation...

const { firstName: personFirstName , lastName: personLastName, age: personAge, location: personLocation } = person;

console.log(personFirstName); //should print out "John"

function getGreetings(person) {
  return "Hello " + person.firstName + " " + person.lastName;
}
console.log(getGreetings(person)); //should print out "Hello John Smith"

//Q3. It is also possible to destructure an object that is used as function parameter
//to its individual fields.
//Write a new function (getGreetingsDestructuring()) that will
//1) destructure the firstName and lastName of the person object
//2) make use of template literal to combine "Hello ", firstName, and lastName
//and return the greetings
//Complete implementation...
function getGreetingsDestructuring({ firstName, lastName }) {
  return `Hello ${firstName} ${lastName}`;
}


console.log(getGreetingsDestructuring(person)); //should print out "Hello John Smith"

//Q4. In additional to destructuring an object that is used as function parameter
//to its individual fields, it is also possible to define default values for these fields
//Write a new function (getGreetingsDestructuringWithDefault()) that will
//1) destructure the firstName and lastName of the person object
//2) make use of template literal to combine "Hello ", firstName, and lastName
//and return the greetings
//3) if firstName is not supplied, we should set a default value of "Jane"
//4) if lastName is not supplied, we should set a default value of "Doe"
//Complete implementation...
function getGreetingsDestructuringWithDefault({ firstName = "Jane", lastName = "Doe" } = {}){
  return `Hello ${firstName} ${lastName}`;
}


console.log(getGreetingsDestructuringWithDefault(person)); //should print out "Hello John Smith"
console.log(getGreetingsDestructuringWithDefault({})); //should print out "Hello Jane Doe"
console.log(getGreetingsDestructuringWithDefault()); //should print out "Hello Jane Doe"

//Q5. Other that destructuring properties of object, we can also destructure items
//of array. Destructure the 2 items of `array` to a variable named
//`value` and `func` respectively
const array = [
  5,
  function somefunction() {
    console.log("helo");
  },
];

const [value, func] = array;

//Complete implementation...

