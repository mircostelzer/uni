function after(time) {
	return new Promise( (res) => setTimeout( ()=>res(time+'ms'), time) )
};

export default after;