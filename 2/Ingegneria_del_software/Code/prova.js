console.log("Hello World!")
var list = [1, 2, 3]
list.forEach(console.log)

function myFunction() {

    for (var i=0; i<5; i++) {
        console.log( i )
    }

    i = 10
    console.log(i)


}

console.log(sum(3))

/**  
 * @param {number} value
 * @returns {undefined}
 */
var myFun = value => console.log(value)
myFun("ciao")

const compact = (array) => {
        return array.filter(value => value)
    }
    const data = [0, 1, false, 2, undefined, '', 3, null];
    console.log(compact(data)) // [1, 2, 3]

/**
 *   @param {Array} array
 *   @returns {Array}
 */    
    
    
const flatten = (array) => {
    return array.reduce(
        (/** @type {number[]} */ acc, /** @type {number} */ val) =>
            acc.concat( (Array.isArray(val) ? flatten(val) : val)), 
        [] )
}
        
const data1 = [1, 2, [3, 4, [5]]];
console.log(flatten(data1)); // [1, 2, 3, 4, 5]

var mod = (a, b) =>  a%b;
console.log(typeof mod);

var a = 5;

function sum(x) {
    return this + x;
}
var bs = sum.bind(a);

console.log(sum.call(2, 3));

var a = 1;

function f() {
    console.log(a);
    var a = 10;
}
f();

function binarySearch(v, n, x) {
    var start = 0;
    var end = n-1;
    var mid;
    while (start <= end) {
        mid = Number.parseInt((end+start)/2);
        if (v[mid] === x) return mid;
        if (v[mid] < x) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return -1;
}

var arr = [1, 3, 6, 7, 12];

console.log(binarySearch(arr, arr.length, 7));