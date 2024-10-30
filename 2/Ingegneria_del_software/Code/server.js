// const { createServer } = require('http');

// const hostname = '127.0.0.1';
// const port = 3000;

// const server = createServer((req, res) => {
//   res.statusCode = 200;
//   res.setHeader('Content-Type', 'text/plain');
//   res.end('Hello World');
// });

// server.listen(port, hostname, () => {
//   console.log(`Server running at http://${hostname}:${port}/`);
// });

import express from "express";
const app = express();
const port = 8080;

app.use( express.json() );
app.use( express.urlencoded( { extended: true }))

app.get("/", (req, res) => {
  res.json({message: "Hello World"});
})

app.post(`api/v1/authentications`, (req, res) => {
  console.log(req.body)
} )

app.listen(port, () => {
  console.log(`Example listening on port ${port}`);
})
