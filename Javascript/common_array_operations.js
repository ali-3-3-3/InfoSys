const array = [1, 2, 3, 4];

//Q1. Use the map function on array and return a new array (which is assigned to arraySquare)
//with each of the values that is square of the original value.
//Complete implementation...
const arraySquare = array.map(function(value){
    return value * value;
    });

console.log(arraySquare); //should print out [1, 4, 9, 16]



//Q2. Use the filter function on array and return a new array (which is assigned to arrayOnlyEven)
//that keep only the even values
//Complete implementation...
const arrayOnlyEven = array.filter(function(value){
    return value % 2 === 0;
    });

console.log(arrayOnlyEven); //should print out [2, 4]

