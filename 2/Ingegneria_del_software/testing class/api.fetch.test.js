const fetch = require("node-fetch");
const url = process.env.API_URL || "https://easy-lib.onrender.com/api/v1"
it('works with get', async () => {
    expect.assertions(1);
    expect( ( await fetch(url+"/books") ).status ).toEqual(200);
})