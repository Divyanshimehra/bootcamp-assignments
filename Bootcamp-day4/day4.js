//1. Convert to Arrow Function
const add = (a,b) => a + b;
console.log(add(2,6)); //output: 8
console.log(add(-5,10)); //output: 5


//2. Default Parameters
function greet(name='', message='Welcome'){
    return `${message} ${name}!`;
}

console.log(greet());
console.log(greet('Alice', 'Hello'));
console.log(greet('Bob'));


//3. Template Literals
function formatString(name='Divyanshi', age='23'){
    return `My name is ${name} and I am ${age} years old.`;
}

console.log(formatString('Charlie', '30'));
console.log(formatString('Aisha'));
console.log(formatString(undefined, '25')); //???????? if name default
console.log(formatString());


//4. Object Destructuring
const person = { name: 'Alice', age: 25, address: { city: 'New York', country: 'NY'}};
//Write a function that extracts the name and city properties and logs the sentence: "Alice lives in New York." It should also access and log the address object.
function extractInfo({name, address: {city}}){
    console.log(`${name} lives in ${city}.`);
    console.log('Address:',person.address);
}
extractInfo(person);


//5. Rest Operator
function sumAll(...numbers){
    return numbers.reduce((a,b)=> a+b, 0);
}

console.log(sumAll(1,2,3));
console.log(sumAll(10,20,30,40,50));


//6. Filter Even Numbers
function filterEvenNumbers(...numbers){
    return numbers.filter(num => num % 2 === 0);
}

console.log(filterEvenNumbers(1,2,3,4,5,6));
console.log(filterEvenNumbers(10,15,20,25,30));


//7. Array mapping
const numbers = [1, 2, 3, 4, 5];
function doubleValues(numbers){
    return numbers.map(num => num * 2);
}
console.log(doubleValues(numbers));


//8. Find Maximum
const arr1=[1,2,6];
const arr2=[3,9,7];
const mergedArray= [...arr1,...arr2];
console.log(mergedArray);
function findMax(mergedArray){
    return Math.max(...mergedArray);
}
console.log(findMax(mergedArray)); ///////////////checkkkkk issue


//9. Object and Array Destructuring
const data = [{name: "Bob", age: 24}, {name: "Alice", age: 28}];
//Write a function that extracts the age as  “24”  and name as “Alice” and returns a sentence: "Alice’s age is 24."
function extractInfo2(data){
    const [{age}, {name}] = data;
    return `${name}'s age is ${age}.`;
}
console.log(extractInfo2(data));




//10. Data Manipulation using Array functions
const inputData = [{
"id": 1,
"title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
"price": 109.95,
"description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
"category": "men's clothing",
"image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
"rating": {
"rate": 3.9,
"count": 120
}
}];

function selectedKeys(data){
    return data.map (item => {
        const {id, title, rating} = item; //destructuring nested feilds
        const {rate, count} = rating; // destructure nested rating
        return {id, title, rate, count}; //creating new object with selected keys
    });
}

console.log(selectedKeys(inputData));

//11. Default parameter output
const fun = (name = "abc") => {
        if (name) {
          console.log("if", name);
        } else {
          console.log("else", name);
        }
      };
	  
fun(""); 

//output: else

//12. Deep clone
function deepClone(obj) {
  // Handle null or non-object values (base case)
  if (obj === null || typeof obj !== "object") {
    return obj;
  }

  // Handle arrays
  if (Array.isArray(obj)) {
    return obj.map(item => deepClone(item));
  }

  // Handle objects
  const clonedObj = {};
  for (let key in obj) {
    if (obj.hasOwnProperty(key)) {
      clonedObj[key] = deepClone(obj[key]);
    }
  }
  return clonedObj;
}

const obj = { 
  a: 1, 
  b: { c: 2, d: [3, 4] } 
};

const cloned = deepClone(obj);
cloned.b.c = 42;
cloned.b.d.push(5);

console.log(obj.b.c); // 2
console.log(obj.b.d); // [3, 4]


//13. Flattening an Array
function flattenArray(arr) {
  let result = [];

  for (let item of arr) {
    if (Array.isArray(item)) {
      result = result.concat(flattenArray(item)); // Recursive call
    } else {
      result.push(item);
    }
  }

  return result;
}

console.log(flattenArray([1, [2, [3, [4, 5]]]]));
// Output: [1, 2, 3, 4, 5]
