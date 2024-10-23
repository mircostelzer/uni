// var fs = require( "fs" );
// var data = fs.readFileSync( "prova.js", "utf8" );
// console.log( data );
// console.log( "Program ended" );

// var fs = require( "fs" );
// fs.readFile( "file.txt", "utf8", function(error, data) {
//     console.log(data);
// } );
// console.log("Program ended.");

// setTimeout(()=>{
// 	console.log('1000ms');
// 	setTimeout(()=>{
// 		console.log('5000ms')
// 	}, 5000)
// }, 1000)

// setTimeout(() => console.log("1s"), 1000)

// var i = 0;

// function fn() {
// 	i++
// 	setTimeout(fn, 0);
// }

// fn();

const promise = new Promise( (res, rej) => {
	setTimeout( () => {
		res();
	}, 2000 )
} )

promise.then( () => {
	console.log("Resolved");
	return Promise.reject("Errore");
} )
.catch( err => console.log(err) )
.then( () => console.log("end"));


import after from "./after.js";
var promisifiedTimeout =  after;

promisifiedTimeout(1000) // first wait for 1 second
.then( resolvedValue=>console.log(resolvedValue) ) // '1000ms'
.then( resolvedValue=>{return promisifiedTimeout(5000)} ) // then wait for additional 5
.then( console.log ) // '5000ms'

async function asyncFunction() {
	promisifiedTimeout(1000);
	await promisifiedTimeout(1000);
	console.log("done");
	return "done";
}

console.log( asyncFunction() );